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

        String accountNumber="";
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
		String currency="";
		
		Boolean bBeginSaldoGevonden=false;
		Boolean bAccountnumberGevonden=false;
		
		String[] boeking=new String[7];
		Boolean lineContains61;
		Boolean lineContains62F;
	
		System.out.printf("Inlezenbestand:" + file + "\n");
		
		while ((line=br.readLine())!=null){
			if (line.contains(":86:")){//Description field can contain multiple lines
				omschrijving=line;
				while (1==1){
					br.mark(80);//Mark in order to be able to reset once a :86 is followed by :61 and that last line is used for the next booking so reset to previous marked position in this situation
					line=br.readLine();//read other lines of the desription
					lineContains61=line.contains(":61:")?true:false; 
					lineContains62F=line.contains(":62F:")?true:false; 
					if (lineContains62F || lineContains61 || line==null) {
						line=omschrijving;
						if (lineContains61 || lineContains62F){
							br.reset();
						}
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
				accountNumber=mAccountNumber.group(1);
				bAccountnumberGevonden=true;
				System.out.printf("ACCOUNTNUMBER: %s\n",accountNumber);
			} else if (bBeginSaldo==true && bBeginSaldoGevonden==false){
				currency=mBeginSaldo.group(3);
				beginSaldo=Double.valueOf(mBeginSaldo.group(4).replace(',', '.'));
				bBeginSaldoGevonden=true;
				System.out.printf("BeginSaldo account " + accountNumber + ": " + beginSaldo + " (%s)\n",mBeginSaldo.group(1));
			} else if (bBoekingsDatumEnBedrag==true){
				indCD=mBoekingsDatumEnBedrag.group(2); //Credet/Debet
				if (indCD.equals("C")) {
					boeking[1]="D";
				} else {
					boeking[1]="C";
				}
				boeking[2]="20"+mBoekingsDatumEnBedrag.group(1);//Datum
				boeking[3]=mBoekingsDatumEnBedrag.group(3).replace(',', '.'); //Bedrag
				boeking[4]=mBoekingsDatumEnBedrag.group(4); //Tegenrekening
				boeking[6]=currency;
			} else if (bBoekingsOmschrijving==true){
				boeking[0]=accountNumber;
				boeking[5]=mBoekingsOmschrijving.group(1).trim();//Omschrijving
				boekingen.add(boeking);
				System.out.printf("%s|%s|%s|%s|%s|%s|%s\n",boeking[0],boeking[4],boeking[1],boeking[2],boeking[3],boeking[5],boeking[6]);
				boeking=new String[7];	
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
		
		
		System.out.printf("EindSaldo " + accountNumber + ": "  + eindSaldo + " (%s)\n\n",eindSaldoCD);

	
	}
	
	public Double getBeginSaldo(){
		
		return beginSaldo;
	}
	
	public Double getEindSaldo(){
		
		return eindSaldo;
	}
	
}
