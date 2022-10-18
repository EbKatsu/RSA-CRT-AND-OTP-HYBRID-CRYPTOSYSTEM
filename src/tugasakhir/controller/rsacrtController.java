package tugasakhir.controller;
import java.math.BigInteger;
import tugasakhir.Model.*;

public class rsacrtController extends Crypto{
    
    public long generateKeyNRSACRT(long pVal, long qVal) {
        long n = pVal * qVal;
        return n;
    }
    
    public long generateKeydpRSACRT(long pVal, long eVal) {
        return modInverse(eVal, pVal - 1);
    }
    
    public long generateKeydqRSACRT(long qVal, long eVal) {
        return modInverse(eVal, qVal - 1);
    }
    
    public long generateKeyqInvRSACRT(long pVal, long qVal) {
        return modInverse(qVal, pVal);
    }
    
    public long generateKeyDRSACRT(long pVal, long qVal, long eVal, long nVal) {
        long totientFunction = nVal - (pVal + qVal - 1);
        return modInverse(eVal, totientFunction);
    }
    
    public long generateKeyERSACRT() {
        return 65537;
    }
    
    public String encrypt(String plaintext, long nVal, long eVal) {
        int messageLength = plaintext.length();
        
        int[] messageArrayInt = new int[messageLength];
        long[] cipher =  new long[messageLength];
        for(int j=0;j<messageLength;j++){
            char character = plaintext.charAt(j);
            messageArrayInt[j]=(int)character;
            cipher[j] = encryptDecrypt(messageArrayInt[j], eVal, nVal);
        }
        String cipherkey = "";
        
        for(int j=0;j<messageLength;j++){
            cipherkey += cipher[j];
            if (j != messageLength - 1) {
                cipherkey += " ";
            }
        }
        return cipherkey;
    }

    public String decrypt(String cyphertext, long pVal, long qVal, long dpVal, long dqVal, long qInv) {
        String[] cipher =  cyphertext.split(" ");
        Long[] ciph = new Long[cipher.length];
        
        for (int i = 0; i < cipher.length; i++) {
            ciph[i] = Long.parseLong(cipher[i]);
        }
        
        
        char[] decMessage = new char[cipher.length];
        for(int j=0;j<cipher.length;j++){
            long m1 = encryptDecrypt(ciph[j], dpVal, pVal);
            long m2 = encryptDecrypt(ciph[j], dqVal, qVal);
            long h = (qInv*(m1-m2))%pVal;
            int m = (int) (m2+h*qVal);
            decMessage[j] = (char)m;
    }
        String finalMessage = String.valueOf(decMessage);
        return finalMessage;
    }
    
    public static BigInteger power(long a, long b){
        int B = (int) b;
        BigInteger result = new BigInteger("1");
        result= result.multiply(BigInteger.valueOf(a));
        result = result.pow(B);
        return result;
    }

    public static long encryptDecrypt(long a, long b, long n){
        BigInteger result = power(a,b);
        BigInteger bigN = BigInteger.valueOf(n);
        result = result.remainder(bigN);
        return result.longValue();
    }
    
    public static Egcd egcd(long a, long b){
        Egcd newegcd  = new Egcd();
        if(a==0){
            newegcd.setA(b);
            newegcd.setB(0);
            newegcd.setC(1);
            return newegcd;
        }else {
            Egcd negcd = egcd((b%a),a);
            long x = negcd.getC();
            long y = negcd.getB();
            negcd.setC(y);
            negcd.setB((x-(b/a)*y));
            return negcd;
        }
    }
    
    public long modInverse(long a, long m){
        Egcd newegcd = egcd(a,m);
        if(newegcd.getA()!=1){
            return 0;
        }else{
            return ((m+newegcd.getB())%m)%m;
        }
    }
}
