import java.util.Scanner;

class Tekstanalyse{

	String tekst;
	int[] antallTegn = new int[30];

	public Tekstanalyse(String tekst){

		this.tekst = tekst;
		tekst = tekst.toUpperCase();

		for (int i = 0; i < tekst.length(); i++){
			if ((int) 'A' <= tekst.charAt(i) && (int) 'Z' >= tekst.charAt(i)){
				antallTegn[tekst.charAt(i) - 'A']++;
			} else if ((int) 'Æ' == tekst.charAt(i)){
				antallTegn[26]++;
			} else if ((int) 'Ø' == tekst.charAt(i)){
				antallTegn[27]++;
			} else if ((int) 'Å' == tekst.charAt(i)){
				antallTegn[28]++;
			} else {
				antallTegn[29]++;
			}
		} //end for løkke
	} //end metode tekstanalyse

	public int getForskjelligeBokstaver(){

		int forskjelligeBokstaver = 0;

		for (int i = 0; i < antallTegn.length - 1; i++){
			if (antallTegn[i] > 0){
				forskjelligeBokstaver++;
			}
		}//end for løkke

		return forskjelligeBokstaver;
	}//end metode ForskjelligeBokstaver

	public int getAntallBokstaver(){

		int antallBokstaver = 0;

		for (int i = 0; i < antallTegn.length-1; i++){
			antallBokstaver += antallTegn[i];
		}//end for løkke

		return antallBokstaver;
	}//end metode AntallBokstaver

	public int getProsentIkkeBokstaver(){

		int antallIkkeBokstaver = antallTegn[29];
		int totalAntallTegn = 0;
		int prosent = 100;

		for (int i = 0; i < antallTegn.length - 1; i++){
			totalAntallTegn += antallTegn[i];
		}//end for løkke
		if (totalAntallTegn != 0){
			prosent = (antallIkkeBokstaver * 100) / (totalAntallTegn + antallIkkeBokstaver);
		}
		return prosent;
	}//end metode ProsentIkkeBokstaver

	public int getAntallTegn(char bokstav){
		if ('A' <= bokstav && 'Z' >= bokstav){
			return antallTegn[bokstav - 'A'];
		} else {
			return -1;
		}
	}//end metode AntallTegn

	public String getVanligsteBokstav(){

		int vanligsteBokstavMax = 0;
		int vanligsteBokstavAntall = 0;
		int tegnTelt = 0;

		for (int i = 0; i < antallTegn.length - 1; i++){
			if (vanligsteBokstavMax < antallTegn[i]){
				vanligsteBokstavMax = antallTegn[i];
				vanligsteBokstavAntall = 1;
			} else if (vanligsteBokstavMax == antallTegn[i]){
				vanligsteBokstavAntall++;
			}
		}//end for løkke

		if (vanligsteBokstavAntall == 0){
			return "Det er ingen bokstaver i teksten.";
		}

		int[] vanligsteBokstav = new int[vanligsteBokstavAntall];
		String returnString = "";

		for (int i = 0; i < antallTegn.length - 1; i++){
			if (vanligsteBokstavMax == antallTegn[i]){
				returnString += (char) (i + 'A');
				tegnTelt++;

				if (vanligsteBokstavAntall > tegnTelt){
					returnString += ", ";
				}
			}
		}//end for løkke

		returnString += " (med " + vanligsteBokstavMax + " tegn)";

		return returnString;
	}//end metode VanligsteBokstav

	public String getTekst(){
		return tekst;
	}//end metode Tekst
}//end klasse Tekstanalyse7_3

class Input{
	public String getString(String dialog){

		String inputString = "";
		System.out.println(dialog);
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();

		return inputString;
	}//end metode String
}//end klasse Input

class Tekstanalyse7_3{
	public static void main(String[] args){

		Input input = new Input();
		boolean noExit = true, noExitTegn = true;
		String inputString = "";
		char inputChar = 'A';

		while (noExit){
			inputString = input.getString("Skriv en tekst du vil analysere: "+"\n"+"Skriv <-1> for å avslutte program");
			if (inputString.matches("-1")){
				noExit = false;
			} else {
				Tekstanalyse ta = new Tekstanalyse(inputString);

				System.out.println("\n"+"Teksten som blir analysert: " + ta.getTekst());

				System.out.println("Antall forskjellig bokstaver i teksten: " + ta.getForskjelligeBokstaver());
				System.out.println("Antall bokstaver i teksten: " + ta.getAntallBokstaver());
				System.out.println("Hvor mye av teksten som ikke er bokstaver : " + ta.getProsentIkkeBokstaver() + "%");
				System.out.println("Vanligste bokstav(er) i teksten: " + ta.getVanligsteBokstav());


				while (noExitTegn){
					inputString = input.getString("\n"+"Skriv inn en bokstav du vil sjekka antall forekomster av i teksten: "+"\n"+"Skriv <-1> for å avslutte");
					try{
						inputChar = Character.toUpperCase(inputString.charAt(0));
					} catch (Exception e){
						continue;
					}
					if (inputString.matches("-1")){
						noExitTegn = false;
					} else if ((int) 'A' <= inputChar && (int) 'Z' >= inputChar || inputChar == 'Æ' || inputChar == 'Ø' || inputChar == 'Å'){
						System.out.println("\n"+"Det er " + ta.getAntallTegn(inputChar) + " forekomster av " + inputChar + " i teksten");
					}
				}//end while løkke
			}
		}//end while løkke
	}//end main metode
}//end class TekstKlient