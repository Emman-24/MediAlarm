
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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.ConsultMedi;
import model.ConsultNews;
import model.Medi;
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
    
    private List<Medi> postsU;
    
    @FXML
    private Button ReturnButton;
   
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
       
       ConsultMedi medi = new ConsultMedi();
       
        idUser.setText(idUser.getText() + MenuController.getMyVariable());
       
       String id = idUser.getText();
       
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
                                   alert.setHeaderText("Hola "+nameUser.getText());
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
                 tarea.cancel();
                timer.cancel();
                 
                  String fullName = nameUser.getText();
                  String IdUser = idUser.getText();
            
                nameUser.getScene().getWindow().hide();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
                    Parent root = null;           
           try {
               root = (Parent) loader.load();
           } catch (IOException ex) {
               Logger.getLogger(NewsController.class.getName()).log(Level.SEVERE, null, ex);
           }
                    MenuController secController = loader.getController();
                    secController.onGetData(fullName,IdUser);     
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("MediAlarm");
                    stage.getIcons().add(new Image("/image/clockW.png"));
                    stage.show();
                    
                     stage.setOnCloseRequest((e) -> {
                    Platform.exit();
                    System.exit(0);
                });
             });
       
            
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
    

    void onGetData(String fullName, String IdUser) {
        nameUser.setText(fullName);
        idUser.setText(IdUser);
    }
    
   
    
    
}
