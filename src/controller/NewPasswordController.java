
package controller;

import cripto.hash;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.ConsultUser;
import model.User_Seguity;


public class NewPasswordController implements Initializable {

    
    @FXML
    private PasswordField LabelPass1;

    @FXML
    private PasswordField LabelPass2;
    
    @FXML
    private Label email;  
      
    @FXML
    private Button sendNewPasswordButton;
    
    
    
    @FXML
    void OnSendPassword(ActionEvent event) throws IOException {
        
        String pass1 = LabelPass1.getText();
        String pass2 = LabelPass2.getText();
        String emailUser = email.getText();
        
        ConsultUser us = new ConsultUser();
               
        if(pass1.equals(pass2)){
            
            String passwordEncode = hash.encryptThisString(pass1);
            
            User_Seguity user = new User_Seguity(passwordEncode, emailUser);
            
            boolean result =  us.UpdatePassword(user);
            
            if(result = true){
            
                  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                          alert.setHeaderText(null);
                          alert.setTitle("Contraseña");
                          alert.setContentText("Su contraseña ha sido cambiada exitosamente");
                          alert.showAndWait();
                          
                          sendNewPasswordButton.getScene().getWindow().hide();
                          
                          Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
                          Scene scene = new Scene(root);     
                          Stage stage = new Stage();     
                          stage.setScene(scene);       
                          stage.setTitle("MediAlarm"); 
                          stage.getIcons().add(new Image("/image/clockW.png"));
                          stage.show();
            
            }else if( result == false){
            
                System.out.println("Error en el mysql");
            
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

    public void getData(String email){
        
        this.email.setText(email);

    }    
    
}
