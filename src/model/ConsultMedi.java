
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultMedi extends MysqlConnect {
    
     public List<Medi>searchMedicine(String id){
        
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
        ResultSet result = null;
        
        List<Medi> ls = new ArrayList<>();
        
        connection = miConexion.getConnection();
        
        String sql = "SELECT id, NombreMedicamento, Cantidad, MedidaCantida, NumeroPastillas, PosImageSrc, Hora, FormaMedi FROM medicine WHERE idUser = ? AND showMedi = 1";
        
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            
            result = statement.executeQuery();
            
            while(result.next()){
                
                Medi post = new Medi();
                
                post.setIdMedi( result.getInt("id"));
                post.setNombreMedicamento(result.getString("NombreMedicamento"));
                post.setCantidad(result.getString("Cantidad"));
                post.setMedidaCantida(result.getString("MedidaCantida"));
                post.setNumeroPastillas(result.getString("NumeroPastillas"));
                post.setPostImageSrc(result.getString("PosImageSrc")); 
                post.setHora(result.getString("Hora"));
                post.setFormaMedi(result.getString("FormaMedi"));
                
                
                ls.add(post);
                
               
                
            } return ls;
           
            
        } catch (SQLException e) {
            System.out.println("Hubo un error: "+e);
          
        }
        
    return null;
    
    
    }
    
     public boolean RegisterMedi(Medi medi){
     
        Connection connection = null;
        MysqlConnect miConexion = new MysqlConnect();
        PreparedStatement statement = null;
              
        connection = miConexion.getConnection();
        
          String sql ="INSERT INTO `medicine` (`id`, `idUser`, `NombreMedicamento`, `FormaMedi`, `Cantidad`, `MedidaCantida`,showMedi, `NumeroPastillas`, `PosImageSrc`, `Hora`, `VencimientoMedi`) VALUES (NULL, ?, ?, ?, ?, ?,1, ?, ?, ?, ?);";
          
          try {
              statement = connection.prepareStatement(sql);
              statement.setString(1, medi.getIdUserMedi());
              statement.setString(2, medi.getNombreMedicamento());
              statement.setString(3, medi.getFormaMedi());
              statement.setString(4, medi.getCantidad());
              statement.setString(5, medi.getMedidaCantida());
              statement.setString(6,medi.getNumeroPastillas());
              statement.setString(7, medi.getPostImageSrc());
              statement.setString(8,medi.getHora());
              statement.setString(9, medi.getVencimientoMedi());
             
               statement.execute();
               
                return true;
                
         } catch (Exception e) {
             System.out.println("Hubo un error: "+e);
         }
         
     return false;
     
     }
     
     public boolean UpdateMedicine(String id){
     
        String sql = "UPDATE `medicine` SET `showMedi` = '0' WHERE `medicine`.`id` = 10;";
     return false;
     }
}
