/**
*
* Program som regner om Unicode tegn til tall
*
*/


import static javax.swing.JOptionPane.*;

class TallverdiTegn4_3 {
	public static void main(String[] args) {

		String forsteT = showInputDialog("Tast inn nedre grense som et tegn: ");
		String andreT = showInputDialog("Tast inn øvre grense som et tegn: ");
		char abc = forsteT.charAt(0);
		char def = andreT.charAt(0);
		char intervall;

		if (abc <= def) {
			String utdata = "";
			for (intervall = abc; intervall <= def; intervall++) {
				utdata += "Tegnet " + intervall + " har tallverdien " + (int) intervall + ".\n";
			}
			showMessageDialog(null, utdata);
			} else {
				showMessageDialog(null, "Tegnet "+ def +" er større enn "+ abc +", prøv igjen.");
		}
	}
}