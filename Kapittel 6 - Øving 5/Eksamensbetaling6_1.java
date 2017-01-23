import java.util.Scanner;

class Sensurering{


}

public class Eksamensbetaling6_1{
	public static void main(String[] args){

	Sensurering sensurering = new Sensurering();

	Scanner in = new Scanner(System.in);

	System.out.println("Velg type eksamen:"+"\n"+"1: Muntlig eksamen"+"\n"+"2: Skriftlig eksamen"+"\n"+"3: Prosjektoppgave");
	int menyValg = in.nextInt();

	System.out.println("Eksamenstid: ");
	double timeValg = in.nextDouble();
	}
}