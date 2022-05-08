package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    void onGetData(String idUser, String nameMedi, String imgSource, String numCan, String MedidCant, String numPills, String hour,String FormaMedi) {
        
        this.idUser = idUser;
        this.nameMedi = nameMedi;
        this.FormaMedi = FormaMedi;
        Cantidad = numCan;
        MedidadCantidad = MedidCant;
        NumeroPastillas = numPills;
        PosImageSrc = imgSource;
        Hora = hour;
       
    }
    
      @FXML
    void OnSaveMedicine(ActionEvent event) {
        
      LocalDate myDate = this.myDate.getValue();
      String VencimientoMedi = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      
      ConsultMedi res = new ConsultMedi();
      
      Medi us = new Medi(idUser,nameMedi,FormaMedi,Cantidad,MedidadCantidad,NumeroPastillas,PosImageSrc,Hora,VencimientoMedi);
      
      boolean ans = res.RegisterMedi(us);
      
      if(ans == true){
      
         this.myDate.getScene().getWindow().hide();           

          System.out.println("Una victoria muy importante");
          
          
      }else if(ans == false){
          
          
          
          System.out.println("hay que mirar con cuidado");
          
          
          
      }
          
    }

    
}
