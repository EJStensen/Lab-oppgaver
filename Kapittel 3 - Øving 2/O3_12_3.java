/**
*Program som regner ut om et gitt år er et skuddår eller ikke
*/

import static javax.swing.JOptionPane.*;
class O3_12_3 {
    public static void main(String[] args) {

//Hvis tallet resulterer i et heltall med som er delelig 4, 400 eller modulus av 100 ikke er 0, er det et skuddår.
            if ((ar % 4 == 0) && (ar % 100 != 0 || ar % 400 == 0)){
            showMessageDialog(null,+ ar +" er et skuddår.");

        } else {
            showMessageDialog(null,+ ar +" er ikke et skuddår.");
        }
    }
}
