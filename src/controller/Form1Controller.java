
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Form1Controller implements Initializable {

    @FXML
    private Label IdUser;
    
    
    @FXML
    private TextField MedicineName;
    
    @FXML
    private VBox Vbox;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    public void onGetData(String id) {
        this.IdUser.setText(id);
    }
    
      @FXML
    void OnNextForm(ActionEvent event) throws IOException {
        String id = IdUser.getText();
        String Medicine = MedicineName.getText();
        
        Vbox.getScene().getWindow().hide();           
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form2.fxml"));
                Parent root = (Parent) loader.load();           
                Form2Controller secController = loader.getController();
                secController.onGetData(id,Medicine);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.show();
       

    }
    
}
