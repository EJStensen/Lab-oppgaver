/**
* Program som konverterer timer, minutter og sekunder til totalt antall sekunder.
*/

import static javax.swing.JOptionPane.*; //Importerer JOptionPane bibloteket.
class O2_13_2 {
  public static void main(String[] args) {

    String timerLest = showInputDialog("Antall timer: ");       //Inndata for antall timer.
    String minutterLest = showInputDialog("Antall minutter: "); //Inndata for antall minutter.
    String sekunderLest =showInputDialog("Antall sekunder: ");  //Inndata for antall sekunder.

    int timer = Integer.parseInt(timerLest);
    int minutter = Integer.parseInt(minutterLest);
    int sekunder = Integer.parseInt(sekunderLest);

    int totaltsekunder = (timer * 3600) + (minutter * 60) + sekunder; //Legger sammen antall timer, minutter og sekunder.
    if (totaltsekunder >= 0){
      showMessageDialog(null,+ timer + " time(r), "+ minutter +" minutt(er) og "+ sekunder +" sekund(er) er totalt "+ totaltsekunder +" sekunder.");
    }else{
      showMessageDialog(null, "Feil inndata.");
    }
  }
}
