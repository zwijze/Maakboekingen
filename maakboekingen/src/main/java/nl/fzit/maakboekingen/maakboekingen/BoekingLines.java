package nl.fzit.maakboekingen.maakboekingen;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.emory.mathcs.backport.java.util.Arrays;
import  nl.fzit.maakboekingen.config.*;

public class BoekingLines {

	private ArrayList<String[]> BoekingenLines;
	
	public ArrayList<String[]> getBoekingenLines(){
		return BoekingenLines;
	}
	
	public void stelSamenBoekingenLines(Config config,ArrayList<String[]> boekingenList) throws ParseException{
		ArrayList<String[]> boekingLines=new ArrayList<String[]>();
		String bookingDescriptionUsedToBook;
		List<AccountType> accounts;
		List<CounterBookingLineType> counterBookingLineConfigList;
		BigDecimal percentageOfTotalAmount;
		//boekingline:
		//[0]:Datum
		//[1]:Omschrijving van de boeking die geboekt wordt
		//[2]:Boekingaccount zoals genoemd in het boekhoudprogramma
		//[3]:Bedrag		
		//[4]:Omschrijving van de boeking zoals op het bankafschrift
		
		String[] boekingline=new String[6];
	
		
		accounts=config.getAccounts().getAccountList();

		
		for (String[] boeking :boekingenList){
			BookingType booking;
			//Find own accountnumber in configuration
			AccountType account=accounts.stream().filter(a->boeking[0].equals(a.getAccountNumber())).findFirst().get();
			if (account==null){
				System.out.printf("Booking doesn't match criteria in config based on AccountNumber: %s. This booking won't be booked:%s|%s|%s|%s|%s|%s\n",account.getAccountNumber(),boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
				continue;	
			}
			
			//1. Booking line of account
			//Datum
			boekingline[0]=boeking[2];

			try {
				booking=account.getBookings().getBookingList().stream().filter(a->boeking[4].equals(a.getCounterAccountNumber()) && (boeking[5].contains(a.getBookingDescription()) || boeking[5].equals(""))).findFirst().get();
			} catch (NoSuchElementException e){
				System.out.printf("Booking doesn't match criteria in config based on CounterAccountNumber/BookingDescription: %s. This booking won't be booked:%s|%s|%s|%s|%s|%s\n",account.getAccountNumber(),boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
				continue;
			}
			bookingDescriptionUsedToBook=booking.getBookingDescriptionUsedToBook();

			if (bookingDescriptionUsedToBook.contains("yyyy")){
				bookingDescriptionUsedToBook=fillDateInBookingDescriptionToBook(booking,bookingDescriptionUsedToBook,boeking[2]);
			}
			
			//Omschrijving van de boeking die geboekt wordt
			boekingline[1]=bookingDescriptionUsedToBook;

			//Boekingaccount zoals genoemd in het boekhoudprogramma
			boekingline[2]=account.getBookingAccountForAccountNumber();

			//Bedrag
			if (boeking[1]=="D") {
				boekingline[3]=boeking[3];
			} else {
				boekingline[3]="-" + boeking[3];
			}
			
			//Omschrijving van de boeking zoals op het bankafschrift
			boekingline[4]=boeking[5];
	
			boekingline[5]=boeking[6];
					
			boekingLines.add(boekingline);

			//2. Booking lines of counterbookings
			counterBookingLineConfigList=booking.getCounterBookingLines().getCounterBookingLineList();
			for (CounterBookingLineType counterBookingLineConfig :counterBookingLineConfigList){
				boekingline=new String[5];

				//Datum
				boekingline[0]=boeking[2];

				//Omschrijving van de boeking die geboekt wordt
				boekingline[1]=bookingDescriptionUsedToBook;

				//Boekingaccount zoals genoemd in het boekhoudprogramma
				boekingline[2]=counterBookingLineConfig.getBookingAccount();

				//Bedrag
				try {
					percentageOfTotalAmount=counterBookingLineConfig.getPercentageOfTotalAmount();
				}
				catch (NoSuchElementException e){
					percentageOfTotalAmount=BigDecimal.valueOf(100);
				}
				
				if (counterBookingLineConfig.getDebitCredit().toString()=="D") {
					boekingline[3]=amountMultipliedByPercentageOfTotalAmount(boeking[3],percentageOfTotalAmount);
				} else {
					boekingline[3]=amountMultipliedByPercentageOfTotalAmount("-" + boeking[3],percentageOfTotalAmount);
				}
				
				//Omschrijving van de boeking zoals op het bankafschrift
				boekingline[4]=boeking[5];
						
				boekingLines.add(boekingline);				
				
				
			}	
		}
	}


		private String fillDateInBookingDescriptionToBook(BookingType booking,String bookingDescriptionUsedToBook,String dateString) throws ParseException
		{		
			int AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook=0;
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat sdfYyyyymmdd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat sdfYyyyymm = new SimpleDateFormat("yyyy-MM");
			SimpleDateFormat sdfYyyyy = new SimpleDateFormat("yyyy");

			Date convertedDate = sdfYyyyymmdd.parse(dateString.substring(0, 4) + "-" + dateString.substring(4, 6) + "-" + dateString.substring(6, 8));
			calendar.setTime(convertedDate);

			try {
				AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook=booking.getAddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook().intValue();
			}
			catch (NullPointerException e) {
				AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook=0;
			}
			
			if (bookingDescriptionUsedToBook.contains("yyyymmdd")){
				calendar.add(Calendar.DAY_OF_MONTH, AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook);
				return bookingDescriptionUsedToBook.replace("yyyymmdd",String.valueOf(calendar.get(Calendar.YEAR))+String.valueOf(calendar.get(Calendar.MONTH)+1)+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
			} else if (bookingDescriptionUsedToBook.contains("yyyymm")){
				calendar.add(Calendar.MONTH, AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook);
				return bookingDescriptionUsedToBook.replace("yyyymm",String.valueOf(calendar.get(Calendar.YEAR))+String.valueOf(calendar.get(Calendar.MONTH)+1));
			} else if (bookingDescriptionUsedToBook.contains("yyyy")){
				calendar.add(Calendar.YEAR, AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook);
				return bookingDescriptionUsedToBook.replace("yyyy",String.valueOf(calendar.get(Calendar.YEAR)));			
			} else {
				return bookingDescriptionUsedToBook;
			}	
			
		}	
	
		private String amountMultipliedByPercentageOfTotalAmount(String amount,BigDecimal percentageOfTotalAmount){
			Double amountDouble;
			
			DecimalFormat twoDForm=new DecimalFormat("#.##");
			amount=amount.replaceAll(",",".");
			amountDouble=percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",","."))).doubleValue()/100;
			
			return twoDForm.format(amountDouble);
//			return Double.toString(percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",",""))).doubleValue()/10000);
			
//			return Double.toString(Double.valueOf(twoDForm.format(percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",",""))).doubleValue()/10000)));
		}
}
