
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ConsultNews;
import model.News;


public class NewsController implements Initializable {

    @FXML
    private Label idUser;

    @FXML
    private Label nameUser;
    
    @FXML
    private AnchorPane ap;

    @FXML
    private BorderPane bp;
    
     @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
   
    private List<News> posts;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       ConsultNews ls = new ConsultNews();
       List<News> user = ls.searchNews("1");
       posts = new ArrayList<>(user);
        
       int column = 0;
       int row = 1;
       
       try {
       
       for (int i = 0; i < posts.size(); i++) {
           
           FXMLLoader fxmlLoader = new FXMLLoader();
           fxmlLoader.setLocation(getClass().getResource("/view/Item2.fxml"));
           AnchorPane anchorPane = fxmlLoader.load();
           
           Item2Controller item2Cotroller = fxmlLoader.getController();
           item2Cotroller.setData(posts.get(i));
           
            if(column == 3){
                column = 0;
                row++;
            
            }
            
            grid.add(anchorPane, column++, row);
            
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
           
            GridPane.setMargin(anchorPane,new Insets(10));
           
       }
       } catch (IOException ex) {
                Logger.getLogger(MusicController.class.getName()).log(Level.SEVERE, null, ex);
                
            }
            
    }    
    
   @FXML
    void salud(MouseEvent event) {
        loadPage("Page4");
    }
    
    @FXML
    void PromocionSalud(MouseEvent event){
        
        loadPage("Page3");
    }
    
    @FXML
    void SaludEmocional(MouseEvent event){
        
        loadPage("Page2");
    }
    
    @FXML
    void TecnologiaSalud(MouseEvent event){
    
        loadPage("Page1");
    }
    
     private void loadPage(String page){
        
        Parent root = null;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/view/"+page+".fxml"));
            
        } catch (IOException ex) {
            
            Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        bp.setCenter(root);
    
    }
    
     @FXML
    void onReturnMenu(ActionEvent event) throws IOException {
            String fullName = nameUser.getText();
            String IdUser = idUser.getText();
            
            nameUser.getScene().getWindow().hide();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
                Parent root = (Parent) loader.load();           
                MenuController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
    }

    void onGetData(String fullName, String IdUser) {
        nameUser.setText(fullName);
        idUser.setText(IdUser);
    }
    
   
    
    
}
