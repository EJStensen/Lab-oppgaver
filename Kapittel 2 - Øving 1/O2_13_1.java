/**
* Program som konvertere tommer til centimeter.
*/

import static javax.swing.JOptionPane.*; //Importerer JOptionPane bibloteket.
class O2_13_1 {
  public static void main(String[] args) {

    String tommerLest = showInputDialog("Antall (tommer): "); //Innlesning av antall tommer.
    double tommer = Double.parseDouble(tommerLest);

    if(tommer >= 0){
      double centimeter = tommer * 2.54; //Antall tommer ganget med 2.54.
      showMessageDialog(null,+ tommer +" tommer tilsvarer "+ centimeter + " centimeter."); //Utskrift av antall tommer konvertert til centimeter.
    }else{
      showMessageDialog(null, "Feil inndata.");
    }
  }
}
