/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private AnchorPane menuPane;

      @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Button signUpBtn;

    @FXML
    private PasswordField passwordtxtfield;

    @FXML
    private Button exitLoginBtn;

    @FXML
    private TextField usernametxtfield;

    @FXML
    private Button signInBtn;

    @FXML
    void signIn(ActionEvent event) throws IOException, SQLException { 
        /*Parent login = (AnchorPane)FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        Scene sceneLogin = new Scene(login, 600, 450);
        Stage loginStage = (Stage) menuPane.getScene().getWindow();
        loginStage.setScene(sceneLogin);*/
        
        loginClass.insert(usernametxtfield.getText(),passwordtxtfield.getText());
    }
       @FXML
    void forgot(ActionEvent event) {

    }
        @FXML
    void exitLogin(ActionEvent event) {
            
    }
    
    @FXML
    void signUp(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
