package nl.fzit.MaakBoekingGnuCash;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import nl.fzit.maakboekingen.makebooking.api.*;
import nl.fzit.sql.*;
import nl.fzit.maakboekinggnucash.configgnucash.*;

public class MaakBoeking implements IMakebooking {

	private Sql sql;
	private ConfigGnuCash configGnuCash;
	private String configPath;
	
	public MaakBoeking() throws ClassNotFoundException, SQLException{
		ConfigGnuCash configGnuCash=new ConfigGnuCash();
		configPath="plugins\\config\\configGnuCash.xml";
	
		try {
			
            // note that you can use multiple bindings with the same class, in
            //  which case you need to use the getFactory() call that takes the
            //  binding name as the first parameter
            IBindingFactory bfact = BindingDirectory.getFactory(ConfigGnuCash.class);
            
            // unmarshal customer information from file
            IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
            FileInputStream in = new FileInputStream(configPath);            
            configGnuCash = (ConfigGnuCash)uctx.unmarshalDocument(in, null);
            // you can add code here to alter the unmarshalled customer
            
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
            System.exit(1);
		} catch (JiBXException e) {
			e.printStackTrace();
            System.exit(1);
		}

		sql=new Sql();
	
		sql.makeConnection(configGnuCash.getDatabaseBookingProgram().getDbms(), configGnuCash.getDatabaseBookingProgram().getServerName(), configGnuCash.getDatabaseBookingProgram().getPortNumber(), configGnuCash.getDatabaseBookingProgram().getProtocol(), configGnuCash.getDatabaseBookingProgram().getDbName(), configGnuCash.getDatabaseBookingProgram().getDomain(), configGnuCash.getDatabaseBookingProgram().getUser(), configGnuCash.getDatabaseBookingProgram().getPassword());

	}
	
	public void test(){
		System.out.printf("testje invoke");
	}

	public void test2(ArrayList<String[]> xyz){
		System.out.printf("testje invoke");
	}
	
	public void insertBookingLines(ArrayList<String[]> bookingLines) throws SQLException{
		//boekingline:
		//[0]:Datum
		//[1]:Omschrijving van de boeking die geboekt wordt
		//[2]:Boekingaccount zoals genoemd in het boekhoudprogramma
		//[3]:Bedrag		
		//[4]:Omschrijving van de boeking zoals op het bankafschrift
		//[5]:Currency
		
		String postDate;
		String enterDate;
		String description;
		String bookingAccount;
		String amount;
		String descriptionBankStatement;
		String currency;
		String bookingNbr;
		String bookingNbrPrevious="";
		String accountGuid;
		String currencyGuid;
		String transactionGuid="";
		Calendar calendar;
		
	
		calendar=Calendar.getInstance();
		enterDate=calendar.YEAR+calendar.MONTH+calendar.DAY_OF_MONTH+"000000";
		
		for (String [] bookingLine:bookingLines){
			postDate=bookingLine[0];
			description=bookingLine[1];
			bookingAccount=bookingLine[2];
			amount=bookingLine[3];
			descriptionBankStatement=bookingLine[4];
			currency=bookingLine[5];
			bookingNbr=bookingLine[6];
			
			accountGuid=getAccountGuid(bookingAccount);
			if (accountGuid.equals("")){
				System.out.printf("Unknown account %s, no booking made on this account for bookingline: %s,%s,%s\n",bookingAccount,postDate,amount,descriptionBankStatement);
				continue;	
			}
			
			currencyGuid=getCurrencyGuid(currency);
			if (currencyGuid.equals("")){
				System.out.printf("Unknown account %s, no booking made on this account for bookingline: %s,%s,%s\n",bookingAccount,postDate,amount,descriptionBankStatement);
				continue;	
			}
			
			//Insert transaction (booking)
			if (!bookingNbr.equals(bookingNbrPrevious)){
				transactionGuid=generateGuid();
				sql.sqlInsert("INSERT INTO transactions (guid,currency_guid,post_date,enter_date,description) VALUES ('" + transactionGuid + "','" + currencyGuid + "','" + postDate + "','" + description + "')");
			}
			
			//Insert splits (bookingline)
			sql.sqlInsert("INSERT INTO transactions (guid,tx_guid,account_guid,reconcile_state,value_num,value_denom,quantity_num,quantity_denom) VALUES ('" + generateGuid() + "','" + transactionGuid + "','" + accountGuid + "','N','" + amount.replace(".", "")  + "','100','" + amount.replace(".", "")  + "','100')");
			
			
			bookingNbrPrevious=bookingNbr;
		}
		
	}
	
	private String getAccountGuid(String account) throws SQLException{
		int i=0;
		String accountGuid1Up="";
		String accountGuid="";
		String[] splitAccounts=account.split(":");
		
		for (String splitAccount:splitAccounts){
			if (accountGuid1Up.equals("")){
				accountGuid=sql.sqlQueryResult("select guid from accounts where name='" + splitAccounts[i] + "'").get(0)[0];
			} else {
				accountGuid=sql.sqlQueryResult("select guid from accounts name='" + splitAccounts[i] + "' and parent_guid='" + accountGuid1Up + "'").get(0)[0];
			}
			
			accountGuid1Up=splitAccounts[i];
			i++;	
		}
		
		return accountGuid;
	}

	private String getCurrencyGuid(String currency) throws SQLException{

		return sql.sqlQueryResult("select guid from commodities where mnemonic='" + currency + "'").get(0)[0];
	}
	
	private String generateGuid(){
		
		return UUID.randomUUID().toString();
		
	}
	
	private void unMarschallConfigFile(String configFile) throws JiBXException, FileNotFoundException{
        IBindingFactory bfact = BindingDirectory.getFactory(ConfigGnuCash.class);
        
        // unmarshal information from file
        IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
        FileInputStream in = new FileInputStream(configFile);
        this.configGnuCash = (ConfigGnuCash)uctx.unmarshalDocument(in, null);
	}
	
}
