
package controller;

import java.awt.Desktop;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.News;


public class Item2Controller implements Initializable {

    @FXML
    private Hyperlink NameHiper;

    @FXML
    private ImageView img;
    
    private News news;
    
//    @FXML
 //   void openLink(ActionEvent event) throws URISyntaxException, IOException {
 //       Desktop.getDesktop().browse(new URI("http://google.com.co"));
 //   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
     public void setData(News news) {
        this.news = news;
        NameHiper.setText(news.getNameTitular()); 
        Image image = new Image(new ByteArrayInputStream(news.getImgSrc()));
        img.setImage(image);
        NameHiper.setOnAction(e->{
            try {
                Desktop.getDesktop().browse(new URI(news.getLink()));
            } catch (IOException ex) {
                Logger.getLogger(Item2Controller.class.getName()).log(Level.SEVERE, null, ex);
            } catch (URISyntaxException ex) {
                Logger.getLogger(Item2Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        });
    }
    
}
