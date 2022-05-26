
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.ConsultUser;





public class PasswordRecoveryController implements Initializable {

    
    PasswordRecoveryController PasswordRecoveryController;
    
    @FXML
    private Button sendCodeButton;

    @FXML
    private TextField txtEmail;  
    
    int radomCode;
    
    @FXML
    public void onSendCodeButton(){
        
     String email = txtEmail.getText();
     
     if(email == ""){
         
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debes ingresar un corro electrónico.");
            alert.showAndWait();
     
     }else{
     
     
     
     ConsultUser con = new ConsultUser();
     
     String searchName = con.VerifyEmailUser(email);
        
        if (searchName != null) {
            
             try {
            
                    Random rand = new Random();
                    radomCode = rand.nextInt(99999);
                    String host = "smtp.gmail.com";
                    String user = "medialarm2098@gmail.com";
                    String pass = "medialarm123";
                    String to = email;
                    String subject = "Reseting code";
                    String message = "Your reset code is "+radomCode;
                    boolean sessionDebug = false;
       
       
                    Properties pros = System.getProperties();
                    pros.put("mail.smtp.starttls.enable","true");
                    pros.put("mail.smtp.host", "host");
                    pros.put("mail.smtp.port", "587");
                    pros.put("mail.smtp.auth","true");
                    pros.put("mail.smtp.starttls.required","true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(pros,null);

                    mailSession.setDebug(sessionDebug);

                    Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress(user));
                    InternetAddress[] address = { new InternetAddress(to)};
                    msg.setRecipients(Message.RecipientType.TO, address);
                    msg.setSubject(subject);
                    msg.setText(message);
       
                    try (Transport transport = mailSession.getTransport("smtp")) {
                        transport.connect(host, user, pass);
                        transport.sendMessage(msg, msg.getAllRecipients());
                    }

            
       
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setTitle("Codigo enviado");
            alert.setContentText("El codigo ha sido enviado a tu correo");
            alert.showAndWait();
                 

           
        try {
                 sendCodeButton.getScene().getWindow().hide();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/CodePassword.fxml"));
                Parent root = (Parent) loader.load();
                
                CodePasswordController secController = loader.getController();
                secController.OnGetData(radomCode, searchName, email);    
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
           
           
            
    }catch(Exception e){
        System.out.println(e);
 
    }
            
            
            
        }else if( searchName == null){
            
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El Correo electronico no se encuentra registrado");
            alert.showAndWait();


            }
        
        }
     
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        PasswordRecoveryController = this;
        
        
    }    

   @FXML
    void returnMenuButton(ActionEvent event) throws IOException {
        
        sendCodeButton.getScene().getWindow().hide();
        
         Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();  
           stage.setResizable(false);
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.getIcons().add(new Image("/image/clockW.png"));
           stage.show();
    
    }
    
}
