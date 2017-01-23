/**
*
* Program som printer ut n antall linjer med stjerner (*).
*
*/


import java.util.Scanner;

class Stjerner4_2_v2 {
	public static void main(String[] args) {
		int tall, i, x, y, z;

		System.out.print("Tast inn hvor mange linjer pyramiden skal bestå av: ");
		Scanner in = new Scanner(System.in);
		tall = in.nextInt();

		for (i = 1; i <= tall; i++) {
		           for (x = tall - 1; x >= i; x--) {
		               System.out.print(" ");
		           }

		           for (y = 1; y<= i; y++) {
		               System.out.print("*");
		           }

		           for (z= 1; z <= i - 1; z++) {
		               System.out.print("*");
		           }

		           System.out.println();
		}
	}
}