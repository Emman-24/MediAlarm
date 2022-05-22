
package controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.ConsultMedi;
import model.Medi;


public class MedicinesController implements Initializable {

    
    @FXML
    private Label Cantidad;

    @FXML
    private Label MedidaCantida;

    @FXML
    private Label NombreMedicamento;

    @FXML
    private Label NumeroPastillas;

    @FXML
    private Label IdMedicine;
    
    @FXML
    private ImageView PostImageSrc;
    
    @FXML
    private Label Hora;
    
    @FXML
    private Label FormaMedi;



    public void setData(Medi medi){
        
    Image image = new Image(getClass().getResourceAsStream(medi.getPostImageSrc()));
    PostImageSrc.setImage(image);
    
    Cantidad.setText(medi.getCantidad());
    MedidaCantida.setText(medi.getMedidaCantida());
    NombreMedicamento.setText(medi.getNombreMedicamento());
    NumeroPastillas.setText(medi.getNumeroPastillas());
    Hora.setText(medi.getHora());
    FormaMedi.setText(medi.getFormaMedi());
    IdMedicine.setText(Integer.toString(medi.getIdMedi()));
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       PostImageSrc.setLayoutX(42);
       PostImageSrc.setLayoutY(20);
    }   
    
    
      @FXML
    void OnMedicineClick(MouseEvent event) {    
        
         Alert alert = new Alert(AlertType.WARNING);  
         alert.setTitle("MediAlarm");
         alert.setHeaderText("Eliminar el medicamento : "+NombreMedicamento.getText());
         alert.setContentText(" ¿ Deseas guardar el medicamento en tu historial ?");
         
         ButtonType buttonTypeOne = new ButtonType("Guardar");
         ButtonType buttonTypeTwo = new ButtonType("No Guardar");
         ButtonType buttonTypeCancel = new ButtonType("Cancelar",ButtonData.CANCEL_CLOSE);
         
         alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeTwo,buttonTypeCancel);
         
         Optional<ButtonType> result = alert.showAndWait();
         
         if(result.get() == buttonTypeOne){
             ConsultMedi us = new ConsultMedi();
             
             boolean can = us.UpdateMedicine(IdMedicine.getText());
             
             if(can == true){
                 System.out.println("Medicamento guardado");
                
             }
         
         }else if(result.get() == buttonTypeTwo){
             ConsultMedi us = new ConsultMedi();
             
             boolean can = us.DeleteMedicine(IdMedicine.getText());
             
             if(can == true){
                 System.out.println("El medicamento ha sido eliminado");
             }
         
         }

    }
}
