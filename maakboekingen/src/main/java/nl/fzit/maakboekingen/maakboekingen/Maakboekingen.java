package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;
import java.net.*;
import nl.fzit.files.*;
import nl.fzit.maakboekingen.config.*;
import nl.fzit.makebooking.api.IMaakboeking;
import java.io.File;


public class Maakboekingen {

	public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		ArrayList<String> bestandenList;
		Config config=new Config();
		
		FilesDirectories filesDirectories=new FilesDirectories();
		bestandenList=filesDirectories.bepaalInTeLezenBestanden("1","2");
		
		IMaakboeking maakBoeking=maakBoekingObject(config); 
		
		for (String bestand :bestandenList){
			
		}
		
	}
	
	private static IMaakboeking maakBoekingObject(Config config) throws MalformedURLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	
		File dir = new File(config.getPluginDirectoryBookingProgram());
		URL loadPath = dir.toURI().toURL();
		URL[] classUrl = new URL[]{loadPath};

		ClassLoader cl = new URLClassLoader(classUrl);

		Class loadedClass = cl.loadClass(config.getClassNamePluginBookingProgram()); // must be in package.class name format
		
		IMaakboeking modInstance = (IMaakboeking)loadedClass.newInstance();
		
		return modInstance;
		
	}

}
