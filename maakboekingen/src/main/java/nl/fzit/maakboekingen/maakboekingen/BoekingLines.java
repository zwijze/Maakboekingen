package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;
import java.util.List;

import  nl.fzit.maakboekingen.config.*;

public class BoekingLines {

	private ArrayList<String[]> BoekingenLines;
	
	public ArrayList<String[]> getBoekingenLines(){
		return BoekingenLines;
	}
	
	public void stelSamenBoekingenLines(Config config,ArrayList<String[]> boekingenList){
		ArrayList<Object[]> boekingLines=new ArrayList<Object[]>();
		Object object[]=new Object[5];
		object[0]=2;
		object[1]="bla";
		int size;
		
		String bookingAccountForAccountNumber;
		List<AccountType> accountList;

		accountList=config.getAccounts().getAccountList();
				
		size=accountList.size();
		
		bookingAccountForAccountNumber=accountList.get(0).getAccountNumber();
		
		for (String[] boeking :boekingenList){
			
			
			boekingLines.add(object);	
			
		}
	}
	

	
}
