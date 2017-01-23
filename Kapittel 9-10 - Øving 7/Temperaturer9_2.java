import java.util.Random;
import java.util.Scanner;

class Temperaturer{

	double[][] tempTabell;
    int dager; 

	public Temperaturer(int dager){
		this.tempTabell = new double[dager][24];
        genDager();
	}
    
    public Temperaturer(){
    }
    
    public void genDager(){
        
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < tempTabell.length; i++){
            for (int j = 0; j < tempTabell[i].length; j++){
                tempTabell[i][j] = (double) random.nextInt((20-(-10)) + 1) - 20;
            }
        }
    }

	public double getMiddelTempDag(int dag){
        
        double mtDag = 0;
        for(int i = 0; i < tempTabell[0].length; i++){
            mtDag += tempTabell[dag][0];
        }
        return (mtDag / (tempTabell[0].length));
    }
    
    public double getMiddelTempTime(int time){
        
        double mtTime = 0;
        for (int i = 0; i < tempTabell.length; i++){
            mtTime += tempTabell[i][time];
        }
        return mtTime / (tempTabell.length);
    }
    
    public double getMiddelTempMnd(){
        
        double mtMnd = 0;
        for (int i = 0; i < tempTabell.length; i++){
            for(int j = 0; j < tempTabell[i].length; j++){
                mtMnd += tempTabell[i][j];
            }
        }
        return (mtMnd / (tempTabell.length * tempTabell[0].length));
    }
    
    public int[] getMiddelTempGrupper(){
        
        int[] mtGrupper = new int[5];
        for (int i = 0; i < tempTabell.length; i++){
            if (getMiddelTempDag(i) < (-5)){
                mtGrupper[0]++;
            } else if (getMiddelTempDag(i) > (-5) && getMiddelTempDag(i) < 0){
                mtGrupper[1]++;
            } else if (getMiddelTempDag(i) > 0 && getMiddelTempDag(i) < 5){
                mtGrupper[2]++;
            } else if (getMiddelTempDag(i) > 5 && getMiddelTempDag(i) < 10){
                mtGrupper[3]++;
            } else if (getMiddelTempDag(i) > 10){
                mtGrupper[4]++;
            }
        }
        return mtGrupper;
    }
}

class Temperaturer9_2{
    public static void main(String[] args){
        
        Temperaturer temp = new Temperaturer(31);
        
        int inputMeny = 0, input1 = 0, input2 = 0;
        boolean noExit = true;
        
        do{
            System.out.println("\n"+"Velg operasjon"+"\n"+"1: Mid.temp. dag"+"\n"+"2: Mid.temp. time"+"\n"+"3: Mid.temp. mnd"+"\n"+"4: Mid.temp. grupper"+"\n"+"5: Avslutt");
            Scanner in = new Scanner(System.in);
            inputMeny = in.nextInt();
            
            if(inputMeny == 1){
                System.out.println("Antall dager i maneden");
                Scanner inn = new Scanner(System.in);
                input1 = inn.nextInt();
                Temperaturer t = new Temperaturer(input1);
                System.out.println("Velg dag: ");
                input2 = inn.nextInt();
                t.getMiddelTempDag(input2);
                System.out.printf("Middeltemperaturen for valgt dag er: %.2f", t.getMiddelTempDag(input2));
            }
            if (inputMeny == 2){
                System.out.println("Antall dager i maneden");
                Scanner inn = new Scanner(System.in);
                input1 = inn.nextInt();
                Temperaturer t = new Temperaturer(input1);
                System.out.println("Velg time: ");
                input2 = inn.nextInt();
                t.getMiddelTempTime(input2);
                System.out.printf("Middeltemperaturen for klokkeslettet "+ input2 +" i hele maneden er: %.2f", t.getMiddelTempTime(input2));
            }
            if (inputMeny == 3){
                System.out.println("Antall dager i maneden");
                Scanner inn = new Scanner(System.in);
                input1 = inn.nextInt();
                Temperaturer t = new Temperaturer(input1);
                System.out.printf("Middeltemperaturen for hele maneden er: %.2f", t.getMiddelTempMnd());
            }
            if (inputMeny == 4){
                System.out.println("Antall dager i maneden");
                Scanner inn = new Scanner(System.in);
                input1 = inn.nextInt();
                Temperaturer t = new Temperaturer(input1);
                int[] grupper = t.getMiddelTempGrupper();
                
                System.out.println("Dager med middeltemperatur mindre enn -5 celcius: "+ grupper[0]);
                System.out.println("Dager med middeltemperatur mellom -5 og 0 celcius: "+ grupper[1]);
                System.out.println("Dager med middeltemperatur mellom 0 og 5 celcius: "+ grupper[2]);
                System.out.println("Dager med middeltemperatur mellom 5 og 10 celcius: "+ grupper[3]);
                System.out.println("Dager med middeltemperatur storre enn 10 celcius: : "+ grupper[4]);
            }
            if (inputMeny == 5){
                noExit = false;
            }
            if (inputMeny < 1 || inputMeny > 5){
                System.out.println("Ikke gyldig operasjon, prov igjen."+"\n");
            }
        } while (noExit);
    }
}