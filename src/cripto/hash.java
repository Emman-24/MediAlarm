
package cripto;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class hash {
    
    public static String encryptThisString(String input){
    
        try{
        
             MessageDigest md = MessageDigest.getInstance("SHA-512");
             
             byte[] messaDigest = md.digest(input.getBytes());
             
             BigInteger no = new BigInteger(1,messaDigest);
             
             String hashtext = no.toString(16);
             
             while (hashtext.length() < 32) {                
                hashtext = "0" + hashtext;
            }
        
             return hashtext;
             
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        
        }
        
    }
    
    
    public boolean isValidUsername(String name){
    
        String regex = "^[A-Za-z]\\w{5,29}$";
        
        Pattern p = Pattern.compile(regex);
        
        if(name == null){
            return false;
        }
        
        Matcher m = p.matcher(name);
        
        return m.matches();
    
    }
    
}
