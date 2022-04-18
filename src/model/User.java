
package model;


public class User extends MysqlConnect {
    
    private int user_id;
    private String name;
    private String lastname;
   
    
    
    public User(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;

    }

    public User() {
        
    }

   
    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
   
    
 
   
}
