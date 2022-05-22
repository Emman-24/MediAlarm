
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConsultNews {
    
     public List<News>searchNews(String category){
         
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<News> ls = new ArrayList<>();
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT * FROM `news` WHERE `category`= ?";
        
         try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,category);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                News post = new News();
                post.setNameTitular(result.getString("nameTitular"));
                post.setLink(result.getString("link"));
                post.setImgSrc(result.getBytes("imgSrc"));
                
                ls.add(post);      
                
            } return ls;
           
            
        } catch (SQLException e) {
            System.out.println("Hubo un error: "+e);    
        }
        
     return null;
     }
     
     
}
