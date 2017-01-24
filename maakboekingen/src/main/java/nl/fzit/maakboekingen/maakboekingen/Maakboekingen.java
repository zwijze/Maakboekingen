package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;
import java.net.*;
import nl.fzit.files.*;
import nl.fzit.maakboekingen.config.*;
import nl.fzit.maakboekingen.makebooking.api.IMaakboeking;
import nl.fzit.makebooking.api.*;
import nl.fzit.sql.api.ISql;

import java.io.File;
import java.io.IOException;


public class Maakboekingen {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
		// TODO Auto-generated method stub
		ArrayList<String> bestandenList;
		Config config=new Config();
		
		FilesDirectories filesDirectories=new FilesDirectories();
		bestandenList=filesDirectories.bepaalInTeLezenBestanden("1","2");
		
		//LeesBoeking object maken t.b.v. inlezen boekingen uit een bestand
		LeesBoekingen leesBoekingen=new LeesBoekingen();
		
		//MaakBoeking object maken o.b.v. plugin
		IMaakboeking maakBoeking=maakBoekingObject(config); 
		
		//Creer Sql connection naar database waarin de boekingen moet komen
		ISql sql=maakSqlObject(config);
		
		
		for (String bestand :bestandenList){
			leesBoekingen.inlezenBestand(bestand,config.getTransactionsFiles().getRegexBeginBalance(),config.getTransactionsFiles().getRegexBookingDateAndAmount(),config.getBookings().getAccount().getBooking().getBookingDescription(),config.getTransactionsFiles().getRegexEndBalance());
			
		}
		
	}
	
	private static IMaakboeking maakBoekingObject(Config config) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
		File dir = new File(config.getPluginDirectory());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginBookingProgram()); // must be in package.class name format
		
		IMaakboeking modInstance = (IMaakboeking)loadedClass.newInstance();
		
		return modInstance;
		
	}

	
	private static ISql maakSqlObject(Config config) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		File dir = new File(config.getPluginDirectory());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginSql()); // must be in package.class name format
		
		ISql modInstance = (ISql)loadedClass.newInstance();
		
		return modInstance;
		
	}
	
}
