/**
*
* Program som printer ut gangetabell for tall innenfor et intervall som brukeren taster inn
*
*/

import java.util.Scanner;

class Gangetabell4_1 {
    public static void main(String[] args) {
        int forsteTall, andreTall, interVall, gAnge;

        System.out.println("Tast inn intervall for multiplikasjonstabell: ");
        Scanner in = new Scanner(System.in);

        forsteTall = in.nextInt();
        andreTall = in.nextInt();

        for (interVall = forsteTall; interVall <= andreTall; interVall++) {
            System.out.println("--------------------------");
            System.out.println("Multiplikasjonstabell for " + interVall);
            System.out.println("--------------------------");

            for (gAnge = 1; gAnge <= 10; gAnge++) {
                System.out.println(interVall + "*" + gAnge + " = "
                        + (interVall * gAnge));
            }
        }
    }
}