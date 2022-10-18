package tugasakhir.controller;

import tugasakhir.Model.Crypto;

public class aveController extends Crypto{
    
    Controller ctrl = new Controller();
    
    public double hitungAvalanche(String plaintext, String plaintextmod) {
        StringBuilder hasil1 = ctrl.ambilBit(plaintext);
        StringBuilder hasil2 = ctrl.ambilBit(plaintextmod);
         
         if (hasil1.length() > hasil2.length()) {
             while(hasil1.length() > hasil2.length()){
                hasil2.append("00000000");  
                hasil2.append(" ");
            }
         }else{
             while(hasil2.length() > hasil1.length()){
                hasil1.append("00000000");  
                hasil1.append(" ");
            }
         }
                  
         double jumlahbit;
         if (hasil1.length() > hasil2.length()) {
                jumlahbit = hasil1.length();
        }else jumlahbit = hasil2.length();
         
         double jumlahbitbeda = 0;
         
         
         if (hasil1.length() == hasil2.length()) {
             for (int i = 0; i < jumlahbit; i++) {
                 if (hasil1.charAt(i)!= hasil2.charAt(i)) {
                     jumlahbitbeda = jumlahbitbeda + 1;
                 }
             }
         }else return -1;
         
         return (jumlahbitbeda * 100) / jumlahbit;
    }

    public int countBit(String plaintext, String plaintextmod) {
        StringBuilder hasil1 = ctrl.ambilBit(plaintext);
        StringBuilder hasil2 = ctrl.ambilBit(plaintextmod);
         
         if (hasil1.length() > hasil2.length()) {
             while(hasil1.length() > hasil2.length()){
                hasil2.append("00000000");  
                hasil2.append(" ");
            }
         }else{
             while(hasil2.length() > hasil1.length()){
                hasil1.append("00000000");  
                hasil1.append(" ");
            }
         }
         
         double jumlahbit;
         if (hasil1.length() > hasil2.length()) {
                jumlahbit = hasil1.length();
        }else jumlahbit = hasil2.length();
         
         return (int)jumlahbit;
    }

    public int diffBit(String plaintext, String plaintextmod) {
        StringBuilder hasil1 = ctrl.ambilBit(plaintext);
        StringBuilder hasil2 = ctrl.ambilBit(plaintextmod);
         
         if (hasil1.length() > hasil2.length()) {
             while(hasil1.length() > hasil2.length()){
                hasil2.append("00000000");  
                hasil2.append(" ");
            }
         }else{
             while(hasil2.length() > hasil1.length()){
                hasil1.append("00000000");  
                hasil1.append(" ");
            }
         }
         
         double jumlahbit;
         if (hasil1.length() > hasil2.length()) {
                jumlahbit = hasil1.length();
        }else jumlahbit = hasil2.length();
         
         double jumlahbitbeda = 0;
         
         
         if (hasil1.length() == hasil2.length()) {
             for (int i = 0; i < jumlahbit; i++) {
                 if (hasil1.charAt(i)!= hasil2.charAt(i)) {
                     jumlahbitbeda = jumlahbitbeda + 1;
                 }
             }
         }else return -1;
         return (int)jumlahbitbeda;
    }
}
