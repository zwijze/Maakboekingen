package nl.fzit.maakboekingen.maakboekingen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LeesBoekingen {

	private Double beginSaldo;
	private Double eindSaldo;
	
	

	public void inlezenBestand(String file,String AccountNumberRegex,String regexBeginSaldo,String regexBoekingsDatumEnBedrag,String regexBoekingsOmschrijving,String regexEindSaldo) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line=null;
		
        Pattern pAccountNumber = Pattern.compile(AccountNumberRegex);		
        Pattern pBeginSaldo = Pattern.compile(regexBeginSaldo);
        Pattern pBoekingsDatumEnBedrag = Pattern.compile(regexBoekingsDatumEnBedrag);
        Pattern pBoekingsOmschrijving = Pattern.compile(regexBoekingsOmschrijving);
        Pattern pBoekingsOmschrijving2 = Pattern.compile(":86:(.*)");
        Pattern pEindSaldo = Pattern.compile(regexEindSaldo);

        Matcher mAccountNumber;
        Matcher mBeginSaldo;
        Matcher mBoekingsDatumEnBedrag;
        Matcher mBoekingsOmschrijving;
        Matcher mBoekingsOmschrijving2;
        Matcher mEindSaldo = null;
        Boolean bAccountNumber;
		Boolean bBeginSaldo;
		Boolean bBoekingsDatumEnBedrag;
		Boolean bBoekingsOmschrijving;
		Boolean bBoekingsOmschrijving2;		
		Boolean bEindSaldo;
		String eindSaldoCD = null;
		
		Boolean bBeginSaldoGevonden=false;
		Boolean bAccountNumberGevonden=false;
		
		
		ArrayList<String[]> boekingen=new ArrayList<String[]>();
		String[] boeking=new String[5];
	
		System.out.printf("Inlezenbestand:" + file + "\n");
		
		while ((line=br.readLine())!=null){
			mAccountNumber = pAccountNumber.matcher(line);
			bAccountNumber=mAccountNumber.matches();			
			mBeginSaldo = pBeginSaldo.matcher(line);
			bBeginSaldo=mBeginSaldo.matches();
			mBoekingsDatumEnBedrag = pBoekingsDatumEnBedrag.matcher(line);
			bBoekingsDatumEnBedrag=mBoekingsDatumEnBedrag.matches();
			mBoekingsOmschrijving = pBoekingsOmschrijving.matcher(line);
			bBoekingsOmschrijving=mBoekingsOmschrijving.matches();
			mBoekingsOmschrijving2 = pBoekingsOmschrijving2.matcher(line);
			bBoekingsOmschrijving2=mBoekingsOmschrijving2.matches();
			mEindSaldo = pEindSaldo.matcher(line);
			bEindSaldo=mEindSaldo.matches();

			if (bAccountNumber==true && bAccountNumberGevonden==false){
				boeking[0]=mAccountNumber.group(1);
				bAccountNumberGevonden=true;
			} else if (bBeginSaldo==true && bBeginSaldoGevonden==false){
				beginSaldo=Double.valueOf(mBeginSaldo.group(2).replace(',', '.'));
				bBeginSaldoGevonden=true;
				System.out.printf("BeginSaldo:" + beginSaldo + " (%s)\n",mBeginSaldo.group(1));
			} else if (bBoekingsDatumEnBedrag==true){
				boeking[1]="20"+mBoekingsDatumEnBedrag.group(1);//Datum
				boeking[2]=mBoekingsDatumEnBedrag.group(2); //Credet/Debet
				boeking[3]=mBoekingsDatumEnBedrag.group(3); //Bedrag
			} else if (bBoekingsOmschrijving==true){
				boeking[4]=mBoekingsOmschrijving.group(1);//Omschrijving
				boekingen.add(boeking);
				System.out.printf("Booking that will be booked: %s|%s|%s|%s|%s\n",boeking[0],boeking[1],boeking[2],boeking[3],boeking[4]);
			} else if (bBoekingsOmschrijving2==true){
				boeking[4]=mBoekingsOmschrijving2.group(1);//Omschrijving
				System.out.printf("Booking that will not be booked: %s|%s|%s|%s|%s\n",boeking[0],boeking[1],boeking[2],boeking[3],boeking[4]);				
			} else if (bEindSaldo==true){
				eindSaldo=Double.valueOf(mEindSaldo.group(2).replace(',', '.'));
				eindSaldoCD=mEindSaldo.group(1);
			} else{
				continue;
			}
			
		}
		
		
		System.out.printf("EindSaldo:" + eindSaldo + " (%s)\n",eindSaldoCD);

	
	}
	
	public Double getBeginSaldo(){
		
		return beginSaldo;
	}
	
	public Double getEindSaldo(){
		
		return eindSaldo;
	}
	
}
