
package controller;

import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
       
    }    
    
      @FXML
    void OnMedicineClick(MouseEvent event) {
        //  System.out.println("me diste un click en : "+IdMedicine.getText() );
        
         Alert alert = new Alert(AlertType.WARNING);  
         alert.setTitle("MediAlarm");
         alert.setHeaderText("Eliminar el medicamento : "+NombreMedicamento.getText());
         alert.setContentText(" ¿ Deseas guardar el medicamento en tu historial ?");
         
         ButtonType buttonTypeOne = new ButtonType("Guardar");
         ButtonType buttonTypeTwo = new ButtonType("No Guardar");
         ButtonType buttonTypeCancel = new ButtonType("Cancelar",ButtonData.CANCEL_CLOSE);
         
         alert.getButtonTypes().setAll(buttonTypeOne,buttonTypeTwo,buttonTypeCancel);
         
         Optional<ButtonType> result = alert.showAndWait();

    }
}
