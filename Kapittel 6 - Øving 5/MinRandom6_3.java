import java.util.Random;
import java.util.Scanner;

public class MinRandom6_3{

	static java.util.Random randomTall = new java.util.Random();

	private int nedreHel;
	private int ovreHel;
	private double nedreDesi;
	private double ovreDesi;

	public MinRandom6_3(){
	}

	public MinRandom6_3(int nedreHel, int ovreHel, double nedreDesi, double ovreDesi){

		this.nedreHel = nedreHel;
		this.ovreHel = ovreHel;
		this.nedreDesi = nedreDesi;
		this.ovreDesi = ovreDesi;
	}

	public int helTall(){
		int rHeltall = randomTall.nextInt((ovreHel + 1) - nedreHel) + nedreHel;
		return rHeltall;
	}

	public double desiTall(){
		double rDesitall = nedreDesi + randomTall.nextDouble() * (ovreDesi - nedreDesi);
		return rDesitall ;
	}

	public void inputHel(){

		Scanner inHel = new Scanner(System.in);

		System.out.println("Sett nedre grense: ");
		nedreHel = inHel.nextInt();

		do {
			System.out.println("Sett øvre grense: ");
			ovreHel = inHel.nextInt();

			if (ovreHel < nedreHel){
				System.out.println("Øvre grense kan ikke være lavere enn nedre grense");
			}
		}
		while (ovreHel < nedreHel);
	}

	public void inputDesi(){

		Scanner inDesi = new Scanner(System.in);

		System.out.println("Sett nedre grense: ");
		nedreDesi = inDesi.nextDouble();

		do {
			System.out.println("Sett øvre grense: ");
			ovreDesi = inDesi.nextDouble();

			if (ovreDesi < nedreDesi) {
				System.out.println("Øvre grense kan ikke være lavere enn nedre grense");
			}
		}
		while (ovreDesi < nedreDesi);
	}

	public static void main(String[] args){

		MinRandom6_3 Random = new MinRandom6_3();

		boolean noExit = true;

		while (noExit != false){

			Scanner in = new Scanner(System.in);
			System.out.println("Random tall (hel- eller desimaltall) med gitt intervall");
			System.out.println("Velg operasjon"+"\n"+"1: Heltall"+"\n"+"2: Desimaltall"+"\n"+"3: Avslutt");
			int valgMeny = in.nextInt();

			if (valgMeny == 1){
				System.out.println("\n"+"Heltall");
				Random.inputHel();
				System.out.println("\n" + Random.helTall() + "\n");
			}
			if (valgMeny == 2){
				System.out.println("\n"+"Desimaltall");
				Random.inputDesi();
				System.out.println("\n" + Random.desiTall() + "\n");
			}
			if (valgMeny == 3){
				noExit = false;
			}
		}
	}
}
