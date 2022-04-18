
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MenuController implements Initializable {
   
    @FXML
    private Label nameUserLabel;
    
    
    @FXML
    private AnchorPane AnchorPane;
    
    
    @FXML
    private Button LogOutButton;
  
    
    @FXML
    void OnLogOutButton(ActionEvent event) throws IOException{
   
    AnchorPane.getScene().getWindow().hide();
        
           Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.show();
    
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    public void onGetData(String fullName,String id){
        
        this.nameUserLabel.setText(fullName);

    }    
    
}
