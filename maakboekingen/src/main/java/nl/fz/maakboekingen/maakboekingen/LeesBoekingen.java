package nl.fz.maakboekingen.maakboekingen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeesBoekingen {

	ArrayList<String[]> boekingen=new ArrayList<String[]>();
	
	
	public void inlezenBestand(String file,String regex) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		String regel[];
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		
		String line=null;
		
		while ((line=br.readLine())!=null){
			if (regex==""){
				
			}
			
			
		}
	
	}
	
	public Double getBeginSaldo(){
		
		return 1.00;
	}
	
	public Double getEindSaldo(){
		
		return 1.00;
	}
	
	
	
}
