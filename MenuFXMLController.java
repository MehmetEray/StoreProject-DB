/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class MenuFXMLController implements Initializable {

   
    @FXML
    private Button headBtn;

    @FXML
    private Button compBtn;

    @FXML
    private Button booksBtn;

    @FXML
    private Button phonesBtn;

    @FXML
    void headShow(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("headphonesFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    void compShow(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("computerFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    void phonesShow(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("phoneFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }
      @FXML
    void booksShow(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bookFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
