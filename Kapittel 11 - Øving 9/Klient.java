import java.util.Scanner;

class Person{
    
    final String fornavn;
    final String etternavn;
    final int fodselsar;
    
    public Person(String fornavn, String etternavn, int fodselsar){
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsar = fodselsar;
    }
    
    public String getFornavn(){
        return fornavn;
    }
    
    public String getEtternavn(){
        return etternavn;
    }
    
    public int getFodselsar(){
        return fodselsar;
    }
}

class ArbTaker{
    Person personalia;
    long arbtakernr;
    int ansettelsesar;
    int manedslonn;
    double Skatteprosent;
    
    public ArbTaker(Person personalia, long arbtakernr, int ansettelsesar, int manedslonn, double Skatteprosent){
        this.personalia = personalia;
        this.arbtakernr = arbtakernr;
        this.ansettelsesar = ansettelsesar;
        this.manedslonn = manedslonn;
        this.Skatteprosent = Skatteprosent;
    }
    
    public String getPersonalia(){
        return personalia.getEtternavn() + ", " + personalia.getFornavn() + " (" + personalia.getFodselsar() + ")";
    }
    
    public long getArbtakernr(){
        return arbtakernr;
    }
    
    public int getAnsettelsesar(){
        return ansettelsesar;
    }
    
    public int getManedslonn(){
        return manedslonn;
    }
    
    public void setManedsLonn(int manedslonn){
        this.manedslonn = manedslonn;
    }
    
    public double getSkatteprosent(){
        return Skatteprosent;
    }
    
    public void setSkatteprosent(double Skatteprosent){
        this.Skatteprosent = Skatteprosent;
    }
    
    public int getSkatteTrekkPerManed(){
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        int måned = kalender.get(java.util.Calendar.MONTH);
        if (måned == 6){
            return 0;
        } else if (måned == 12){
            return (int) ((double)getManedslonn() * getSkatteprosent() / 200);
        } else {
            return (int) ((double)getManedslonn() * getSkatteprosent() / 100);
        }
    }
    
    public int getBruttoLonnAr(){
        return getManedslonn() * 12;
    }
    
    public int getSkatteTrekkPerAr(){
        return (int) ((double)getManedslonn() * getSkatteprosent() * 10.5 / 100);
    }
    
    public String getNavnEtternavnFornavn(){
        return personalia.getEtternavn() + ", " + personalia.getFornavn();
    }
    
    public int getAlder(){
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        return kalender.get(java.util.Calendar.YEAR) - personalia.getFodselsar();
    }
    
    public int getAransatt(){
        java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
        return kalender.get(java.util.Calendar.YEAR) - getAnsettelsesar();
    }
    
    public boolean getAnsattLengreEnn(int ar){
        return (getAransatt() > ar);
    }
    
    public String toString(){
        return "\n" + "Navn: " + getNavnEtternavnFornavn() +
               "\n" + "fodselsar: " + personalia.getFodselsar() + 
               "\n" + "Alder: " + getAlder() + 
               "\n" + "Antall ar ansatt: " + getAransatt() + 
               "\n" + "Arbeidstaker nummer: " + getArbtakernr() + 
               "\n" + "Skatteprosent: " + getSkatteprosent() + 
               "\n" + "Brutto manedslonn: " + getManedslonn() + " kroner" +
               "\n" + "Manedlig skattetrekk: " + getSkatteTrekkPerManed() + " kroner" +
               "\n" + "Arlig bruttolonn: " + getBruttoLonnAr() +  " kroner" +
               "\n" + "Arlig skattetrekk: " + getSkatteTrekkPerAr() + " kroner";
    }
}

class Input{
    
    public Input(){
    }

    public double getDouble(String dialog){
        
		System.out.println(dialog); 
		Scanner sc = new Scanner(System.in);
		double inputTall = sc.nextDouble();
		return inputTall;
    }
    
    public int getInt(String dialog){
    
		System.out.println(dialog); 
		Scanner sc = new Scanner(System.in);
		int inputTall = sc.nextInt();
		return inputTall;
    }
    
    public long getLong(String dialog){
        
        System.out.println(dialog); 
        Scanner sc = new Scanner(System.in);
        long inputTall = sc.nextLong();
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
    java.util.GregorianCalendar kalender = new java.util.GregorianCalendar();
    Person person = new Person("Hans", "Hansen", 1980);
    ArbTaker arbtaker = new ArbTaker(person, 1234567890L, 1995, 45000, 28.3);
    
    boolean noExit = true;
    int ar = 0;
    int inputTall = 0;
    
    while (noExit){
    
        System.out.println(arbtaker.toString());
        
        switch(input.getInt("\n1: Legg inn ny person\n2: Sett ny manedslonn\n3: Sett ny Skatteprosent\n4: Avslutt")){
        
            case 1: person = new Person(input.getString("\n"+"Fornavn: "), input.getString("\n"+"Etternavn: "), input.getInt("\n"+"Fodselsar: "));
                    arbtaker = new ArbTaker(person, input.getLong("\n"+"Arbeidstaker nummer: "), input.getInt("\n"+"Ansettelsesar: "), input.getInt("\n"+"Manedslonn: "), input.getDouble("\n"+"Skatteprosent: "));
                    break;
                    
            case 2: arbtaker.setManedsLonn(input.getInt("\n"+"Ny manedslonn: "));
                    break;
                    
            case 3: arbtaker.setSkatteprosent(input.getDouble("\n"+"Ny Skatteprosent: "));
                    break;       
             
            case 4: noExit = false;
                    break;
                    
            default: System.out.println("\n"+"Ikke gyldig operasjon, prov igjen.");
                     return;
            }
        }
    }
}