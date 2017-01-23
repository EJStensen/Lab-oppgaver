/**
*
* Program som sjekker om et tall er et primtall
*
*/


import static javax.swing.JOptionPane.*;

class Primtall4_5 {
public static void main(String [] args) {



	while (true){
		String tallLest = showInputDialog("Tast inn ett tall for å teste om det er et primtall, Esc for å avslutte: ");
		int tall = Integer.parseInt(tallLest);
		int del = 2;
		int resultat = 0;

		while (del <= tall / 2){

			if (tall % del == 0){
				resultat = 1;
			}
			del++;
			} //andre while loop
			if (resultat == 1) {
				showMessageDialog(null, "Tallet "+ tall +" er ikke et primtall.");
			} else {
				showMessageDialog(null, "Tallet "+ tall +" er et primtall.");
			}
		} //første while loop
	} //public main
} //class