
package controller;

import java.io.ByteArrayInputStream;
import java.io.File;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.ConsultMedi;
import model.ConsultMusic;
import model.Medi;
import model.Music;


public class MusicController implements Initializable {
    @FXML
    private Label IdUser;
    @FXML
    private Label NameUser;  
    @FXML
    private Button NextButton;
    @FXML
    private Button PauseButton;
    @FXML
    private Button PreviousButton;
    @FXML
    private ImageView SongCover; 
     @FXML
    private ScrollPane scroll;   
    @FXML
    private GridPane grid;
    @FXML
    private ProgressBar SongProgressBar;
    @FXML
    private Button playButton; 
    @FXML
    private Label songName; 
   @FXML
    private Label artistName;
   @FXML
    private Button ReturnButton;
  
    private List<Medi> postsU;
   private File directory;
   private File[] files;
   private ArrayList<File> songs;
   private int songNumber;
   private Timer timer;
   private TimerTask task;
   private boolean running;
   private Media media;
   private MediaPlayer mediaPlayer;
   private Image image;
   private List<Music> posts;
   private List<Music> musics = new ArrayList<>();

    
 

    @FXML
    void nextMedia(ActionEvent event) {
        ConsultMusic ls = new ConsultMusic();
        
        if(songNumber < songs.size() -1 ){
            
            songNumber++;
            
            mediaPlayer.stop();
            
            if(running){
             cancelTimer();
            }
            
            
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        
        String oracion = songs.get(songNumber).getName();
        String palabra = ".mp3";
        
        songName.setText(palabraEliminar(oracion, palabra));
        List<Music> art = ls.searchArtist(palabraEliminar(oracion, palabra));
            
             for (Music cadena : art) {
                Image image = new Image(new ByteArrayInputStream(cadena.getImgSrc()));
                SongCover.setImage(image);
                artistName.setText(cadena.getNameArtist());           
              }
            
        
        
           playMedia();
        }  
        else{
        
        songNumber = 0;
            
        mediaPlayer.stop();
        
        if(running){
             cancelTimer();
            }
            
            
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        
       String oracion = songs.get(songNumber).getName();
        String palabra = ".mp3";
        
        songName.setText(palabraEliminar(oracion, palabra));
        List<Music> art = ls.searchArtist(palabraEliminar(oracion, palabra));
            
             for (Music cadena : art) {
                Image image = new Image(new ByteArrayInputStream(cadena.getImgSrc()));
                SongCover.setImage(image);
                artistName.setText(cadena.getNameArtist());           
              }
            
        
         playMedia();
            
        }
    }

    @FXML
    void pauseMedia() {
        cancelTimer();
        mediaPlayer.pause();
    }
    
     public static String  palabraEliminar(String oracion,String palabra) {
            if(oracion.contains(palabra))
                return oracion.replaceAll(palabra, "");
            return oracion;
}

    @FXML
    void playMedia() {
        beginTimer();
        mediaPlayer.play();
    }

    @FXML
    void previousMedia(ActionEvent event) {
        ConsultMusic ls = new ConsultMusic();
        
        if(songNumber > 0 ){
            
            songNumber--;
            
            mediaPlayer.stop();
            
            if(running){
             cancelTimer();
            }
            
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        
        
        String oracion = songs.get(songNumber).getName();
        String palabra = ".mp3";
        
        songName.setText(palabraEliminar(oracion, palabra));
        List<Music> art = ls.searchArtist(palabraEliminar(oracion, palabra));
            
             for (Music cadena : art) {
                Image image = new Image(new ByteArrayInputStream(cadena.getImgSrc()));
                SongCover.setImage(image);
                artistName.setText(cadena.getNameArtist());           
              }
            
        
           playMedia();
        }
        
        else{
        
        songNumber = songs.size()-1;
            
        mediaPlayer.stop();
        
        if(running){
             cancelTimer();
            }
            
            
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        
        
        String oracion = songs.get(songNumber).getName();
        String palabra = ".mp3";
        
        songName.setText(palabraEliminar(oracion, palabra));
        List<Music> art = ls.searchArtist(palabraEliminar(oracion, palabra));
            
             for (Music cadena : art) {
                Image image = new Image(new ByteArrayInputStream(cadena.getImgSrc()));
                SongCover.setImage(image);
                artistName.setText(cadena.getNameArtist());           
              }
            
        
        
         playMedia();
            
        }
        
    }
    
