/**
*Program som finner ut hvilken kontor du skal til avhengig av fødselsdato
*/

import static javax.swing.JOptionPane.*;
class O3_12_1 {
  public static void main(String[] args){
  final int maks = 31;
  String fodselsdato = showInputDialog("Skriv inn Fødselsdato: ");
  int fd = Integer.parseInt(fodselsdato);

  String utskrift;
  if (fd > 31){
    utskrift = "Feil inndata, maks: "+ maks +".";
  } else if (fd >= 26 ){
    utskrift = "Kontornummeret er 134.";
  } else if (fd >= 15){
    utskrift = "Kontornummeret er 125.";
  } else if (fd >= 9){
    utskrift = "Kontornummeret er 120.";
  } else if (fd >= 1){
    utskrift = "Kontornummeret er 113.";
  } else {
    utskrift = "Fødselsdato kan ikke være negativ.";
  }
  showMessageDialog(null, utskrift);
  }
}
