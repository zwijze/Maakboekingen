package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.emory.mathcs.backport.java.util.Arrays;
import  nl.fzit.maakboekingen.config.*;

public class BoekingLines {

	private ArrayList<String[]> BoekingenLines;
	
	public ArrayList<String[]> getBoekingenLines(){
		return BoekingenLines;
	}
	
	public void stelSamenBoekingenLines(Config config,ArrayList<String[]> boekingenList){
		ArrayList<String[]> boekingLines=new ArrayList<String[]>();

		//boeingline:
		String[] boekingline=new String[6];
	
		Object object[]=new Object[5];
		object[0]=2;
		object[1]="bla";
		int size;
		
//		String bookingAccountForAccountNumber;
		List<AccountType> accountsListConfig;
//		AccountType accountListConfig;
		
//		String stringList[]=new String[]{"spring","node"};
//		List<String> lines=Arrays.asList(stringList);
//		List<String> result=lines.stream().filter(line->!"Mykong".equals(line)).collect(Collectors.toList());
		
		accountsListConfig=config.getAccounts().getAccountList();

		
//		size=accountListConfig.size();
		
//		bookingAccountForAccountNumber=accountListConfig.get(0).getAccountNumber();

//		int i=0;
		for (String[] boeking :boekingenList){
			
			//Find own accountnumber in configuration
			AccountType accountListConfig=accountsListConfig.stream().filter(a->boeking[0].equals(a.getAccountNumber())).findFirst().get();
			if (accountListConfig==null){
				System.out.printf("Own Account not found in configuartion: %s. This booking won't be booked:%s|%s|%s|%s|%s|%s\n",accountListConfig.getAccountNumber(),boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
				break;	
			}
			
			
			System.out.printf("Account found: (%s)",accountListConfig.getAccountNumber());
			//			boekingLines.add(object);	
//			i++;

		}	
	}
	

	
}
