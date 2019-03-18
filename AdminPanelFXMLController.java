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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AdminPanelFXMLController implements Initializable {

    @FXML
    private Button adminDeleteBookBtn;

    @FXML
    private Button adminInsertCompBtn;

    @FXML
    private Button adminInsertHeadphoneBtn;

    @FXML
    private Button adminInsertPhoneBtn;

    @FXML
    private Button adminDeleteCompBtn;

    @FXML
    private Button adminDeleteHeadphoneBtn;

    @FXML
    private Button adminDeletePhoneBtn;

    @FXML
    private Button adminInsertBookBtn;
    
    @FXML
    void adminInsertBook(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("insertBookFXML.fxml"));
        stage.setScene(new Scene(root,800,850));
        stage.show();
        adminInsertBookBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminDeleteBook(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,800,850));
        stage.show();
        adminDeleteBookBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminInsertPhone(ActionEvent event) {
        
    }

    @FXML
    void adminDeletePhone(ActionEvent event) {
        
    }

    @FXML
    void adminInsertComp(ActionEvent event) {
        
    }

    @FXML
    void adminDeleteComp(ActionEvent event) {
        
    }

    @FXML
    void adminDeleteHeadphone(ActionEvent event) {
        
    }
     @FXML
    void adminInsertHeadphone(ActionEvent event) {
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
