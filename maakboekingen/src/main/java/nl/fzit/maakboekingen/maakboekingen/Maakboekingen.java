package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import java.net.*;
import nl.fzit.files.*;
import nl.fzit.maakboekingen.config.*;
import nl.fzit.maakboekingen.makebooking.api.*;
import nl.fzit.sql.api.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Maakboekingen {
	
	private Config config;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, JiBXException {
		// TODO Auto-generated method stub
		ArrayList<String> bestandenList;
		ArrayList<String[]> boekingen=new ArrayList<String[]>();
		
		Maakboekingen maakboekingen=new Maakboekingen();
		maakboekingen.unMarschallConfigFile(args[0]);
		
		FilesDirectories filesDirectories=new FilesDirectories();
		bestandenList=filesDirectories.bepaalInTeLezenBestanden(maakboekingen.config.getTransactionsFiles().getDirectoryTransactionFiles(),maakboekingen.config.getTransactionsFiles().getTransactionFilesToReadRegex());
		
		//LeesBoeking object maken t.b.v. inlezen boekingen uit een bestand
		LeesBoekingen leesBoekingen=new LeesBoekingen();
		
		
		for (String bestand :bestandenList){
			leesBoekingen.inlezenBestand(bestand,maakboekingen.config.getTransactionsFiles().getAccountNumberRegex(),maakboekingen.config.getTransactionsFiles().getBeginBalanceRegex(),maakboekingen.config.getTransactionsFiles().getBookingDateAndAmountRegex(),maakboekingen.config.getAccounts().getAccount().getBooking().getBookingDescriptionRegex(),maakboekingen.config.getTransactionsFiles().getEndBalanceRegex());
		}
		
		//MaakBoeking object maken o.b.v. plugin
		IMakebooking maakBoeking=maakBoekingObject(maakboekingen.config); 
		
		//Creer Sql connection naar database waarin de boekingen moet komen o.b.v. plugin
		ISql sql=maakSqlObject(maakboekingen.config);
		
	
	
	}
	
	private static IMakebooking maakBoekingObject(Config config) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
		File dir = new File(config.getJarFilePluginBookingProgram());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginBookingProgram());
		
		IMakebooking modInstance = (IMakebooking)loadedClass.newInstance();
		
		return modInstance;
		
	}

	
	private static ISql maakSqlObject(Config config) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		File dir = new File(config.getJarFilePluginSql());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginSql()); // must be in package.class name format
		
		ISql modInstance = (ISql)loadedClass.newInstance();
		
		return modInstance;
		
	}
	
	
	private void unMarschallConfigFile(String configFile) throws JiBXException, FileNotFoundException{
        IBindingFactory bfact = BindingDirectory.getFactory(Config.class);
        
        // unmarshal information from file
        IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
        FileInputStream in = new FileInputStream(configFile);
        this.config = (Config)uctx.unmarshalDocument(in, null);
	}
	
}
