
package model;

import java.sql.*;

public class MysqlConnect {
     private String nombreBd = "medialarm";
    private String usuario = "root";
    private String password="";
    private String url ="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
        + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
        + "serverTimezone=UTC";
    
    Connection conn = null;
    
    public MysqlConnect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,usuario,password);
            
            if(conn!=null){
                
            }
            
        } catch (ClassNotFoundException e) {
           
        } catch (SQLException e) { 
           
             
         } 
    }

    public Connection getConnection() {
        return conn;
    }
    
    public void Desconnect(){
        conn = null;
    }
  
}
