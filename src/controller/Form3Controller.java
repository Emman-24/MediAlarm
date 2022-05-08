
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Form3Controller implements Initializable {

    private static String myVariable;
  
    @FXML
    private Label IdUser;

    @FXML
    private Label ImgSource;

    @FXML
    private Label NameMedi;
    
    @FXML
    private Label Method;
    
    @FXML
    private ListView<String> MyListView;

    @FXML
    private TextField NumeroCantidad;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Method.setText(Method.getText() + Form2Controller.getMyVariable());
    
        String method = Method.getText();
        
        if(method.equals("Pastilla")){
            
            MyListView.setPrefWidth(220);
            MyListView.setPrefHeight(55);
            MyListView.setLayoutX(175);
            MyListView.setLayoutY(189);
       
            ObservableList <String > items = FXCollections.observableArrayList("g","IU","mcg","mEq","mg");
            MyListView.setItems(items);
             
        }else if(method.equals("Solución")){
            
            MyListView.setPrefWidth(419);
            MyListView.setPrefHeight(55);
            MyListView.setLayoutX(81);
            MyListView.setLayoutY(189);
            
         ObservableList <String > items = FXCollections.observableArrayList("g","IU","mcg","mcg/ml","mEq","mg","mg/ml","mL","%");
             MyListView.setItems(items);
             
        }else if(method.equals("Inyección")){
            
            MyListView.setPrefWidth(393);
            MyListView.setPrefHeight(55);
            MyListView.setLayoutX(95);
            MyListView.setLayoutY(189);
            
          ObservableList <String > items = FXCollections.observableArrayList("IU","mcg","mcg/ml","mEq","mg","mg/ml","mL","%");
             MyListView.setItems(items);
             
        }else if(method.equals("Gotas")){
            
            MyListView.setPrefWidth(313);
            MyListView.setPrefHeight(55);
            MyListView.setLayoutX(127);
            MyListView.setLayoutY(189);
            
          ObservableList <String > items = FXCollections.observableArrayList("IU","mcg","mcg/ml","mEq","mg/ml","%");
             MyListView.setItems(items);
             
        }else if(method.equals("Inhalador")){
            
            MyListView.setPrefWidth(169);
            MyListView.setPrefHeight(55);
            MyListView.setLayoutX(199);
            MyListView.setLayoutY(189);
            
          ObservableList <String > items = FXCollections.observableArrayList("mcg","mg","mg/ml");
             MyListView.setItems(items);
             
        }

    }

    @FXML
    void OnNextForm(ActionEvent event) throws IOException {
        
        String numCan = NumeroCantidad.getText();
        String selected = MyListView.getSelectionModel().getSelectedItem();
        String id = IdUser.getText();
        String nameMedi = NameMedi.getText();
        String imgSource = ImgSource.getText();
        String method = Method.getText();
     
       setMyVariable(method);
       MyListView.getScene().getWindow().hide();
      
             
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Form4.fxml"));
                Parent root = (Parent) loader.load();           
                Form4Controller secController = loader.getController();
                secController.onGetData(id,nameMedi,imgSource,numCan,selected,method);     
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("MediAlarm");
                stage.show();
        
        
    }

    void onGetData(String id, String nameMedi, String imgSource, String selected) {
            IdUser.setText(id);
            NameMedi.setText(nameMedi);
            ImgSource.setText(imgSource);
            Method.setText(selected);
        
    }
    
     public static String getMyVariable() {
        return myVariable;
    }

    public static void setMyVariable(String myVariable) {
        Form3Controller.myVariable = myVariable;
    }
    
    
}
