package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;

import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

import java.net.*;
import java.sql.SQLException;
import java.text.ParseException;

import nl.fzit.files.*;
import nl.fzit.maakboekingen.config.*;
import nl.fzit.maakboekingen.maakboekingen.BoekingLines;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Maakboekingen {
	
	private Config config;
	
	public Maakboekingen(){
		config=new Config();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, JiBXException, ParseException, SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
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
			leesBoekingen.inlezenBestand(bestand,maakboekingen.config.getTransactionsFiles().getAccountNumberRegex(),maakboekingen.config.getTransactionsFiles().getBeginBalanceRegex(),maakboekingen.config.getTransactionsFiles().getBookingDateAndAmountRegex(),maakboekingen.config.getTransactionsFiles().getEndBalanceRegex());
		}

		///Stel de boekingLines samen
		BoekingLines boekingLines=new BoekingLines();
		boekingLines.stelSamenBoekingenLines(maakboekingen.config, leesBoekingen.getBoekingen());
		
		
		//Creer Sql connection naar database waarin de boekingen moet komen o.b.v. plugin
//		ISql sql=maakSqlObject(maakboekingen.config);
//		sql.makeConnection("sqlite", "", "", "" ,"C:\\mijn documenten\\Maakboekingen\\GnuCashSqlite\\fz-it-jaar-2016.gnucash", "", "", "");
		//		sql.makeConnection(maakboekingen.config.getDatabaseBookingProgram().getDbms(),"","","",maakboekingen.config.getDatabaseBookingProgram().getDbName(),"","", "");
		//MaakBoeking object maken o.b.v. plugin
		//IMakebooking maakBoeking=maakBoekingObject(maakboekingen.config);
		//IMakebooking maakBoeking=maakboekingen.maakBoekingObject(maakboekingen.config);
		//Maakboekingen.method.invoke(maakBoeking, null);
		maakboekingen.invokeInsertBookingLinesOfPluginBookingProgram(maakboekingen.config,boekingLines.getBoekingenLines());
		
//		maakBoeking.insertBookingLines(sql,boekingLines.getBoekingenLines());
		
		//To avoid the problem 'JDWP Unable to get JNI 1.2 environment' put this at the end of the main method:
		System.exit(0);	
	}
	private void invokeInsertBookingLinesOfPluginBookingProgram(Config config,ArrayList<String[]> boekingenLinesArrayList) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		
        try {
	        // Create a new JavaClassLoader
	        ClassLoader classLoader = this.getClass().getClassLoader();
	        
	        // Load the target class using its binary name
	        Class loadedPluginBookingProgramClass = classLoader.loadClass(config.getClassNamePluginBookingProgram());

	        System.out.println("Loaded plugin: " + loadedPluginBookingProgramClass.getName());
	        // Create a new instance from the loaded class
	        Constructor constructorPluginBookingProgramClass = loadedPluginBookingProgramClass.getConstructor();
	        Object pluginBookingProgramObject = constructorPluginBookingProgramClass.newInstance();
	        // Getting the target method from the loaded class and invoke it using its name
	        Method methodInsertBookingLines = loadedPluginBookingProgramClass.getMethod("insertBookingLines",ArrayList.class);
	        //System.out.println("Invoked method name: " + methodInsertBookingLines.getName());
	        methodInsertBookingLines.invoke(pluginBookingProgramObject,boekingenLinesArrayList);

        } catch (ClassNotFoundException e) {
        	e.printStackTrace();
        } catch (Exception e) {
        	e.printStackTrace();
        }
/*		File dir = new File(config.getJarFilePluginBookingProgram());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginBookingProgram());
		
		IMakebooking modInstance = (IMakebooking)loadedClass.newInstance();
		
		//Method method=loadedClass.getMethod("insertBookingLines");

		Method method=loadedClass.getMethod("test");
		method.invoke(modInstance);
		
		return modInstance;
*/		
	}

	

	
	
	private void unMarschallConfigFile(String configFile) throws JiBXException, FileNotFoundException{
        IBindingFactory bfact = BindingDirectory.getFactory(Config.class);
        
        // unmarshal information from file
        IUnmarshallingContext uctx = bfact.createUnmarshallingContext();
        FileInputStream in = new FileInputStream(configFile);
        this.config = (Config)uctx.unmarshalDocument(in, null);
	}
	
}
