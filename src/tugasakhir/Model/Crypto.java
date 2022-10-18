package tugasakhir.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Crypto {
    private long nVal;
    private long eVal;
    private long dVal;
    private long dpVal;
    private long dqVal;
    private long qInvVal;
    private long pRandomVal;
    private long qRandomVal;
    private int OTPKeyLength;
    private String otpKey;
    private String plaintext;
    private String cyphertext;
    private String otpkeydec;
    private String plaintextdec;
    private String plaintextave;
    private String plaintextavemod;
    private String cyphertextave;
    private String cyphertextavemod;
    private String brwscyphertext;

    public void setDpVal(long dpVal) {
        this.dpVal = dpVal;
    }

    public void setDqVal(long dqVal) {
        this.dqVal = dqVal;
    }

    public void setqInvVal(long qInvVal) {
        this.qInvVal = qInvVal;
    }
    
    public void setCyphertextave(String cyphertextave) {
        this.cyphertextave = cyphertextave;
    }

    public void setCyphertextavemod(String cyphertextavemod) {
        this.cyphertextavemod = cyphertextavemod;
    }
    
    public void setPlaintextave(String plaintextave) {
        this.plaintextave = plaintextave;
    }

    public void setPlaintextavemod(String plaintextavemod) {
        this.plaintextavemod = plaintextavemod;
    }
    
    public void setBrwscyphertext(String brwscyphertext) {
        this.brwscyphertext = brwscyphertext;
    }

    public void setOtpkeydec(String otpkeydec) {
        this.otpkeydec = otpkeydec;
    }

    public void setPlaintextdec(String plaintextdec) {
        this.plaintextdec = plaintextdec;
    }

    public void setOtpKey(String otpKey) {
        this.otpKey = otpKey;
    }
    
    public void setpRandomVal(long pRandomVal) {
        this.pRandomVal = pRandomVal;
    }

    public void setqRandomVal(long qRandomVal) {
        this.qRandomVal = qRandomVal;
    }
    
    public void setOTPKeyLength(int OTPKeyLength) {
        this.OTPKeyLength = OTPKeyLength;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public void setCyphertext(String cyphertext) {
        this.cyphertext = cyphertext;
    }

    public void setnVal(long nVal) {
        this.nVal = nVal;
    }

    public void seteVal(long eVal) {
        this.eVal = eVal;
    }

    public void setdVal(long dVal) {
        this.dVal = dVal;
    }

    public long getDpVal() {
        return dpVal;
    }

    public long getDqVal() {
        return dqVal;
    }

    public long getqInvVal() {
        return qInvVal;
    }

    public String getCyphertextave() {
        return cyphertextave;
    }

    public String getCyphertextavemod() {
        return cyphertextavemod;
    }

    public String getPlaintextave() {
        return plaintextave;
    }

    public String getPlaintextavemod() {
        return plaintextavemod;
    }

    public String getBrwscyphertext() {
        return brwscyphertext;
    }

    public String getOtpkeydec() {
        return otpkeydec;
    }

    public String getPlaintextdec() {
        return plaintextdec;
    }

    public String getOtpKey() {
        return otpKey;
    }

    public long getpRandomVal() {
        return pRandomVal;
    }

    public long getqRandomVal() {
        return qRandomVal;
    }
    
    public long getnVal() {
        return nVal;
    }

    public long geteVal() {
        return eVal;
    }

    public long getdVal() {
        return dVal;
    }
    
    public int getOTPKeyLength() {
        return OTPKeyLength;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public String getCyphertext() {
        return cyphertext;
    }  
    
    
    
}
