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

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class HeadphonesFXMLController implements Initializable {

        @FXML
    private Button phılıpsHeadBtn;

    @FXML
    private Button huaweiHeadBtn;

    @FXML
    private Button appleHeadBtn;

    @FXML
    private Button exitHead;

    @FXML
    private Button headphoneLogOutBtn;

     @FXML
    private Button headPhoneBackBtn;

    @FXML
    void phılıpsHeadShow(ActionEvent event) {

    }

    @FXML
    void appleHeadShow(ActionEvent event) {

    }

    @FXML
    void huaweiHeadShow(ActionEvent event) {

    }

    @FXML
    void exitHead(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void eadPhoneBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }

    @FXML
    void headPhoneLogOut(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
