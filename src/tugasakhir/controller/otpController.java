package tugasakhir.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import tugasakhir.Model.*;

public class otpController extends Crypto{
        
    Controller ctrl = new Controller();
    
    public String encrypt(String plainText, String otpKey) {
        char[] pText = plainText.toCharArray();
        char[] cText = new char[pText.length];
        char[] otpKunci = otpKey.toCharArray();
        
        String cipherText = "";
        
        for (int i = 0; i < pText.length; i++) {
            cText[i] = (char)(pText[i] + otpKunci[i] % 26);
        }
        
        for (int i = 0; i < cText.length; i++) {
            cipherText += cText[i];
        }
        return cipherText;
    }
    
    public String decrypt(String cipherText, String otpKey) {
        char[] cText = cipherText.toCharArray();
        char[] pText = new char[cText.length];
        char[] otpKunci = otpKey.toCharArray();

        String plainText = "";

        for (int i = 0; i < cText.length; i++) {
            pText[i] = (char)(cText[i] - otpKunci[i] % 26);
        }

        for (int i = 0; i < pText.length; i++) {
            plainText += pText[i];
        }
        return plainText;
    }
    
    public String generateOTPKey(int OTPKeyLength) {
        char[] otpk = new char[OTPKeyLength];
        
        String otpkey = "";
        
        while(ctrl.keyCheck(otpkey) == true || otpkey == ""){
            for (int i = 0; i < OTPKeyLength; i++) {
                int Random = (int) (Math.random() * (127 - 32) + 32);
                otpk[i] = (char)Random;
            }
        
            for (int i = 0; i < otpk.length; i++) {
                otpkey += otpk[i];
            }
        }
        return otpkey;
    }
    
    public void saveUsedKey(String otpkey) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D://tugasAkhir//keyLog//keyLog.txt"));
            String s1 = "", s2 = "";  
            while ((s1 = br.readLine()) != null)   
            {  
                s2 += s1 + "\n";  
            }
            
            s2 = s2 + otpkey;
            
            FileWriter myWriter = new FileWriter("D://tugasAkhir//keyLog//keyLog.txt");
            myWriter.write(s2);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    
    
    
}
