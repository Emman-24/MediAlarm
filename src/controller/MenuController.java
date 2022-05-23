
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.ConsultMedi;
import model.Medi;



public class MenuController implements Initializable {
   
    static String myVariable;
  
    @FXML
    private Label nameUserLabel;
    
    @FXML
    private Label UserId;
    
    @FXML
    private AnchorPane AnchorPane;
    
    
    @FXML
    private Button LogOutButton;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    private List<Medi> posts;
  
    
    @FXML
    void OnLogOutButton(ActionEvent event) throws IOException{
   
    AnchorPane.getScene().getWindow().hide();
        
           Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml")); 
           stage= (Stage)((Node)event.getSource()).getScene().getWindow();
           scene = new Scene(root);     
           Stage stage = new Stage();
           stage.setResizable(false);
           stage.setScene(scene);       
           stage.setTitle("MediAlarm"); 
           stage.getIcons().add(new Image("/image/clockW.png"));
           stage.show();
    
    
    }
    
     @FXML
    void OnCalendarButton(ActionEvent event) throws IOException {

       
                String fullName = nameUserLabel.getText();
                String IdUser = UserId.getText();
                
                AnchorPane.getScene().getWindow().hide();
                
                setMyVariable(IdUser);
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Calendar.fxml"));
                Parent root = (Parent) loader.load();           
                CalendarController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();

    }
    
    @FXML
    void OnMussicButton(ActionEvent event) throws IOException {
        
                String fullName = nameUserLabel.getText();
                String IdUser = UserId.getText();
        
           AnchorPane.getScene().getWindow().hide();
        
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Music.fxml"));
                Parent root = (Parent) loader.load();           
                MusicController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();
    }

    @FXML
    void OnNewsButton(ActionEvent event) throws IOException { 
         String fullName = nameUserLabel.getText();
         String IdUser = UserId.getText();
          
         AnchorPane.getScene().getWindow().hide();
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/News.fxml"));
                Parent root = (Parent) loader.load();           
                NewsController secController = loader.getController();
                secController.onGetData(fullName,IdUser);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.setTitle("MediAlarm");
                stage.getIcons().add(new Image("/image/clockW.png"));
                stage.show();

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ConsultMedi medi = new ConsultMedi();
        
        UserId.setText(UserId.getText() + MainViewController.getMyVariable());        
        
       String id = UserId.getText();
        
        List<Medi> user = medi.searchMedicine(id);
           
        posts = new ArrayList<>(user);
        
         Timer timer = new Timer();
            
             
             TimerTask tarea = new TimerTask() {
                    @Override
                    public void run() {
                        
                         LocalTime em =  LocalTime.now();
                         DateTimeFormatter f = DateTimeFormatter.ofPattern("H:mm:ss");
                         
                         for (Medi post : posts) {
                             
                             if(post.getHora().equals(em.format(f))){
                                 
                                 Platform.runLater(()->  {
                                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                   Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
                                   stage.getIcons().add(new Image(this.getClass().getResource("/image/clockW.png").toString()));
                                   alert.setGraphic(new ImageView(this.getClass().getResource(post.getPostImageSrc()).toString()));
                                   alert.setTitle("MediAlarm");
                                   alert.setHeaderText("Hola "+nameUserLabel.getText());
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
        
    }

    public void onGetData(String fullName,String id){
        
        this.nameUserLabel.setText(fullName);
        this.UserId.setText(id);

    }    
    
     public static String getMyVariable() {
        return myVariable;
    }

    public static void setMyVariable(String myVariable) {
        MenuController.myVariable = myVariable;
    }
    
}
