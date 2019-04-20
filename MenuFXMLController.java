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
import javafx.scene.Node;
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
public class MenuFXMLController implements Initializable {

    @FXML private Button compBtn;
    @FXML private Button headBtn;
    @FXML private Button booksBtn;
    @FXML private Button phonesBtn;
    @FXML private Button phoneexit;
    @FXML private Button menuBackBtn;
   
    generalFunc gf = new generalFunc();
    @FXML
    void headShow(ActionEvent event) throws IOException {
        gf.openStageFunc("headphonesFXML.fxml", headBtn);
        System.out.println("Kulaklıklara giriş yapıldı");
    }

    @FXML
    void menuBack(ActionEvent event) throws IOException {
        gf.openStageFunc("loginFXML.fxml", menuBackBtn);
    }

    @FXML
    void compShow(ActionEvent event) throws IOException {
        gf.openStageFunc("compFXML.fxml",compBtn);
        System.out.println("Bilgisayarlara giriş yapıldı");
    }

    @FXML
    void phonesShow(ActionEvent event) throws IOException {
        gf.openStageFunc("phoneFXML.fxml",phonesBtn);
        System.out.println("Telefonlara giriş yapıldı");
    }
    @FXML
    void booksShow(ActionEvent event) throws IOException {
        gf.openStageFunc("bookFXML.fxml",booksBtn);
        System.out.println("Kitaplara giriş yapıldı");
    }
    @FXML
    void phoneExit(ActionEvent event) { Platform.exit(); }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    
    
}
