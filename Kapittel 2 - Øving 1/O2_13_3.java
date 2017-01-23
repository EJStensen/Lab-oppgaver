/**
* Program som regner om antall sekunder til
* timer, minutter og sekunder.
*/

import static javax.swing.JOptionPane.*; //Importerer JOptionPane biblioteket.
class O2_13_3 {
  public static void main(String[] args) {

    String sekunderLest = showInputDialog("Antall sekunder: ");

    int sekunder = Integer.parseInt(sekunderLest);
    int timer = sekunder / 3600;
    int minutterRest = sekunder % 3600;
    int minutter = minutterRest / 60;
    int sekunderRest = minutterRest % 60;

    showMessageDialog(null, "Tiden er "+ timer +" time(r), "+ minutter +" minutt(er) og "+ sekunderRest +" sekund(er).");
  }
}
