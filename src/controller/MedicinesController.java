
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
    
    @FXML
    private Label nameUser;
    
    
    @FXML
    private Label idUser;



    public void setData(Medi medi,String name){
        
    Image image = new Image(getClass().getResourceAsStream(medi.getPostImageSrc()));
    PostImageSrc.setImage(image);
    
    Cantidad.setText(medi.getCantidad());
    MedidaCantida.setText(medi.getMedidaCantida());
    NombreMedicamento.setText(medi.getNombreMedicamento());
    NumeroPastillas.setText(medi.getNumeroPastillas());
    Hora.setText(medi.getHora());
    FormaMedi.setText(medi.getFormaMedi());
    IdMedicine.setText(Integer.toString(medi.getIdMedi()));
    nameUser.setText(name);
    idUser.setText(medi.getIdUserMedi());
   
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       PostImageSrc.setLayoutX(42);
       PostImageSrc.setLayoutY(20);
    }   
    
    
      @FXML
    void OnMedicineClick(MouseEvent event) throws IOException {    
        
        
         Alert alert = new Alert(AlertType.WARNING); 
         Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
         alert.setTitle("MediAlarm");
         stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));

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
                   
                 String id = idUser.getText();
                 String name = nameUser.getText();
             
                 nameUser.getScene().getWindow().hide();
                 
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent)loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(name,id);     
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
                 
                
                
             }
         
         }else if(result.get() == buttonTypeTwo){
             ConsultMedi us = new ConsultMedi();
             
             boolean can = us.DeleteMedicine(IdMedicine.getText());
             
             if(can == true){
                 
                String id = idUser.getText();
                String name = nameUser.getText();
             
                 nameUser.getScene().getWindow().hide();
                 
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent)loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(name,id);     
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
                 
                 
                 
             }
         
         }

    }
}