    public void beginTimer(){
        
        timer = new Timer();
        
        task = new TimerTask(){
            @Override
            public void run() {
                running = true;
                double current =  mediaPlayer.getCurrentTime().toSeconds();
                double end = media.getDuration().toSeconds();
                
                SongProgressBar.setProgress(current/end);
                
                if(current/end == 1 ){
                
                       cancelTimer();
                
                }
                
            }
        
        };
        
        timer.scheduleAtFixedRate(task,0, 1000);
        
    }

    public void cancelTimer(){
        
        running = false;
        
        timer.cancel();
    }


   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ConsultMusic ls = new ConsultMusic();
        List<Music> user = ls.searchMusic();
        posts = new ArrayList<>(user);
        
        
        int column = 0;
        int row = 1;
        
        try {
            
        for (int i = 0; i < posts.size(); i++) {
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/view/Item.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            ItemController itemController = fxmlLoader.getController();
            itemController.setData(posts.get(i));
            
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
            
        
    
        songs = new ArrayList<File>();
        
        directory = new File("src/music/");
        
        files = directory.listFiles();
        
        if(files != null){
        
            for(File file : files){
                songs.add(file);
            }
        }
        
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        
       String oracion = songs.get(songNumber).getName();
        String palabra = ".mp3";
        
        songName.setText(palabraEliminar(oracion, palabra));
        List<Music> art = ls.searchArtist(palabraEliminar(oracion, palabra));
            
             for (Music cadena : art) {
                Image image = new Image(new ByteArrayInputStream(cadena.getImgSrc()));
                SongCover.setImage(image);
                artistName.setText(cadena.getNameArtist());           
              }
            
        
        
        SongProgressBar.setStyle("-fx-accent:#FC2A52;");
        
        
        
        
         ConsultMedi medi = new ConsultMedi();
       
        IdUser.setText(IdUser.getText() + MenuController.getMyVariable());
        
        String id = IdUser.getText();
        
         List<Medi> userU = medi.searchMedicine(id);
           
         postsU = new ArrayList<>(userU);
        
         Timer timer = new Timer();
         
         TimerTask tarea = new TimerTask() {
                    @Override
                    public void run() {
                        
                         LocalTime em =  LocalTime.now();
                         DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
                         
                         for (Medi post : postsU) {
                             
                             if(post.getHora().equals(em.format(f))){
                                 
                                 Platform.runLater(()->  {
                                     
                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                   stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                                   alert.setGraphic(new ImageView(this.getClass().getResource(post.getPostImageSrc()).toString()));
                                   alert.setTitle("MediAlarm");
                                   alert.setHeaderText("Hola "+NameUser.getText());
                                   alert.setContentText("Es hora de tu medicamento: "+post.getNombreMedicamento()+"\n"+"\n"+   
                                                        "Recuerda :"+post.getNumeroPastillas()+" "+ post.getFormaMedi() );
                                  

                                   alert.showAndWait();
                                 });
                     
                             }else{
                                 System.out.println("Siga esperando : " +em.format(f));
                             }
                             
     
                         }
                         
                         
                    }
                  
             };
         
             timer.schedule(tarea,0,1000);
             
             ReturnButton.setOnAction((event) -> {
                 if(this.timer == null){
                     
                 }else{
                   
                 cancelTimer();
                mediaPlayer.pause();
                 
                 }
                 
               
                 
                tarea.cancel();
                timer.cancel(); 
                
                String fullName = NameUser.getText();
                String IdUser = this.IdUser.getText();

                NameUser.getScene().getWindow().hide();
        
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
         
        
      
    }    

    void onGetData(String fullName, String IdUser) {
        NameUser.setText(fullName);
        this.IdUser.setText(IdUser);
    }
    
 
    
    }
    

