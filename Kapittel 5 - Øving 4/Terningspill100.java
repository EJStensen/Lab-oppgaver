/*
*
* Terningsspill der spiller A og spiller B skal komme seg først til hundre poeng.
*
*/

import java.util.Random;

class Spiller{
	int sumPoeng;
	String navnAellerB;
	boolean noExit;

	public Spiller(String a, boolean b){
		this.sumPoeng = 0;
		this.navnAellerB = a;
		this.noExit = b;
	}

	public int getSumPoeng(){
		return sumPoeng;
	}

	public String getNavn(){
		return navnAellerB;
	}

	public boolean erFerdig(){
		boolean b = false;
		b = (sumPoeng == 100);
		return b;
	}

	public void kastTerning(){
		java.util.Random terning = new java.util.Random();
		int kast = terning.nextInt(6) + 1;
		if (kast == 1){
			this.sumPoeng = 0;
			System.out.println(navnAellerB + " kastet 1, og summen blir satt ned til 0");
		} else if (sumPoeng > 100){
			this.sumPoeng = (sumPoeng - kast);
			System.out.println(navnAellerB + " har poengsum over hundre, "+ kast +" blir trukket fra den totale summen.");
		} else {
			sumPoeng += kast;
			System.out.println(navnAellerB + " kaster " + kast + " og har totalt " + sumPoeng +" poeng.");
		}
	}
}

class Terningspill100{
	public static void main(String[] args){

		boolean noExit = true;

		Spiller spillerA = new Spiller("Norsken", noExit);
		Spiller spillerB = new Spiller("Svensken", noExit);

		int rundeTeller = 0;

		while (spillerA.erFerdig() == false && spillerB.erFerdig() == false){
			rundeTeller++;
			spillerA.kastTerning();
			spillerB.kastTerning();
			System.out.println("Runde nummer: "+ rundeTeller +"\n");
		}

		if (spillerA.erFerdig() == true && spillerB.erFerdig() == false){
			System.out.println("Etter "+ rundeTeller +" kast så vinner "+ spillerA.getNavn());
		}
		if (spillerA.erFerdig() == false && spillerB.erFerdig() == true){
			System.out.println("Etter "+ rundeTeller +" kast så vinner "+ spillerB.getNavn());
		}
	}
}