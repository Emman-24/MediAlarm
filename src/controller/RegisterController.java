
package controller;

import cripto.hash;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.ConsultUser;
import model.User;
import model.User_Seguity;


public class RegisterController implements Initializable {

    @FXML
    private Button NewUserButton;

    @FXML
    private Label loginLabel;

    @FXML
    private TextField txtApellido;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword1;

    @FXML
    private PasswordField txtPassword2;

    @FXML
    private void OnMouseClickLoginReturn() throws IOException{
        
         NewUserButton.getScene().getWindow().hide();
    
         Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.show();
    
    }
       
    
    @FXML
    private void OnMouseClickRegisterButton() throws IOException{
    
          String name = txtName.getText();
          String lastname = txtApellido.getText();
          String email = txtCorreo.getText();
          String pass = txtPassword1.getText();
          String pass2 = txtPassword2.getText();
          
        
            if(pass.equals(pass2)){  
                           
                  String passwordEncode = hash.encryptThisString(pass);
                
                  ConsultUser con = new ConsultUser();
            
                  User user = new User(name, lastname);
           
                  String id =  con.RegisterUserModel(user);
                                  
                  if(id != null){
                      
                      User_Seguity seg = new User_Seguity(id,email,passwordEncode);
                      
                       boolean res = con.RegisterUserSeguirityModel(seg);
                       
                       if(res == true){
                       
                            
                          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                          alert.setHeaderText(null);
                          alert.setTitle("Registro exitoso");
                          alert.setContentText("Usuario Registrado");
                          alert.showAndWait();
                          
                           NewUserButton.getScene().getWindow().hide();
                  
                          Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
                          Scene scene = new Scene(root);     
                          Stage stage = new Stage();     
                          stage.setScene(scene);       
                          stage.setTitle("MediAlarm"); 
                          stage.show();
                       
                       
                       }
         
                  }
                  
                }else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                       alert.setTitle("Contraseñas no son iguales");
                       alert.setContentText("Lo siento , pero sus contraseñas no coinciden");
                              alert.showAndWait();
                 }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
