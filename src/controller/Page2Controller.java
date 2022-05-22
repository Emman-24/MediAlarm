
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import model.ConsultNews;
import model.News;


public class Page2Controller implements Initializable {

     @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    
    private List<News> posts;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       ConsultNews ls = new ConsultNews();
       List<News> user = ls.searchNews("3");
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
    
}
