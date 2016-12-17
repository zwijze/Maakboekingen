package nl.fzit.files;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilesDirectories {

	static public boolean deleteDirectory(String directoryNaam) {
//	static public boolean deleteDirectory(String directoryName) {
		File directory=new File(directoryNaam);
		if( directory.exists() ) {
		File[] files = directory.listFiles();
		for(int i=0; i<files.length; i++) {
		if(files[i].isDirectory()) {
		deleteDirectory(files[i].toString());
		}
		else {
		files[i].delete();
		}
		}
		}
		return( directory.delete() );
		}
	
	static public boolean maakDirectory(String directoryNaam){
		boolean result=false;
		
		File directory = new File(directoryNaam);

		try{
			result=directory.mkdir();
	    } 
	    catch(SecurityException se){
	        //handle it
	    	result=false;
	    }        
		
		System.out.println("\nDirectory gemaakt?" + result);
		
		return result;
		
	}
	
	
	public ArrayList<String> bepaalInTeLezenBestanden(String directoryNaam,String regexBestanden){
		
		ArrayList<String> bestanden=new ArrayList<String>();
		Pattern pBestanden = Pattern.compile(regexBestanden);
		Matcher mBestanden;
		String fileNaam;
		
		
		File directory=new File(directoryNaam);
		if( directory.exists() ) {
			File[] files = directory.listFiles();
			
			for(int i=0; i<files.length; i++) {
				fileNaam=files[i].toString();
				mBestanden = pBestanden.matcher(fileNaam);
				if (mBestanden.matches()){
					bestanden.add(fileNaam);
				}	
			}
		}
		
		return bestanden;
	}
}
