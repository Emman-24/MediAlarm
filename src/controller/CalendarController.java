
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
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

   private List<Medi> posts;
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        ConsultMedi medi = new ConsultMedi();
        
        IdUser.setText(IdUser.getText() + MenuController.getMyVariable());
        
        String id = IdUser.getText();
        
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
      
                /*
                for (Medi entero : posts) {                      
                    System.out.println(entero.getHora());           
                }               
                */
                
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
    
     public void onGetData(String fullName,String id){
       
         this.NameUser.setText(fullName);
         this.IdUser.setText(id);

    }
     
         @FXML
    void OnAddMedicineFirstButton(ActionEvent event) throws IOException {
        String id = IdUser.getText();
              
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form1.fxml"));
                Parent root = (Parent)loader.load();           
                Form1Controller secController = loader.getController();
                secController.onGetData(id);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.show();
    }

     
    @FXML
    void OnClickAddMedicineButton(ActionEvent event) throws IOException {

               String id = IdUser.getText();
                    
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form1.fxml"));
                Parent root = (Parent)loader.load();           
                Form1Controller secController = loader.getController();
                secController.onGetData(id);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.show();
               
    
              
        
    }
    
       @FXML
    void onBackButton(ActionEvent event) throws IOException {
        
                String fullName =NameUser.getText() ;
                String IdUser = this.IdUser.getText();
                
                circle.getScene().getWindow().hide();           
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
                Parent root = (Parent) loader.load();           
                MenuController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("MediAlarm");
                stage.show();
    }
    
}
