
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class TermsConditionsController implements Initializable {

    @FXML
    private TextArea Text;
    
    Stage stage;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    void OnClickClose(ActionEvent event){
    
        Text.getScene().getWindow().hide();
       
    
    }
    
}
