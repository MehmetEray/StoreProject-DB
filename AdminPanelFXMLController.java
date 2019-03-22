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
    @FXML private Button adminExitBtn;
    @FXML private Button adminBackBtn;
    @FXML private Button adminDeleteBookBtn;
    @FXML private Button adminInsertCompBtn;
    @FXML private Button adminInsertHeadphoneBtn;
    @FXML private Button adminInsertPhoneBtn;
    @FXML private Button adminDeleteCompBtn;
    @FXML private Button adminDeleteHeadphoneBtn;
    @FXML private Button adminDeletePhoneBtn;
    @FXML private Button adminInsertBookBtn;
    @FXML private Button adminLogOut;
    generalFunc gf = new generalFunc();
@FXML
    void adminInsertBook(ActionEvent event) throws IOException {
        gf.openStageFunc("bookFuncFXML.fxml", adminInsertBookBtn);
    }

    @FXML
    void adminDeleteBook(ActionEvent event) throws IOException {
        gf.openStageFunc("bookFunc2FXML.fxml", adminDeleteBookBtn);
    }

    @FXML
    void adminInsertPhone(ActionEvent event) throws IOException {
        gf.openStageFunc("phoneFuncFXML.fxml", adminInsertPhoneBtn);
    }

    @FXML
    void adminDeletePhone(ActionEvent event) throws IOException {
        gf.openStageFunc("phoneFunc2FXML.fxml", adminDeletePhoneBtn);
    }

    @FXML
    void adminInsertComp(ActionEvent event) throws IOException {
        gf.openStageFunc("comFuncFXML.fxml", adminInsertCompBtn);
    }

    @FXML
    void adminDeleteComp(ActionEvent event) throws IOException {
        gf.openStageFunc("comFunc2FXML.fxml", adminDeleteCompBtn);
    }

    @FXML
    void adminDeleteHeadphone(ActionEvent event) throws IOException {
        gf.openStageFunc("headphoneFunc2FXML.fxml", adminDeleteHeadphoneBtn);
    }
     @FXML
    void adminInsertHeadphone(ActionEvent event) throws IOException {
        gf.openStageFunc("headphoneFuncFXML.fxml", adminInsertHeadphoneBtn);
    }
    @FXML
    void adminLogOut(ActionEvent event) throws IOException {
        gf.openStageFunc("loginFXML.fxml", adminLogOut);
    }
     @FXML
    void adminExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void adminBack(ActionEvent event) throws IOException {
        gf.openStageFunc("loginFXML.fxml", adminBackBtn);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    
    
}
