/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AdminPanelFXMLController implements Initializable {
     @FXML
    private Button adminExitBtn;
      @FXML
    private Button adminBackBtn;
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
    private Button adminLogOut;
    @FXML
    void adminInsertBook(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bookFuncFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertBookBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminDeleteBook(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("bookFunc2FXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminDeleteBookBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminInsertPhone(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("phoneFuncFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminDeletePhone(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("phoneFunc2FXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminInsertComp(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("comFuncFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminDeleteComp(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("comFunc2FXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminDeleteHeadphone(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("headphoneFunc2FXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }
     @FXML
    void adminInsertHeadphone(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("headphoneFuncFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminInsertPhoneBtn.getScene().getWindow().hide();
    }
    @FXML
    void adminLogOut(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminLogOut.getScene().getWindow().hide();
    }
     @FXML
    void adminExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void adminBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminLogOut.getScene().getWindow().hide();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
