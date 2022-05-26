
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    private ChoiceBox<String> myChoiseBox;

    @FXML
    private Label nameCount;

    @FXML
    private Label nameMedi;

    @FXML
    private Label numCan;

    @FXML
    private TextField numCantidad;

    @FXML
    private Label selected;
    
    @FXML
    private Label nameUser;
    
    @FXML
    private Pane Pane2;
    private String pastillas = "Pastilla(s)";
    private String gotas = "Gota(s)";
    private String Inhalador = "Inhalacion(es)";
    private String solucion = "Frasco(s)";
    private String inyecciones = "Inyeccion(es)";

    private String[] hours = {"1:00","2:00","3:00","4:00","5:00","6:00","7:00","8:00","9:00","10:00","11:00",
        "12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00","21:00","22:00","23:00","24:00"};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

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
        
        myChoiseBox.getItems().addAll(hours);
        
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
    
       @FXML
    void OnNextForm(ActionEvent event) throws IOException {
        String hour = myChoiseBox.getValue();
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
                Parent root = (Parent) loader.load();           
                Form5Controller secController = loader.getController();
                secController.onGetData(idUser,nameMedi,imgSource,numCan,MedidCant,numPills,hour,FormaMedi,name);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.initModality(Modality.APPLICATION_MODAL); 
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
         
          

    }
    
}
