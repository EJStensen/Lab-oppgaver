import java.util.Random;
import java.util.Scanner;

class Randomtabell7_1{

	public static int[] antall(int[] heltall){

		int[] antall = new int[10];

		for (int i = 0; i <= antall.length; i++){
			for (int j = 0; j < heltall.length; j++){
				if(heltall[j] == i){
					antall[i - 1]++;
				}
			}
		}
		return antall;
	}

	public static void output(int[] antall){
		for (int i = 0; i < antall.length; i++){
			System.out.println((i) + " - " + antall[i]);
		}
	}

	public static void main(String[] args){

		java.util.Random random = new java.util.Random();
		Randomtabell7_1 rT = new Randomtabell7_1();

		int tall = random.nextInt(10);
		int input = 0;
		boolean noExit = true;

		while (noExit != false){
			Scanner in = new Scanner(System.in);
			System.out.println("Antall tilfeldig tall som skal genereres: ");

			try{
				input = in.nextInt();
			} catch (Exception e){
				System.out.println("Ikke heltall (int), prøv igjen.");
				continue;
			}
			if (input <= 0){
				System.out.println("Tallet kan ikke være mindre enn null, prøv igjen.");
			} else {
				noExit = false;
			}
		}

		int[] tallTabell = new int[input];

		for (int i = 0; i < tallTabell.length; i++){
			tallTabell[i] = (int)(Math.random() * 10 + 1);
		}

		int[] antall = antall(tallTabell);

		output(antall);
	}
}