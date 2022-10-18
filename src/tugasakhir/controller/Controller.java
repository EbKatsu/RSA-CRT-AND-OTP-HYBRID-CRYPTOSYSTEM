package tugasakhir.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tugasakhir.Model.Crypto;

public class Controller extends Crypto{
    
    public String displayContent(String fpath)   
    {  
     try   
     {  
      BufferedReader br = new BufferedReader(new FileReader(fpath));  
      String s1 = "", s2 = "";  
      while ((s1 = br.readLine()) != null)
      {  
       s2 += s1;  
      }  
      return s2;
     }   
     catch (Exception e)   
     {  
      e.printStackTrace();  
     }  
     return null;
    } 
    
    public String displayKey(String fpath)   
    {  
     try   
     {  
      BufferedReader br = new BufferedReader(new FileReader(fpath));  
      String s1 = "", s2 = "";  
      while ((s1 = br.readLine()) != null)   
      {  
       s2 += s1;  
      }  
      return s2;
     }   
     catch (Exception e)   
     {  
      e.printStackTrace();  
     }  
     return null;
    } 
    
    public long randomPrimeP() {
        while (true) {
           long randomNum = 1009 + (int)(Math.random() * (8964));
            if(isPrime(randomNum)){
               long p = randomNum;
                 return p;
            }
        }
    }

    public long randomPrimeQ() {
        while (true) {
           long randomNum = 1009 + (int)(Math.random() * (8964));
            if(isPrime(randomNum)){
               long q = randomNum;
                 return q;
            }
        }
    }
    
    public void saveCyphertext(String txt) {
        try {
            FileWriter myWriter = new FileWriter("D://tugasAkhir//cypherText.txt");
            myWriter.write(txt);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void saveCypherkey(String txt) {
        try {
            FileWriter myWriter = new FileWriter("D://tugasAkhir//cypherKey.txt");
            myWriter.write(txt);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public void saveptResult(String txt) {
        try {
            FileWriter myWriter = new FileWriter("D://tugasAkhir//textResult.txt");
            myWriter.write(txt);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    public String modPlaintxt(String txt) {
        char[] modPlain = txt.toCharArray();
        
        modPlain[0] = '0';
        
        String modtxt = "";
        
        for (int i = 0; i < modPlain.length; i++) {
            modtxt += modPlain[i];
        }
        return modtxt;
    }
        
    public double getEncStartTime(){
        double startTime = System.nanoTime();
        return startTime;
    }
    
    public double getEncEndTime(){
        double endTime = System.nanoTime();
        return endTime;
    }
    
    public double countRunningTime(double start, double end){
        return (end - start)/1000000;
    }
    
    public boolean isPrime(long n){
        int i;
       for(i=2;i<=Math.sqrt(n);i++){
           if(n % i == 0){
               return false;
           }
       }
       return true;
    }

    public boolean keyCheck(String key) {
        try (FileReader fileInvc = new FileReader("D://tugasAkhir//keyLog//keyLog.txt");
            BufferedReader readervc = new BufferedReader(fileInvc)) {
            String readvc = readervc.readLine();
                while (readvc != null) {
                    if (readvc.contains(key)) {
                        return true;
                    }
                    readvc = readervc.readLine();
                }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Crypto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public StringBuilder ambilBit(String txt) {
        StringBuilder sb = new StringBuilder();
         
            char[] chars = txt.toCharArray();
            for (char c : chars) {
                String binary = Integer.toBinaryString(c);
                String formatted = String.format("%8s", binary);
                String output = formatted.replaceAll(" ", "0");
                sb.append(output);
                sb.append(" ");
            }
         return sb;
    }
}
