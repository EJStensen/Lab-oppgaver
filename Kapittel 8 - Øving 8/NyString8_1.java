import java.util.Scanner;

class NyString{
    
    String tekst;
    
    public NyString(String inputString){
        this.tekst = inputString;
    }
    
    public void Forkorting(){
        String[] ord = tekst.split(" ");
        String output = "";
        for (int i = 0; i < ord.length; i++){
            output += ord[i].charAt(0);
        }
        tekst = output;
    }
    
    public void Fjerntegn(char tegn){
        String output = "";
        for (int i = 0; i < tekst.length(); i++){
            if (Character.toUpperCase(tekst.charAt(i)) != Character.toUpperCase(tegn)){
                output += tekst.charAt(i);
            }
        }
        tekst = output;
    }
    
    public String getTekst(){
        return tekst;
    }
}

class Input{
	public String getString(String dialog){

		String inputString = "";
		System.out.println(dialog);
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();

		return inputString;
	}
}

class NyString8_1{
    public static void main(String[] args){
    
    Input input = new Input();
    boolean noExit1 = true;
    String inputString;
    int valgMeny = 0;
    
    while (noExit1){
        inputString = input.getString("Skriv inn en teksten (-1 for a avslutte): ");
        boolean noExit2 = true;
        if (inputString.matches("-1")){
            noExit1 = false;
        } else {
            while (noExit2){
                NyString ny = new NyString(inputString);
            
                System.out.println("Velg operasjon"+"\n"+"1: Forkorting av tekst der kun forste bokstav av hvert ord star igjen"+"\n"+"2: Fjern et bestemt tegn fra teksten"+"\n"+"3: Avslutt");
                Scanner in = new Scanner(System.in);
                valgMeny = in.nextInt();
                
                    switch (valgMeny){
                        case 1: ny.Forkorting();
                                System.out.println(ny.getTekst());
                                break;
                    
                        case 2: inputString = input.getString("Hvilket tegn skal fjernes?: ");
                                ny.Fjerntegn(inputString.charAt(0));
                                System.out.println(ny.getTekst());
                                break;
                    
                        case 3: noExit2 = false;
                                break;
                                
                        default: System.out.println("Ikke gyldig operasjon, prov igjen.");
                                break;
                    }
                }
            }
        }
    }
}