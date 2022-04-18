package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class CodePasswordController implements Initializable {

    @FXML
    private Label Code;
    
    @FXML
    private TextField Code1;

    @FXML
    private TextField code2;

    @FXML
    private TextField code3;

    @FXML
    private TextField code4;

    @FXML
    private TextField code5;
    
    @FXML
    private Label nameLabel;
   
    @FXML
    private Label userEmail;
    
    
      @FXML
    void Code1KeyTyped(KeyEvent event) {
        int maxlenght = 1;
          if (Code1.getText().length() > maxlenght ) {
             Code1.deletePreviousChar();
              
          }
          
    }
    @FXML
    void code2KeyTyped(KeyEvent event) {
         int maxlenght = 1;
          if (code2.getText().length() > maxlenght ) {
             code2.deletePreviousChar();
              
          }
    }

    @FXML
    void code3KeyTyped(KeyEvent event) {
        int maxlenght = 1;
          if (code3.getText().length() > maxlenght ) {
             code3.deletePreviousChar();
              
          }

    }

    @FXML
    void code4KeyTyped(KeyEvent event) {
            int maxlenght = 1;
          if (code4.getText().length() > maxlenght ) {
             code4.deletePreviousChar();
              
          }
    }

    @FXML
    void code5KeyTyped(KeyEvent event) {
         int maxlenght = 1;
          if (code5.getText().length() > maxlenght ) {
             code5.deletePreviousChar();
              
          }

    }
    
    
    @FXML
    public void OnGetCodeButton(){
    
        String codigo1,codigo2, codigo3,codigo4, codigo5;
    
        codigo1 = Code1.getText();
        codigo2 = code2.getText();
        codigo3 = code3.getText();
        codigo4 = code4.getText();
        codigo5 = code5.getText();
       
        String codeGenerate = Code.getText();
       
        String codeUser = codigo1+codigo2+codigo3+codigo4+codigo5;
       
        if (codeGenerate.equals(codeUser)) {
            
            try {
                Code1.getScene().getWindow().hide();
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/NewPassword.fxml"));
                Parent root = (Parent) loader.load();
                
                NewPasswordController secController = loader.getController();
                secController.getData(userEmail.getText());
                
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
        } else {
            System.out.println("El codigo no es correcto");
        }
        
    
    }
  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       
    }    
    
     public void OnGetData(int code,String fullName,String email) {     
         
        this.Code.setText(Integer.toString(code)); 
        this.nameLabel.setText(fullName);
        this.userEmail.setText(email);
        
    }
    
}
