package nl.fzit.maakboekingen.maakboekingen;

import java.util.ArrayList;
import nl.fzit.files.*;
import nl.fzit.maakboekingen.config.*;

public class Maakboekingen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> bestandenList;
		Config config=new Config();
		
		FilesDirectories filesDirectories=new FilesDirectories();
		bestandenList=filesDirectories.bepaalInTeLezenBestanden("1","2");
		
		for (String bestand :bestandenList){
			
		}
		
	}

}
