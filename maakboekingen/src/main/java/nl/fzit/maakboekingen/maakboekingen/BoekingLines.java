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

	private ArrayList<String[]> boekingLines;
	
	public ArrayList<String[]> getBoekingenLines(){
		return boekingLines;
	}
	
	public void stelSamenBoekingenLines(Config config,ArrayList<String[]> boekingenList) throws ParseException{
		//ArrayList<String[]> boekingLines=new ArrayList<String[]>();
		boekingLines=new ArrayList<String[]>();
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
		//[5]:Currency
		//[6]:Boeking nbr.
		String[] boekingline;
		int i=0;
		
		accounts=config.getAccounts().getAccountList();

		
		for (String[] boeking :boekingenList){
			boekingline=new String[7];
			i++;
			BookingType booking;
			//Find own accountnumber in configuration
			AccountType account=accounts.stream().filter(a->boeking[0].equals(a.getAccountNumber())).findFirst().orElse(null);
			if (account==null){
				System.out.printf("Booking doesn't match criteria in config based on AccountNumber. This booking won't be booked:%s|%s|%s|%s|%s|%s\r\n",boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
				continue;	
			}
			
			//1. Booking line of account
			//Datum
			boekingline[0]=boeking[2];
			
			////boeking[4]=Tegenrekening, boeking[5]=Omschrijving
			//Neem bookingline van config.xml waar de (boeking matched met tegenrekeningBookingline of tegenrekeningBookingline=niet gevuld) en (boeking matched met OmschrijvingBookingline of OmschrijvingBookingline=niet gevuld) en niet (tegenrekeningBookingline=niet gevuld en OmschrijvingBookingline=niet gevuld) 
			try {
//				booking=account.getBookings().getBookingList().stream().filter(a->(boeking[4].equals(a.getCounterAccountNumber()) || a.getCounterAccountNumber().equals("")) && (boeking[5].contains(a.getBookingDescription()) || a.getBookingDescription().equals("")) && !(a.getCounterAccountNumber().equals("") && a.getBookingDescription().equals("") )).findFirst().get();
				booking=account.getBookings().getBookingList().stream().filter(a->(boeking[4].equalsIgnoreCase(a.getCounterAccountNumber()) || a.getCounterAccountNumber().equals("")) && (boeking[5].toLowerCase().contains(a.getBookingDescription().toLowerCase()) || a.getBookingDescription().equals("")) && !(a.getCounterAccountNumber().equals("") && a.getBookingDescription().equals("") )).findFirst().get();
			} catch (NoSuchElementException e){
				System.out.printf("Booking doesn't match criteria in config based on CounterAccountNumber/BookingDescription: This booking won't be booked:%s|%s|%s|%s|%s|%s\r\n",boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
				continue;
			}
			bookingDescriptionUsedToBook=booking.getBookingDescriptionUsedToBook();

			if (bookingDescriptionUsedToBook.equals("")){
				bookingDescriptionUsedToBook=boeking[5];
			}
			if (bookingDescriptionUsedToBook.contains("yyyy")){
				bookingDescriptionUsedToBook=fillDateInBookingDescriptionToBook(booking,bookingDescriptionUsedToBook,boeking[2]);
			}
			
			//Omschrijving van de boeking die geboekt wordt
			boekingline[1]=bookingDescriptionUsedToBook;

			//Boekingaccount zoals genoemd in het boekhoudprogramma
			boekingline[2]=account.getBookingAccountForAccountNumber();

			//Bedrag
			if (boeking[1].equals("D")) {
				boekingline[3]=boeking[3];
			} else {
				boekingline[3]="-" + boeking[3];
			}
			
			//Omschrijving van de boeking zoals op het bankafschrift
			boekingline[4]=boeking[5];
	
			//Currency
			boekingline[5]=boeking[6];
			//Nbr booking	
			boekingline[6]=String.valueOf(i);

			
			boekingLines.add(boekingline);

			//2. Booking lines of counterbookings
			counterBookingLineConfigList=booking.getCounterBookingLines().getCounterBookingLineList();
			for (CounterBookingLineType counterBookingLineConfig :counterBookingLineConfigList){
				boekingline=new String[7];

				//Datum
				boekingline[0]=boeking[2];

				//Omschrijving van de boeking die geboekt wordt
				boekingline[1]=bookingDescriptionUsedToBook;

				//Boekingaccount zoals genoemd in het boekhoudprogramma
				boekingline[2]=counterBookingLineConfig.getBookingAccount();

				//Bedrag
				percentageOfTotalAmount=counterBookingLineConfig.getPercentageOfTotalAmount();
				if (percentageOfTotalAmount==null) percentageOfTotalAmount=BigDecimal.valueOf(100);
				
				if (counterBookingLineConfig.getDebitCredit().toString()=="D") {
					boekingline[3]=amountMultipliedByPercentageOfTotalAmount(boeking[3],percentageOfTotalAmount);
				} else {
					boekingline[3]=amountMultipliedByPercentageOfTotalAmount("-" + boeking[3],percentageOfTotalAmount);
				}
				
				//Omschrijving van de boeking zoals op het bankafschrift
				boekingline[4]=boeking[5];

				//Currency
				boekingline[5]=boeking[6];
				//Nbr booking	
				boekingline[6]=String.valueOf(i);

				boekingLines.add(boekingline);				
				
				
			}	
		}
	}


		private String fillDateInBookingDescriptionToBook(BookingType booking,String bookingDescriptionUsedToBook,String dateString) throws ParseException
		{	
			String dateMonth,dateDay;
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
				dateDay="0"+String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
				dateDay=dateDay.substring(dateDay.length()-2, dateDay.length());
				return bookingDescriptionUsedToBook.replace("yyyymmdd",String.valueOf(calendar.get(Calendar.YEAR))+String.valueOf(calendar.get(Calendar.MONTH)+1)+dateDay);
			} else if (bookingDescriptionUsedToBook.contains("yyyymm")){
				calendar.add(Calendar.MONTH, AddExtraYearsMonthsDaysToDateInBookingDescriptionUsedToBook);
				dateMonth="0"+String.valueOf(calendar.get(Calendar.MONTH)+1);
				dateMonth=dateMonth.substring(dateMonth.length()-2, dateMonth.length());
				return bookingDescriptionUsedToBook.replace("yyyymm",String.valueOf(calendar.get(Calendar.YEAR))+dateMonth);
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
			twoDForm.setMinimumFractionDigits(2);
			twoDForm.setMaximumFractionDigits(2);
			amountDouble=percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",","."))).doubleValue()/100;
			
			return twoDForm.format(amountDouble).replaceAll(",",".");
//			return Double.toString(percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",",""))).doubleValue()/10000);
			
//			return Double.toString(Double.valueOf(twoDForm.format(percentageOfTotalAmount.multiply(new BigDecimal(amount.replaceAll(",",""))).doubleValue()/10000)));
		}
}
