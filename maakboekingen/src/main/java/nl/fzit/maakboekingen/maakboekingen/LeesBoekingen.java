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
	private ArrayList<String[]> boekingen=new ArrayList<String[]>();
	
	public ArrayList<String[]> getBoekingen(){
		return boekingen;
	}

	public void inlezenBestand(String file,String accountNumberRegex,String regexBeginSaldo,String regexBoekingsDatumEnBedrag,String regexEindSaldo) throws IOException{
		FileInputStream fis=new FileInputStream(file);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line=null;
		String indCD;
		
		
        Pattern pAccountNumber = Pattern.compile(accountNumberRegex);		
        Pattern pBeginSaldo = Pattern.compile(regexBeginSaldo);
        Pattern pBoekingsDatumEnBedrag = Pattern.compile(regexBoekingsDatumEnBedrag);
 //       Pattern pBoekingsOmschrijving = Pattern.compile(regexBoekingsOmschrijving);
        Pattern pBoekingsOmschrijving = Pattern.compile(":86:(.*)");
        Pattern pEindSaldo = Pattern.compile(regexEindSaldo);

        Matcher mAccountNumber;
        Matcher mBeginSaldo;
        Matcher mBoekingsDatumEnBedrag;
        Matcher mBoekingsOmschrijving;
 //       Matcher mBoekingsOmschrijving2;
        Matcher mEindSaldo = null;
        Boolean bAccountNumber;
		Boolean bBeginSaldo;
		Boolean bBoekingsDatumEnBedrag;
		Boolean bBoekingsOmschrijving;
		Boolean bBoekingsOmschrijving2;		
		Boolean bEindSaldo;
		String eindSaldoCD = null;
		String omschrijving;
		
		Boolean bBeginSaldoGevonden=false;
		Boolean bAccountnumberGevonden=false;
		
		String[] boeking=new String[6];
	
		System.out.printf("Inlezenbestand:" + file + "\n");
		
		while ((line=br.readLine())!=null){
			if (line.contains(":86:")){//Description field can contain multiple lines
				omschrijving=line;
				while (1==1){
					line=br.readLine();//read other lines of the desription
					if (line.contains(":62F:") || line==null) {
						line=omschrijving;
						break;
					}
					if (!line.equals("")) omschrijving=omschrijving + " " + line.trim();
				}
			}	
			
			mAccountNumber = pAccountNumber.matcher(line);
			bAccountNumber=mAccountNumber.matches();			
			mBeginSaldo = pBeginSaldo.matcher(line);
			bBeginSaldo=mBeginSaldo.matches();
			mBoekingsDatumEnBedrag = pBoekingsDatumEnBedrag.matcher(line);
			bBoekingsDatumEnBedrag=mBoekingsDatumEnBedrag.matches();
			mBoekingsOmschrijving = pBoekingsOmschrijving.matcher(line);
			bBoekingsOmschrijving=mBoekingsOmschrijving.matches();
//			mBoekingsOmschrijving2 = pBoekingsOmschrijving2.matcher(line);
//			bBoekingsOmschrijving2=mBoekingsOmschrijving2.matches();
			mEindSaldo = pEindSaldo.matcher(line);
			bEindSaldo=mEindSaldo.matches();

			if (bAccountNumber==true && bAccountnumberGevonden==false){
				boeking[0]=mAccountNumber.group(1);
				bAccountnumberGevonden=true;
				System.out.printf("ACCOUNTNUMBER: %s\n",boeking[0]);
			} else if (bBeginSaldo==true && bBeginSaldoGevonden==false){
				beginSaldo=Double.valueOf(mBeginSaldo.group(2).replace(',', '.'));
				bBeginSaldoGevonden=true;
				System.out.printf("BeginSaldo:" + beginSaldo + " (%s)\n",mBeginSaldo.group(1));
			} else if (bBoekingsDatumEnBedrag==true){
				indCD=mBoekingsDatumEnBedrag.group(2); //Credet/Debet
				if (indCD=="C") {
					boeking[1]="D";
				} else {
					boeking[1]="C";
				}
				boeking[2]="20"+mBoekingsDatumEnBedrag.group(1);//Datum
				boeking[3]=mBoekingsDatumEnBedrag.group(3); //Bedrag
				boeking[4]=mBoekingsDatumEnBedrag.group(4); //Tegenrekening
			} else if (bBoekingsOmschrijving==true){
				boeking[5]=mBoekingsOmschrijving.group(1).trim();//Omschrijving
				boekingen.add(boeking);
				System.out.printf("%s|%s|%s|%s|%s|%s\n",boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5]);
//			} else if (bBoekingsOmschrijving2==true){//so bBoekingsOmschrijving!=true so this one will not be booked 
//				boeking[4]=mBoekingsOmschrijving2.group(1);//Omschrijving
//				System.out.printf("Not be booked: %s|%s|%s|%s|%s\n",boeking[0],boeking[1],boeking[2],boeking[3],boeking[4]);				
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
