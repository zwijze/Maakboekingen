package nl.fz.maakboekingen.maakboekingen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LeesBoekingen {

	ArrayList<String[]> boekingen=new ArrayList<String[]>();
	
	
	public void inlezenBestand(String file,String regexBeginSaldo,String regexBoekingsDatumEnBedrag,String regexBoekingsOmschrijving,String regexEindSaldo) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		String regel[];
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line=null;
		
        Pattern pBeginSaldo = Pattern.compile(regexBeginSaldo);
        Pattern pBoekingsDatumEnBedrag = Pattern.compile(regexBoekingsDatumEnBedrag);
        Pattern pBoekingsOmschrijving = Pattern.compile(regexBoekingsOmschrijving);
        Pattern pEindSaldo = Pattern.compile(regexEindSaldo);

        Matcher mBeginSaldo;
        Matcher mBoekingsDatumEnBedrag;
        Matcher mBoekingsOmschrijving;
        Matcher mEindSaldo;
		Boolean bBeginSaldo;
		Boolean bBoekingsDatumEnBedrag;
		Boolean bBoekingsOmschrijving;
		Boolean bEindSaldo;
		
		while ((line=br.readLine())!=null){
			mBeginSaldo = pBeginSaldo.matcher(line);
			bBeginSaldo=mBeginSaldo.matches();
			mBoekingsDatumEnBedrag = pBoekingsDatumEnBedrag.matcher(line);
			bBoekingsDatumEnBedrag=mBoekingsDatumEnBedrag.matches();
			mBoekingsOmschrijving = pBoekingsOmschrijving.matcher(line);
			bBoekingsOmschrijving=mBoekingsOmschrijving.matches();
			mEindSaldo = pEindSaldo.matcher(line);
			bEindSaldo=mEindSaldo.matches();

			if (bBeginSaldo==true){
				
			} else if (bBoekingsDatumEnBedrag==true){
				
			} else if (bBoekingsOmschrijving==true){
			
			} else if (bEindSaldo==true){
				
			} else{
				continue;
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
