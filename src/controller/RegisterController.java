
package controller;

import cripto.hash;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
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
    private CheckBox myCheckBox;
   


    @FXML
    private void OnMouseClickLoginReturn() throws IOException{
        
         NewUserButton.getScene().getWindow().hide();
    
         Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.getIcons().add(new Image("/image/clockW.png"));
           stage.show();
    
    }
       
    
    @FXML
    private void OnMouseClickRegisterButton() throws IOException{
    
          ArrayList<String> address = new ArrayList<>();
          String name = txtName.getText();
          String lastname = txtApellido.getText();
          String email = txtCorreo.getText();
          String pass = txtPassword1.getText();
          String pass2 = txtPassword2.getText();
          
         if(name != "" | lastname !=""){ 
             
          if(email != ""){ 
                
          address.add(email);
                 
          for(String i : address){
          
              if(User_Seguity.isValid(i)){
                  
                         if(pass  != ""  | pass2 != ""){ 
        
                                if(pass.equals(pass2)){
                                    
                                    if(myCheckBox.isSelected()){    
                                            
                                
                           
                                    String passwordEncode = hash.encryptThisString(pass);

                                    ConsultUser con = new ConsultUser();

                                    User user = new User(name, lastname);

                                    String id =  con.RegisterUserModel(user);

                                        if(id != null){

                                    User_Seguity seg = new User_Seguity(id,email,passwordEncode);

                                    boolean res = con.RegisterUserSeguirityModel(seg);

                                      if(res == true){
                       
                            
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                                alert.setHeaderText(null);
                                alert.setTitle("Registro exitoso");
                                alert.setContentText("Usuario Registrado");
                                alert.showAndWait();

                                 NewUserButton.getScene().getWindow().hide();

                                Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
                                Scene scene = new Scene(root);      
                                stage.setScene(scene);       
                                stage.setTitle("MediAlarm"); 
                                stage.getIcons().add(new Image("/image/clockW.png"));
                                stage.show();
                       
                                      }
                            }
         
                        }else{
                                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                                alert.setHeaderText(null);
                                alert.setTitle("Términos y Condiciones");
                                alert.setContentText("Debes aceptar nuestros terminos y condiciones para acceder a los servicios "
                                        + "de MediAlarm");
                                alert.showAndWait();
                                    
                                    
                                    }
                  
                }else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                       stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                       alert.setHeaderText(null);
                       alert.setTitle("Contraseñas no coinciden");
                       alert.setContentText("Lo siento , pero sus contraseñas no coinciden");
                       alert.showAndWait();
            
                    }
            }else{
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                       stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                       alert.setHeaderText(null);
                       alert.setTitle("Contraseñas no son iguales");
                       alert.setContentText("Lo siento , las contraseñas no pueden estar vacias");
                       alert.showAndWait();
                 }
        
                    
                  
                  
              }else{
                  
                  
                 
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                alert.setTitle("Email incorrecto");
                alert.setContentText("Lo siento , el correo eletrónico no es valido ");
                alert.showAndWait();
                  
                  
              }
          }
          
          }else{
              
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Correo electrónico");
                Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                alert.setContentText("Lo siento , debes ingresar tu correo electrónico ");
                alert.showAndWait();
              
          }
          
          
         }else{
         
                       Alert alert = new Alert(Alert.AlertType.ERROR);
                       alert.setHeaderText(null);
                        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                       stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                       alert.setTitle("Nombre y Apellido");
                       alert.setContentText("Lo siento , debes ingresar tu nombre completo");
                       alert.showAndWait();
             
         }
          
      
      
         
         
        
       
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    void onClickHyperlink(ActionEvent event) throws IOException{
        
   
         Parent root = FXMLLoader.load(getClass().getResource("/view/TermsConditions.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm");
           stage.initModality(Modality.WINDOW_MODAL);
           stage.setResizable(false);
           stage.initStyle(StageStyle.UNDECORATED);
           stage.getIcons().add(new Image("/image/clockW.png"));
           stage.show();
        
       
    }
    
}
