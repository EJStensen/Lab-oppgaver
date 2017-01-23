import java.util.Scanner;

public class Brokregning6_2{

	private int nevner;
	private int teller;

	public Brokregning6_2(){
	}

	public Brokregning6_2(int nevner, int teller){

		this.nevner = nevner;
		this.teller = teller;

		if (nevner == 0){
			throw new IllegalArgumentException("Nevner kan ikke være null!");
		}
		if (nevner < 0){
			nevner *= -nevner;
			teller *= -teller;
		}
	}

	public Brokregning6_2(int teller){

		this.nevner = 1;
		this.teller = teller;
	}

	public int getNevner(){
		return this.nevner;
	}

	public int getTeller(){
		return this.teller;
	}

	//Finner laveste felles nevner (lfn)
	public int lfn(int nevner1, int nevner2){

		int faktor = nevner1;

		while ((nevner1 % nevner2) != 0){
			nevner1 += faktor;
		}
		return nevner1;
	}

	//Finner høyeste felles nevner (hfn)
	private int hfn(int nevner1, int nevner2){

		int faktor = nevner2;

		while (nevner2 != 0){
			faktor = nevner2;
			nevner2 = nevner1 % nevner2;
			nevner1 = faktor;
		}
		return nevner1;
	}

	//Konverterer en brøk til en tilsvarende med lavest felles nevner
	private Brokregning6_2 konverter(int felles){

		Brokregning6_2 resultat = new Brokregning6_2();
		int faktor = felles / nevner;
		resultat.nevner = felles;
		resultat.teller = teller * faktor;
		return resultat;
	}

	//Adderer brøk 1 og brøk 2, og oppretter en ny brøk som blir printet ut
	public Brokregning6_2 addisjon(Brokregning6_2 b){

		int felles = hfn(nevner, b.nevner);
		Brokregning6_2 felles1 = new Brokregning6_2();
		Brokregning6_2 felles2 = new Brokregning6_2();

		felles1 = konverter(felles);
		felles2 = b.konverter(felles);

		Brokregning6_2 addi = new Brokregning6_2(); //Ny brøk som returneres som sum
		addi.nevner = felles;
		addi.teller = felles1.teller + felles2.teller;
		addi = addi.reduserBrok();
		return addi;
	}
	//Subtraherer brøk 1 og brøk 2, og oppretter en ny brøk som blir printet ut
	public Brokregning6_2 subtraksjon(Brokregning6_2 b){

		int felles = hfn(nevner, b.nevner);
		Brokregning6_2 felles1 = new Brokregning6_2();
		Brokregning6_2 felles2 = new Brokregning6_2();

		felles1 = konverter(felles);
		felles2 = b.konverter(felles);

		Brokregning6_2 subt = new Brokregning6_2(); //Ny brøk som returneres som sum
		subt.nevner = felles;
		subt.teller = felles1.teller - felles2.teller;
		subt = subt.reduserBrok();
		return subt;
	}

	//Multipliserer brøk 1 og brøk 2, og oppretter en ny brøk som printes ut
	public Brokregning6_2 multiplikasjon(Brokregning6_2 b){

		Brokregning6_2 mult = new Brokregning6_2(); //Ny brøk som returneres som sum
		mult.nevner = nevner * b.nevner;
		mult.teller = teller * b.teller;
		mult = mult.reduserBrok();
		return mult;
	}

	//Dividerer brøk 1 og brøk 2, og oppretter en ny brøk som printes ut
	public Brokregning6_2 divisjon(Brokregning6_2 b){

		Brokregning6_2 divi = new Brokregning6_2(); //Ny brøk som retuerneres som sum
		divi.nevner = nevner * b.teller;
		divi.teller = teller * b.nevner;
		divi = divi.reduserBrok();
		return divi;
	}

	//Brukeren skriver inn nevner og teller til brøkene
	public void input(){

		Scanner in = new Scanner(System.in);
		System.out.println("Bestem verdi for teller: ");
		teller = in.nextInt();

		do {
			System.out.println("Bestem verdi for nevner: ");
			nevner = in.nextInt();

			if (nevner == 0){
				System.out.println("Nevner kan ikke være null!");
			}
		}
		while (nevner == 0);
	}

	//Forkorter den nye brøken etter at regneoperasjonen er utført, hvis det er mulig
	public Brokregning6_2 reduserBrok(){

		Brokregning6_2 resultat = new Brokregning6_2();
		int felles = 0;

		int n = Math.abs(teller);
		int t = Math.abs(nevner);

		if (t > n){
			felles = hfn(t, n);

		} else if (t < n){
			felles = hfn(n, t);
		} else {
			felles = t;
		}

		resultat.nevner = nevner / felles;
		resultat.teller = teller / felles;
		return resultat;
	}

	public String toString(){
		String abc = teller + "/" + nevner;
		return abc;
	}

	//main
	public static void main(String[] args){

		Brokregning6_2 B1 = new Brokregning6_2();
		Brokregning6_2 B2 = new Brokregning6_2();

		Scanner inn = new Scanner(System.in);
		System.out.println("Regning med brøk");
		System.out.println("Velg funksjon"+"\n"+"1: Addisjon"+"\n"+"2: Subtraksjon"+"\n"+"3: Multiplikasjon"+"\n"+"4: Divisjon");
		int valgMeny = inn.nextInt();

		if (valgMeny == 1){
			System.out.println("\n"+"Addisjon (+) valgt");
			System.out.println("\n"+"Brøk en");
			B1.input();
			System.out.println("\n"+"Brøk to");
			B2.input();
			System.out.println("\n"+"Resultat: " + B1.addisjon(B2));
		}
		if (valgMeny == 2){
			System.out.println("\n"+"Substraksjon (-) valgt");
			System.out.println("\n"+"Brøk en");
			B1.input();
			System.out.println("\n"+"Brøk to");
			B2.input();
			System.out.println("\n"+"Resultat: "+ B1.subtraksjon(B2));
		}
		if (valgMeny == 3){
			System.out.println("\n"+"Multiplikasjon (*) valgt");
			System.out.println("\n"+"Brøk en");
			B1.input();
			System.out.println("\n"+"Brøk to");
			B2.input();
			System.out.println("\n"+"Resultat: "+ B1.multiplikasjon(B2));
		}
		if (valgMeny == 4){
			System.out.println("\n"+"Divisjon (/) valgt");
			System.out.println("\n"+"Brøk en");
			B1.input();
			System.out.println("\n"+"Brøk to");
			B2.input();
			System.out.println("\n"+"Resultat: "+ B1.divisjon(B2));
		}
	}
}
