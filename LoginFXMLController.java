/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFXMLController.connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class LoginFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    @FXML private PasswordField passwordInsert;
    @FXML private TextField usernameInsert; 
    @FXML private AnchorPane menuPane;
    @FXML private Hyperlink forgotPassword;
    @FXML private Button signUpBtn;
    @FXML private PasswordField passwordtxtfield;
    @FXML private Button exitLoginBtn;
    @FXML private TextField usernametxtfield;
    @FXML private Button signInBtn;
    PreparedStatement pst =null;
    ResultSet rs;
    @FXML
    void signIn(ActionEvent event) throws IOException, SQLException { 
        String sql = "select * from login where username = ? and password = ?";
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        pst = connection.prepareStatement(sql);
        pst.setString(1,usernametxtfield.getText());
        pst.setString(2,passwordtxtfield.getText());
        ResultSet rs = pst.executeQuery();
            if(rs.next()){
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("adminPanelFXML.fxml"));
            stage.setScene(new Scene(root,800,800));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            System.out.println("Matched");
            signInBtn.getScene().getWindow().hide();
            
        }else{
            Stage stage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
            stage.setScene(new Scene(root,800,850));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
            System.out.println("Didn't matched");
            signInBtn.getScene().getWindow().hide();
        }
        
    }
        
        //loginpane.setVisible(Boolean.FALSE);
        //btn_login.getScene().getWindow().hide();
       
       @FXML
    void forgot(ActionEvent event) {

    }
        @FXML
    void exitLogin(ActionEvent event) {
            Platform.exit();
    }
    
    @FXML
    void signUp(ActionEvent event) throws SQLException {
         loginClass.insert(usernameInsert.getText(),passwordInsert.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
