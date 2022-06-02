
package model;

import java.util.regex.Pattern;

public class User_Seguity {
    
    private String user_id;
    private String email;
    private String password;

    public User_Seguity( String user_id,String email,String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }
    
    public User_Seguity(String user_id){
         this.user_id = user_id;
    
    }
    
    public User_Seguity(String password, String email) {
        this.email = email;
        this.password = password;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
        public static boolean isValid(String email){
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                               "[a-zA-Z0-9_+&*-]+)*@" +
                               "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                               "A-Z]{2,7}$";

           Pattern pat = Pattern.compile(emailRegex);
           if (email == null)
               return false;
           return pat.matcher(email).matches();
       }
    
    
}
