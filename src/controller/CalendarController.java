
package controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ConsultMedi;
import model.Medi;


public class CalendarController implements Initializable {

    @FXML
    private Button AddMedicineFirst;

    @FXML
    private Label IdUser;

    @FXML
    private Label NameUser;

    @FXML
    private ScrollPane Scroll;

    @FXML
    private Button addMedicineButton;

    @FXML
    private Circle circle;

    @FXML
    private GridPane postGrid;

    @FXML
    private Label text1;
    
    @FXML
    private Button BackButton;

    private List<Medi> posts;
       
    private Stage stage;
     private Scene scene;
    private Parent root;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        ConsultMedi medi = new ConsultMedi();
              
        IdUser.setText(IdUser.getText() + MenuController.getMyVariable());
        NameUser.setText(NameUser.getText() + MenuController.getMyVarible2());
        
        String id = IdUser.getText();
        String name = NameUser.getText();
        
   
     
        List<Medi> user = medi.searchMedicine(id);
          
             
        posts = new ArrayList<>(user);
       
      
        
        int columns = 0;
        int rows = 0;    

        if(user.size() < 1 ){
            
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
                                    medicinesController.setData(posts.get(i),name);

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
        
      
        
        
        BackButton.setOnAction((event) -> {
            
                  
             
              String fullName = NameUser.getText();
              String IdUser = this.IdUser.getText();

              BackButton.getScene().getWindow().hide();
            
              
               FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
                      Parent root = null;    

              try {
                root = (Parent) loader.load();
            } catch (IOException ex) {
                Logger.getLogger(MusicController.class.getName()).log(Level.SEVERE, null, ex);
            }

               MenuController secController = loader.getController();
                      secController.onGetData(fullName,IdUser);     
                      Stage stage = new Stage();
                      stage.setScene(new Scene(root));
                      stage.setTitle("MediAlarm");
                      stage.getIcons().add(new Image("/image/clockW.png"));
                      stage.show();
            
            
        });
        
        addMedicineButton.setOnAction((event) -> {
            
           
            
               
               IdUser.getScene().getWindow().hide();
                    
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form1.fxml"));
                Parent root = null;           
            try {
                root = loader.load();
            } catch (IOException ex) {
                Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
            }
                Form1Controller secController = loader.getController();
                secController.onGetData(id,name);     
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);              
                stage.setScene(scene);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.showAndWait();    
            
            
            
        });
        
        AddMedicineFirst.setOnAction((event) -> {
            
            
             IdUser.getScene().getWindow().hide();
                    
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form1.fxml"));
                Parent root = null;           
            try {
                root = (Parent)loader.load();
            } catch (IOException ex) {
                Logger.getLogger(CalendarController.class.getName()).log(Level.SEVERE, null, ex);
            }
                Form1Controller secController = loader.getController();
                secController.onGetData(id,name);     
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);              
                stage.setScene(scene);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.showAndWait();
            
        });
        
        
        
    }    
    
     public void onGetData(String fullName,String id){
       
         this.NameUser.setText(fullName);
         this.IdUser.setText(id);

    }
     
  

     
    
}
