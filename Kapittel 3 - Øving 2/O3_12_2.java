/**
*Program som tester om et tall er positivt, delelig med et gitt tallet
*eller om tallet er i et gitt lukket intervall
*/

import static javax.swing.JOptionPane.*;
class O3_12_2 {
  public static void main(String[] args){
  final int NEDREGRENSE = 0;
  final int OVREGRENSE = 100;
  final int DIVISJON = 4;

  String input = showInputDialog("Tast inn et heltall: ");
  int tall = Integer.parseInt(input);

  String resultat = "Analyse av tallet " + tall + ":\n\n";

    resultat += "Tallet er ";
    if (tall <= 0) {
      resultat += "ikke-";
    }
    resultat += "positivt.\n";

    resultat += "Tallet er ";
    if (tall % DIVISJON != 0) {
      resultat += "ikke ";
    }
    resultat += "delelig med " + DIVISJON + ".\n";

    resultat += "Tallet befinner seg ";
    if (tall < NEDREGRENSE || tall > OVREGRENSE) {
      resultat += "ikke ";
    }
    resultat += "i det lukkede intervallet [" + NEDREGRENSE + ", " + OVREGRENSE + "].";

  showMessageDialog(null, resultat);
  }
}
