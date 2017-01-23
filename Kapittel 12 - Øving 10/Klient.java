import java.util.Scanner;

class Student{
    
    private String navn;
    private int antOppg;
    
    public Student(String navn, int antOppg){
        this.navn = navn;
        this.antOppg = antOppg;
    }
    
    public String getNavn(){
        return navn;
    }
    
    public int getAntOppg(){
        return antOppg;
    }
    
    public void okAntOppg(int okning){
        antOppg += okning;
    }
    
    public String toString(){
        return "Student " + navn + ", antall oppgaver: " + antOppg;
    }

}

class Oppgaveoversikt{

    private Student[] studenter = new Student[0];
    private int antStudenter = 0;
    
    public int getAntStudenter(){
        return studenter.length;
    }
    
    public int getAntOppgGodkjent(String navn){
        int indeks = StudentIndeks(navn);
        return studenter[indeks].getAntOppg();
    }
    
    public boolean leggTilStudent(String navn, int antOppg){
        if (StudentIndeks(navn) == -1){
            int indeks = utvidTabell();
            studenter[indeks] = new Student(navn, antOppg);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean okAntOppgStudent(String navn, int okning){
        int indeks = StudentIndeks(navn);
        if (indeks == -1){
            return false;
        }
        
        studenter[indeks].okAntOppg(okning);
        return true;
    }
    
    private int StudentIndeks(String navn){
        for (int i = 0; i < studenter.length; i++){
            if (navn.matches(studenter[i].getNavn())){
                return i;
            }
        }
        return -1;
    }
    
    private int utvidTabell(){
        for (int i = 0; i < studenter.length; i++){
            if (studenter[i] == null){
                return i;
            }
        }
        
        Student[] nystudenter = new Student[studenter.length + 1];
        
        for(int i = 0; i < studenter.length; i++){
            nystudenter[i] = studenter[i];
        }
        
        this.studenter = nystudenter;
        return studenter.length - 1;
    }
    
    public String toString(){
        String output = "";
        for (int i = 0; i < studenter.length; i++){
            output += "Student: " + studenter[i].getNavn() + ", oppgaver godkjent: " + studenter[i].getAntOppg() + "\n";
        }
        return output;
    }
    
}

class Input{

    public Input(){
    }
    
    public int getInt(String dialog){
        
        int inputTall = 0;
        System.out.println(dialog);
        Scanner sc = new Scanner(System.in);
        inputTall = sc.nextInt();
        return inputTall;
    }
    
    public String getString(String dialog){
    
        String inputString = "";
		System.out.println(dialog);
		Scanner sc = new Scanner(System.in);
		inputString = sc.nextLine();

		return inputString;
    }
}

class Klient{
    public static void main(String[] args){

        Input input = new Input();
        Oppgaveoversikt oppgOversikt = new Oppgaveoversikt();

        boolean noExit = true;
        int inputMeny = 0;

        while(noExit){

            inputMeny = input.getInt("1: Legg til student"+"\n"+"2: Vis antall studenter"+"\n"+"3: Vis alle studenter"+"\n"+"4: Legg til oppgaver for student"+
                              "\n"+"5: Vis antall oppgaver gjort av en student"+"\n"+"6: Avslutt");

            switch (inputMeny){

                case 1: if (oppgOversikt.leggTilStudent(input.getString("\n"+"Navn: "), input.getInt("Antall oppgaver studenten har gjort: "))){
                            System.out.println("\n"+"Student lagt til"+"\n");
                            break;
                        } else {
                            System.out.println("Student eksisterer allerede."+"\n");
                            break;
                        }

                case 2: System.out.println("\n"+"Antall studenter: " + oppgOversikt.getAntStudenter() + "\n");
                        break;

                case 3: System.out.println("\n" + oppgOversikt.toString());
                        break;

                case 4: String inString1 = input.getString("\n"+"Navn pa student: ");
                        oppgOversikt.okAntOppgStudent(inString1, input.getInt("Antall nye oppgaver: "));
                        System.out.println("Studenten har gjort " + oppgOversikt.getAntOppgGodkjent(inString1) + " oppgaver."+"\n");
                        break;

                case 5: String inString2 = input.getString("\n"+"Navn pa student: ");
                        System.out.println(inString2 + " har gjort " + oppgOversikt.getAntOppgGodkjent(inString2) + " oppgaver."+"\n");
                        break;

                case 6: noExit = false;
                        break;

                default: System.out.println("\n"+"Ikke gyldig operasjon, prov igjen."+"\n");
                         break;
            }
        }
    }
}