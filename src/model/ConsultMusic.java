
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultMusic {
    
     public List<Music>searchMusic(){
         
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Music> ls = new ArrayList<>();
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT * FROM `music` ORDER BY `nameSong`";
        
         try {
            statement = connection.prepareStatement(sql);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Music post = new Music();
                
                post.setImgSrc(result.getBytes("img"));
                post.setNameArtist(result.getString("nameArtist"));
                post.setNameSong(result.getString("nameSong"));
                
                
                
                ls.add(post);
                
               
                
            } return ls;
           
            
        } catch (SQLException e) {
            System.out.println("Hubo un error: "+e);    
        }
        
     return null;
     }
     
     
     
       public List<Music> searchArtist(String nameSong){
         
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        List<Music> ls = new ArrayList<>();
        
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT `nameArtist`,`img` FROM `music` WHERE `nameSong` = ? ";
        
         try {
            statement = connection.prepareStatement(sql);
             statement.setString(1,nameSong);
            result = statement.executeQuery();
            
            while(result.next()){
                
                Music post = new Music();
                
                post.setImgSrc(result.getBytes("img"));
                post.setNameArtist(result.getString("nameArtist"));
   
                
                ls.add(post);
                
               
                
            } return ls;
           
            
        } catch (SQLException e) {
            System.out.println("Hubo un error: "+e);    
        }
        
     return null;
     }
}
