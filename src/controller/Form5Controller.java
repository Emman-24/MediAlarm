package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.ConsultMedi;
import model.Medi;



public class Form5Controller implements Initializable {

    @FXML
    private DatePicker myDate;
    private String idUser;
    private String nameMedi;
    private String FormaMedi;
    private String Cantidad;
    private String MedidadCantidad;
    private String NumeroPastillas;
    private String PosImageSrc;
    private String Hora;
    
    @FXML
    private Label nameUser;

    
    private Medi persona;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }


    public void initAttributes(){
    
    }

    void onGetData(String idUser, String nameMedi, String imgSource, String numCan, String MedidCant, String numPills, String hour,String FormaMedi,String name) {
        
        this.idUser = idUser;
        this.nameMedi = nameMedi;
        this.FormaMedi = FormaMedi;
        Cantidad = numCan;
        MedidadCantidad = MedidCant;
        NumeroPastillas = numPills;
        PosImageSrc = imgSource;
        Hora = hour;
        nameUser.setText(name);
       
    }
    
      @FXML
    void OnSaveMedicine(ActionEvent event) throws IOException { 
        
     ConsultMedi res = new ConsultMedi();
        
     LocalDate myDate = this.myDate.getValue();
      
      
      String VencimientoMedi = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    
            
      Medi us = new Medi(idUser,nameMedi,FormaMedi,Cantidad,MedidadCantidad,NumeroPastillas,PosImageSrc,Hora,VencimientoMedi);
      
      boolean ans = res.RegisterMedi(us);
      
      if(ans == true){
          
          String id = idUser;
          String name = nameUser.getText();
        
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
          alert.setHeaderText(null);
          alert.setTitle("Información");
          alert.setContentText("Se ha añadido correctamente");
          alert.showAndWait();
          
          this.myDate.getScene().getWindow().hide();
          
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent)loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(name,id);     
                Scene scene = new Scene(root);
                Stage stage = new Stage();         
                stage.setScene(scene);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
        

          
          
          
      }else if(ans == false){
          
          Alert alert = new Alert(Alert.AlertType.ERROR);
          alert.setHeaderText(null);
          alert.setTitle("Error");
          alert.setContentText("Houston tenemos un problema");
          alert.showAndWait();
   
      }
          
    

    }

    public Medi getPersona() {
        return persona;
    }
    
    
    
}
