
package controller;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private ImageView PostImageSrc;
    
    @FXML
    private Label Hora;



    public void setData(Medi medi){
        
    Image image = new Image(getClass().getResourceAsStream(medi.getPostImageSrc()));
    PostImageSrc.setImage(image);
    
    Cantidad.setText(medi.getCantidad());
    MedidaCantida.setText(medi.getMedidaCantida());
    NombreMedicamento.setText(medi.getNombreMedicamento());
    NumeroPastillas.setText(medi.getNumeroPastillas());
    Hora.setText(medi.getHora());
    
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
