import java.io.*;
import java.util.Scanner;

class VedlikeholdKonto{
    public static void main(String[] args) throws IOException{
    
        String filSaldo = "saldo.txt";
        File filTransaksjoner = new File("transaksjoner.txt");
        
        FileReader frS = new FileReader(filSaldo);
        BufferedReader brS = new BufferedReader(frS);
        
        String saldoFil = brS.readLine();
        double saldo = Double.parseDouble(saldoFil);
        frS.close();
        
        FileReader frT = new FileReader(filTransaksjoner);
        BufferedReader brT = new BufferedReader(frT);
        Scanner sc = new Scanner(brT);
        
        while (sc.hasNext()){
            
            String transaksjoner = sc.nextLine();
            String[] ui = transaksjoner.split("[ ]");
            
            if (ui[0].equals("I")){
                saldo += Double.parseDouble(ui[1]);
            }
            if (ui[0].equals("U")){
                saldo -= Double.parseDouble(ui[1]);
            }
        }
        frT.close();
    
        if (saldo >= 0){
    
            FileWriter fw = new FileWriter(filSaldo);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
            pw.print(saldo);
            pw.close();
        } else {
            filTransaksjoner.delete();
        }
    }
}