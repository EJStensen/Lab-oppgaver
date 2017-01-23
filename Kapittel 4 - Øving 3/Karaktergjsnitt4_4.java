/**
*
* Program som regner ut gjennomsnittet av bokstavkarakterer.
*
*/

import static javax.swing.JOptionPane.*;

class Karaktergjsnitt4_4 {
	public static void main(String[] args) {

	char karakter;
	char sum = 0;
	int antallKarakterer = 0;

	String karakterLest = showInputDialog("Skriv bokstav, avslutt med Esc: ");
	while (karakterLest != null){

		karakter = karakterLest.charAt(0);
		sum += karakter;
		antallKarakterer++;
		karakterLest = showInputDialog(null, "Skriv bokstav, avslutt med Esc: ");
		}
		int total = (int) sum;
		int sumNumerisk = (total / antallKarakterer);
		char gjsnitt = (char)sumNumerisk;
		showMessageDialog(null, "Gj.snitt er: " + gjsnitt +".");
	}
}