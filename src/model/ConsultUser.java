
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConsultUser extends MysqlConnect {
    
    public String login(String email,String password){
        
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        String name = null;
        String lastName = null;
        String fullName = null;
        String id = null;
    
        
        User us = new User();
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT * FROM users_segurity WHERE email= ? AND password =? ";
        
        try {
                    statement = connection.prepareStatement(sql);
                    statement.setString(1, email);
                    statement.setString(2, password);
                    
                    result = statement.executeQuery();
                  
                    if(result.next()){
                        id = Integer.toString(result.getInt("user_id"));
                        
                        return id;
                    }
                    
                             
                 
        } catch (SQLException e) {
         
             miConexion.Desconnect();
             
            return null;
        
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return null;
     
    }
    
    public String searchFullName(String id){
        
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        String name = null;
        String lastName = null;
        String fullName = null;
        
        User us = new User();
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT name, lastname FROM users WHERE user_id = ?";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            
            result = statement.executeQuery();
            
            if(result.next()){
                name = result.getString("name");
                lastName = result.getString("lastname");
                fullName = (name + " "+lastName);
            
                return fullName;
            }
            
        } catch (SQLException e) {
            System.out.println("Hubo un error: "+e);
          
        }
        
        
    
    return null;
    
    
    }
    
    public String RegisterUserModel(User user){
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        String id = null;
       
        
         connection = miConexion.getConnection();
         
         
          String sql = "INSERT INTO `users`(`name`, `lastname`) VALUES (?,?)";
          
          
          try {
            statement = connection.prepareStatement(sql,statement.RETURN_GENERATED_KEYS); 
            
       
            statement.setString(1, user.getName());
            statement.setString(2, user.getLastname());
            statement.execute();
            
           
            result = statement.getGeneratedKeys();
        
       
            
           if(result.next() && result != null){
               
               id = result.getString(1);
               System.out.println("Llave : "+ result.getInt(1));
                                        
                   return id;
                   
           }else{
           
               
           }
           
           
            } catch (SQLException e) {
                System.out.println("Hubo un error: "+e.getMessage());
            
            
                 return null;
            
           
        }
        return null;
          
      
          
          
    }
     
    public boolean RegisterUserSeguirityModel(User_Seguity user){
    
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
              
        connection = miConexion.getConnection();
        
        String sql = "INSERT INTO users_segurity( user_id,email,password) VALUES (?,?,?)";
        
        try {
            statement = connection.prepareStatement(sql);  
            statement.setString(1, user.getUser_id());
            statement.setString(2,user.getEmail());
            statement.setString(3,user.getPassword());
            
            statement.execute();
            
            return true;
            
        } catch (Exception e) {
             System.out.println("Hubo un error: "+e.getMessage());
            
            return false;
        }
    
    
    }
    
    public String VerifyEmailUser(String email){
    
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        String name = null;
        String lastName = null;
        String fullName = null;
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT users.name, users.lastname FROM users JOIN users_segurity WHERE email = ?";
        
        
        try {
            
           
                statement = connection.prepareStatement(sql);
                statement.setString(1,email);
                result = statement.executeQuery();
                
                
                if(result.next()){
                       
                        name = result.getString("name");
                        lastName = result.getString("lastname");
                        fullName = (name +" "+lastName);
                        
                        return fullName;
                    }
            
        } catch (SQLException e) { 
             System.out.println("Error en la consulta del usuario: "+e.getMessage());   
             miConexion.Desconnect();
             
            return null;
            
            
        }
        return null;
    
    
    }
    
    public boolean UpdatePassword(User_Seguity user){
     Connection connection = null;
     MysqlConnect miConexion = new MysqlConnect();
     PreparedStatement statement = null;
     
     connection = miConexion.getConnection();
   
        try {
            String sql = "UPDATE users_segurity SET password = ?  WHERE email = ? ";
            
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getPassword());
            statement.setString(2,user.getEmail());
            statement.executeUpdate();
            
            return true;
                   
            
        } catch (Exception e) {
            System.out.println("Eror aqui: "+e);
            return false;
        } 
    }  
}
