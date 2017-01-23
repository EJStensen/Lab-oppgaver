//Main

import static javax.swing.JOptionPane.*;

class Prosjekt5_1 {
public static void main(String[] args){

	//Oppretter objekt prosjektKonto for Ola Normann(navn p? prosjekt, navn p? ansvarlig, saldo)
	Prosjekt prosjekt1 = new Prosjekt("Prosjekt123", "Ola Normann", 10000000.0);

	String utgiftLest = showInputDialog("Skriv inn utgifter, avslutt med esc");

	while (utgiftLest != null){

		double utgift = Double.parseDouble(utgiftLest);
		prosjekt1.nyUtgift(utgift);
		utgiftLest = showInputDialog("Informasjon" + prosjekt1.toString() + "\n\n" + "Flere utgifter, avslutt med ESC.");
		}
	}
}

/*
* Klassen Prosjekt
*/

class Prosjekt {
  private final String tittel;
  private final String ansvarlig;
  private final double budsjett;
  private double utgifter;

  public Prosjekt(String tittel, String ansvarlig, double budsjett) {
    this.tittel = tittel;
    this.ansvarlig = ansvarlig;
    this.budsjett = budsjett;
    this.utgifter = 0.0;
  }

  public String getTittel() {
    return tittel;
  }

  public String getAnsvarlig() {
    return ansvarlig;
  }

  public double getBudsjett() {
    return budsjett;
  }

  public double getUtgifter() {
    return utgifter;
  }

  public void nyUtgift(double enNyUtgift) {
    utgifter += enNyUtgift;
  }

  public String toString() {
    return "Prosjekt:  " + tittel + "\n" +
           "Ansvarlig: " + ansvarlig + "\n" +
           "Budsjett:  " + budsjett + "\n" +
           "Utgifter:  " + utgifter;
  }
}