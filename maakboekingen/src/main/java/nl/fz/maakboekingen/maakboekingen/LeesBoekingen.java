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

	private ArrayList<String[]> boekingen=new ArrayList<String[]>();
	private Double beginSaldo;
	private Double eindSaldo;
	
	

	public void inlezenBestand(String file,String regexBeginSaldo,String regexBoekingsDatumEnBedrag,String regexBoekingsOmschrijving,String regexEindSaldo) throws IOException{
		FileInputStream fis=new FileInputStream(file);
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
		
		Boolean bBeginSaldoGevonden=false;
		
		String[] boeking=new String[3];
	
		System.out.printf("Inlezenbestand:",file);
		
		while ((line=br.readLine())!=null){
			mBeginSaldo = pBeginSaldo.matcher(line);
			bBeginSaldo=mBeginSaldo.matches();
			mBoekingsDatumEnBedrag = pBoekingsDatumEnBedrag.matcher(line);
			bBoekingsDatumEnBedrag=mBoekingsDatumEnBedrag.matches();
			mBoekingsOmschrijving = pBoekingsOmschrijving.matcher(line);
			bBoekingsOmschrijving=mBoekingsOmschrijving.matches();
			mEindSaldo = pEindSaldo.matcher(line);
			bEindSaldo=mEindSaldo.matches();

			if (bBeginSaldo==true && bBeginSaldoGevonden==false){
				beginSaldo=Double.valueOf(mBeginSaldo.group(1));
				bBeginSaldoGevonden=true;
				System.out.printf("BeginSaldo:",beginSaldo);
			} else if (bBoekingsDatumEnBedrag==true){
				boeking[0]="20"+mBoekingsDatumEnBedrag.group(1)+"000000";
				boeking[1]=mBoekingsDatumEnBedrag.group(2);
			} else if (bBoekingsOmschrijving==true){
				boeking[2]=mBoekingsOmschrijving.group(1);
				boekingen.add(boeking);
				System.out.printf("%s|%s|%s",boeking[0],boeking[1],boeking[3]);
			} else if (bEindSaldo==true){
				eindSaldo=Double.valueOf(mEindSaldo.group(1));				
			} else{
				continue;
			}
			
		}
		
		System.out.printf("EindSaldo:",eindSaldo);

	
	}
	
	public Double getBeginSaldo(){
		
		return beginSaldo;
	}
	
	public Double getEindSaldo(){
		
		return eindSaldo;
	}
	
	public ArrayList<String[]> getBoekingen(){
		return boekingen;
	}
	
}
