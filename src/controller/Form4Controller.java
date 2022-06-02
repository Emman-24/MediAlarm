
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Form4Controller implements Initializable {

    
    @FXML
    private Label IdUser;

    @FXML
    private Label imgSource;

    @FXML
    private Label method;


    @FXML
    private Label nameCount;

    @FXML
    private Label nameMedi;

    @FXML
    private Label numCan;
    
    @FXML
    private Button NextFormButton;

    @FXML
    private TextField numCantidad;

    @FXML
    private Label selected;
    
    @FXML
    private Label nameUser;
    
     @FXML
    private Spinner<Integer> SpinnerHour;

    @FXML
    private Spinner<Integer> SpinnerMinute;
    
    int currentValue;
    int currentValue2;
    
    @FXML
    private Pane Pane2;
    private String pastillas = "Pastilla(s)";
    private String gotas = "Gota(s)";
    private String Inhalador = "Inhalacion(es)";
    private String solucion = "Frasco(s)";
    private String inyecciones = "Inyeccion(es)";

    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,24) ;
         SpinnerValueFactory<Integer> valueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,60) ;
        
        valueFactory.setValue(24);
        valueFactory2.setValue(30);
        
        SpinnerHour.setValueFactory(valueFactory);
        SpinnerMinute.setValueFactory(valueFactory2);
       
        SpinnerHour.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        SpinnerMinute.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_VERTICAL);
        
        


        method.setText(method.getText() + Form3Controller.getMyVariable());
        
        String id = method.getText();
        
        if("Gotas".equals(id)){ 
            nameCount.setText(gotas);
        }else if("Inhalador".equals(id)){
          nameCount.setText(Inhalador);
        }else if("Solución".equals(id)){
          nameCount.setText(solucion);
        }else if("Inyección".equals(id)){
          nameCount.setText(inyecciones);
        }else if("Pastilla".equals(id)){
         nameCount.setText(pastillas);
        }
        
       
        
        NextFormButton.setOnAction((event) -> {
            
        currentValue = SpinnerHour.getValue();
        currentValue2 = SpinnerMinute.getValue();
        
        String h = Integer.toString(currentValue);
        String minute = Integer.toString(currentValue2);
        String hour = h+":"+minute;
            
            
      
        String numPills = numCantidad.getText();
        String idUser = IdUser.getText();
        String nameMedi = this.nameMedi.getText();
        String imgSource = this.imgSource.getText();
        String numCan = this.numCan.getText();
        String MedidCant = selected.getText();
        String FormaMedi = nameCount.getText();
        String name = nameUser.getText();
       
        Pane2.getScene().getWindow().hide();
        
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form5.fxml"));
                Parent root = null;           
            try {
                root = (Parent) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(Form4Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
                Form5Controller secController = loader.getController();
                secController.onGetData(idUser,nameMedi,imgSource,numCan,MedidCant,numPills,hour,FormaMedi,name);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL); 
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
            
        });
        
    }    

    void onGetData(String id, String nameMedi, String imgSource, String numCan, String selected, String method,String name) {
        IdUser.setText(id);
        this.nameMedi.setText(nameMedi);
        this.imgSource.setText(imgSource);
        this.numCan.setText(numCan);
        this.selected.setText(selected);
        this.method.setText(method);
        nameUser.setText(name);
        
    }
   
}
