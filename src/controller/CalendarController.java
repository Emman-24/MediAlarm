
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import model.Medi;


public class CalendarController implements Initializable {

    @FXML
    private Button AddMedicineFirst;
    
    @FXML
    public Label NameUser;

    @FXML
    private GridPane postGrid;

    @FXML
    public Label IdUser;
    
    @FXML
    private Button addMedicineButton;
    
    @FXML
    private Circle circle;
           
    @FXML
    private Label text1;
   
    @FXML
    private ScrollPane Scroll;

    private List<Medi> posts;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        posts = new ArrayList<>(data());

        int columns = 0;
        int rows = 0;

        if(posts.size() < 1 ){
            
            Scroll.setVisible(false);
            addMedicineButton.setVisible(false);     
        
            }else{
                circle.setVisible(false);
                AddMedicineFirst.setVisible(false);
                text1.setVisible(false);
                
                try {

                    for (int i = 0; i<posts.size(); i++){

                         if(posts.size() == 1){ 
                                Scroll.setPrefSize(535, 188);

                            }else if(posts.size() == 2){ 
                                Scroll.setPrefSize(535, 364);
                            }   

                                    FXMLLoader fxmlLoader = new FXMLLoader();
                                    fxmlLoader.setLocation(getClass().getResource("/view/Medicines.fxml"));

                                    VBox postBox = fxmlLoader.load();

                                    MedicinesController medicinesController = fxmlLoader.getController();
                                    medicinesController.setData(posts.get(i));

                                    if (rows == 2){
                                        columns = 0;
                                        rows++;
                                    }       

                                    rows = rows + 1;
                                    postGrid.add(postBox,columns,rows++);
                                    GridPane.setMargin(postBox,new Insets(26));            
                        }

                    }catch (IOException e) {

                }
                
        }
        
    }    
    
    private List<Medi> data(){
        
        List<Medi> ls = new ArrayList<>();
      /*
        Medi post = new Medi();
       post.setCantidad("100");
        post.setMedidaCantida("mcg");
        post.setNombreMedicamento("Levothiroxine");
        post.setPostImageSrc("/image/pastille.png");
        post.setNumeroPastillas("1");
        post.setHora("9:00 pm");
        ls.add(post);     
        
        post = new Medi();
       post.setCantidad("100");
        post.setMedidaCantida("mcg");
        post.setNombreMedicamento("Levothiroxine");
        post.setPostImageSrc("/image/pastille.png");
        post.setNumeroPastillas("1");
        post.setHora("7:00 pm");
        ls.add(post);  
      */
        return ls;


        
    }
    
     public void onGetData(String fullName,String id){
       
         this.NameUser.setText(fullName);
       //  this.IdUser.setText(id);

    }
     
     
     
       @FXML
    void OnClickAddMedicineButton(MouseEvent event) {
            System.out.println("le diste al boton de agregar un medicamento");
    }
    
}
