
package controller;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Form1Controller implements Initializable {

    @FXML
    private Label IdUser;
    
    
    @FXML
    private TextField MedicineName;
    
    @FXML
    private VBox Vbox;
    
    @FXML
    private Label NameUser;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void onGetData(String id,String name) {
        this.IdUser.setText(id);
        this.NameUser.setText(name);
    }
    
      @FXML
    void OnNextForm(ActionEvent event) throws IOException {
        
        String name = NameUser.getText();
          
        String id = IdUser.getText();
        String Medicine = MedicineName.getText();
       
        if(Medicine == ""){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
            alert.setTitle("MediAlarm");
            alert.setHeaderText("Debes ingresar un medicamento , "+name);
            alert.showAndWait();                       
                                   
         
        }else{
        
        Vbox.getScene().getWindow().hide();           
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form2.fxml"));
                Parent root = (Parent) loader.load();           
                Form2Controller secController = loader.getController();
                secController.onGetData(id,Medicine,name);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
       
        }
    }
    
      @FXML
    void onBackButton(ActionEvent event) throws IOException {
                String fullName =NameUser.getText() ;
                String IdUser = this.IdUser.getText();
                
                Vbox.getScene().getWindow().hide();           
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent) loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
    }
    
}
