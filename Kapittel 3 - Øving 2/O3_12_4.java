/**
*Program som regner ut hvilken type kjøttdeig som er billigst.
*/

import static javax.swing.JOptionPane.*;
class O3_12_4 {
    public static void main(String[] args) {

        showMessageDialog(null, "Vi har to typer kjottdeig A og B.");
        showMessageDialog(null, "Produkt A inneholder 450 gram kjott, og koster 35,9kr. Produkt B inneholder 500 gram kjott, og koster 39,5kr.");
        showMessageDialog(null, "Hvilket produkt far du mest igjen for pengene?");

        double produktA = (450 / 35.9);
        double produktB = (500 / 39.5);

        if (produktA < produktB){
            showMessageDialog(null, "Du far mest igjen for pengene ved a kjope produkt B.");
        } else {
            showMessageDialog(null, "Du far mest igjen for pengene ved a kjope produkt A.");
        }
    }
}
