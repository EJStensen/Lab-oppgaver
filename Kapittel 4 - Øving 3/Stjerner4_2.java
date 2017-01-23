/**
*
* Program som printer ut n antall linjer med stjerner (*).
*
*/


import java.util.Scanner;

class Stjerner4_2 {
	public static void main(String[] args) {
		int tall, i, ii;

		System.out.print("Tast inn hvor mange linjer med stjerner (*) som skal vises: "); //input fra brukeren
		Scanner in = new Scanner(System.in);
		tall = in.nextInt();

		        for(i = 0; i < tall; i++){
		            for(ii=i+1; ii>0; ii--){
		                System.out.print("*");
		        }
    		    System.out.println();
		}
	}
}