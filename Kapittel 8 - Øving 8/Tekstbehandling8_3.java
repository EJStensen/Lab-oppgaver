import java.util.Scanner;

class Tekstbehandling{

    String tekst;
    
    public Tekstbehandling(String tekst){
        this.tekst = tekst;
    }
    
    public String getTekst(){
		return tekst;
	}
    
    public int AntallOrd(String inputString){
        String input = inputString.trim();
        int antallord = input.isEmpty() ? 0 : input.split("\\W+").length;
        return antallord;
    }
    
    public double GjSnittOrdLengde(){
        String ord[] = tekst.split("\\W+");
        int sum = 0;
        for (int i = 0; i < ord.length; i++){
            sum += ord[i].length();
        }
        return (double) sum / ord.length;
    }
    
    public double GjSnittPeriode(){
        String perioder[] = tekst.split("[.,?!:]");
        int sum = 0;
        
        for (int i = 0; i < perioder.length; i++){
            String ordPeriode[] = perioder[i].split("[ ]");
            for(int j = 0; j < ordPeriode.length; j++){
                if (ordPeriode[j].length() > 0){
                    sum++;
                }
            }
        }
        return (double) sum / perioder.length;
    }
    
    public String SkifteOrd(String orginaltord, String erstatning){
        return tekst.replaceAll(orginaltord, erstatning);
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

class Tekstbehandling8_3{
    public static void main(String[] args){
        
        Input input = new Input();
        boolean noExit1 = true;
        String inputString = "";
        int valgMeny = 0;
        
        while (noExit1){
            inputString = input.getString("Skriv en tekst du vil analysere: "+"\n"+"Skriv <-1> for a avslutte program");
            boolean noExit2 = true;
            if (inputString.matches("-1")){
				noExit1 = false;
			} else {
                while (noExit2){
                    Tekstbehandling tb = new Tekstbehandling(inputString);

                    System.out.println("\n"+"Velg operasjon");
                    System.out.println("1: Finne antall ord"+"\n"+"2: Gj.snitt ordlengde"+"\n"+"3: Gj.snitt antall ord periode"+"\n"+"4: Skifte ut ord i teksten"+"\n"+"5: Skriv ut orginalteksten"+"\n"+"6: Skriv ut orginaltekst i store bokstaver"+"\n"+"7: Avslutt");
                    Scanner in = new Scanner(System.in);
                    try {
                        valgMeny = in.nextInt();
                    } catch (Exception e){
                        System.out.println("Ikke gyldig operasjon, prov igjen");
                        continue;
                    } 
                    switch (valgMeny){
                        case 1: System.out.println("\n"+"Antall ord i teksten: "+ tb.AntallOrd(inputString));
                                break;
                            
                        case 2: System.out.println("\n"+"Gjennomsnittlig ordlengde: "+ tb.GjSnittOrdLengde());
                                break;
                            
                        case 3: System.out.println("\n"+"Gjennomsnittlig antall ord per periode: "+ tb.GjSnittPeriode());
                                break;
                            
                        case 4: String in1 = input.getString("\n"+"Skriv inn hvilket ord du vil bytte ut: ");
                                String in2 = input.getString("Skriv inn ordet som skal erstatte folgende: "+ in1);
                                System.out.println("\n"+"Ny tekst med ordet erstattet: "+ tb.SkifteOrd(in1, in2));
                                break;
                            
                        case 5: System.out.println("\n"+"Orginal tekst: " + inputString);
                                break;
                            
                        case 6: System.out.println("\n"+"Orginal tekst med store bokstaver: " + inputString.toUpperCase());
                                break;
                            
                        case 7: noExit2 = false;
                                break;
                                
                        default: System.out.println("\n"+"Ikke gyldig operasjon, prov igjen.");
                                break;
                    }
                }
            }
        }
    }
}