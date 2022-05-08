
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



public class MenuController implements Initializable {
   
    private static String myVariable;
  
    @FXML
    private Label nameUserLabel;
    
    @FXML
    private Label UserId;
    
    @FXML
    private AnchorPane AnchorPane;
    
    
    @FXML
    private Button LogOutButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
  
    
    @FXML
    void OnLogOutButton(ActionEvent event) throws IOException{
   
    AnchorPane.getScene().getWindow().hide();
        
           Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml")); 
           stage= (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.show();
    
    
    }
    
     @FXML
    void OnCalendarButton(ActionEvent event) throws IOException {

       
                String fullName = nameUserLabel.getText();
                String IdUser = UserId.getText();
                
                AnchorPane.getScene().getWindow().hide();
                
                setMyVariable(IdUser);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent) loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.show();

    }
    
    @FXML
    void OnMussicButton(ActionEvent event) throws IOException {
           AnchorPane.getScene().getWindow().hide();
        
           Parent root = FXMLLoader.load(getClass().getResource("/view/Music.fxml"));     
           Scene scene = new Scene(root);     
           Stage stage = new Stage();     
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.show();
    }

    @FXML
    void OnNewsButton(ActionEvent event) throws IOException {
        AnchorPane.getScene().getWindow().hide();
        
           Parent root = FXMLLoader.load(getClass().getResource("/view/News.fxml"));     
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
        this.UserId.setText(id);

    }    
    
     public static String getMyVariable() {
        return myVariable;
    }

    public static void setMyVariable(String myVariable) {
        MenuController.myVariable = myVariable;
    }
    
}
