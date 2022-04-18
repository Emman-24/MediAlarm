/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package medialarm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;



/**
 *
 * @author emman
 */
public class MediAlarm extends Application {
    
    public Label lab1;

   
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));  
        Scene scene = new Scene(root,860,560);
         stage.setTitle("MediAlarm");
         stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}
