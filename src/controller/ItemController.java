
package controller;

import java.io.ByteArrayInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Music;


public class ItemController implements Initializable {
 
     @FXML
    private Label SongLabel;

    @FXML
    private Label albumLabel;

    @FXML
    private ImageView img;

    
    private Music music;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        
    }    

   public void setData(Music music) {
        this.music = music;
        SongLabel.setText(music.getNameSong());
        albumLabel.setText(music.getNameArtist());   
        Image image = new Image(new ByteArrayInputStream(music.getImgSrc()));
        img.setImage(image);
    }
    
}
