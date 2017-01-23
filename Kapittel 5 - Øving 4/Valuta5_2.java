import java.util.Scanner;

public class Valuta5_2{

	private static double belop;
	private double kurs;
	private int enhet;

	public Valuta5_2(double belop, double kurs, int enhet){

		this.belop = belop;
		this.kurs = kurs;
		this.enhet = enhet;
	}

	//Beregner fra norske kroner til valgt valuta
	public double beregnFraNok(){
		return belop / kurs * enhet;
	}

	//Beregner fra valg valuta til norske kroner
	public double beregnTilNok(){
		return belop * kurs / enhet;
	}

	//main
	public static void main(String[] args){

		Valuta5_2 USD = new Valuta5_2(belop, 8.30, 1);
		Valuta5_2 EUR = new Valuta5_2(belop, 9.30, 1);
		Valuta5_2 SEK = new Valuta5_2(belop, 97.3, 100);

		while (true){

			System.out.println("\n"+"Valutakalkulator");
			System.out.println("Velg valuta"+"\n"+"1: Dollar"+"\n"+"2: Euro"+"\n"+"3: svenske kroner"+"\n"+"4: avslutt");
			Scanner in = new Scanner(System.in);
			int valgMeny = in.nextInt();

			if (valgMeny == 4){
				break;
			}

			//if (valgMeny < 1 || valgMeny > 4){
			//	System.out.println("Ikke gyldig operasjon, pr�v igjen.");
			//}

			if (valgMeny >= 1 || valgMeny <= 4){

				System.out.println("\n"+"Velg operasjon"+"\n"+"1: Beregn til NOK"+"\n"+"2: Beregn fra NOK");
				int valgOp = in.nextInt();

				//Beregn fra dollar til norske kroner
				if(valgMeny == 1 && valgOp == 1){
					System.out.println("\n"+"Skriv inn ditt bel�p: ");
					Scanner in1 = new Scanner(System.in);
					belop = in1.nextDouble();
					System.out.println("Bel�pet er: " + USD.beregnTilNok());
				}

				//Beregn fra norske kroner til dollar
				if(valgMeny == 1 && valgOp == 2){
					System.out.println("\n"+"Skriv inn ditt bel�p: ");
					Scanner in2 = new Scanner(System.in);
					belop = in2.nextDouble();
					System.out.println("Bel�pet er: " + USD.beregnFraNok());
				}

				//Beregn fra euro til norske kroner
				if(valgMeny == 2 && valgOp == 1){
					System.out.println("\n"+"Skriv inn ditt bel�p: ");
					Scanner in3 = new Scanner(System.in);
					belop = in3.nextDouble();
					System.out.println("Bel�pet er: "+ EUR.beregnTilNok());
				}

				//Beregn fra norske kroner til euro
				if(valgMeny == 2 && valgOp == 2){
					System.out.println("\n"+"Skriv inn ditt bel�p: ");
					Scanner in4 = new Scanner(System.in);
					belop = in4.nextDouble();
					System.out.println("Bel�pet er: "+ EUR.beregnFraNok());
				}

				//Beregn fra svenske kroner til norske kroner
				if(valgMeny == 3 && valgOp == 1){
					System.out.println("\n"+"Skriv inn ditt bel�p");
					Scanner in5 = new Scanner(System.in);
					belop = in5.nextDouble();
					System.out.println("Bel�pet er: "+ SEK.beregnTilNok());
				}

				//Beregn fra norske kroner til svenske kroner
				if(valgMeny == 3 && valgOp == 2){
					System.out.println("\n"+"Skriv inn ditt bel�p");
					Scanner in6 = new Scanner(System.in);
					belop = in6.nextDouble();
					System.out.println("Bel�pet er: "+ SEK.beregnFraNok());
				}
			}
		}
	}
}