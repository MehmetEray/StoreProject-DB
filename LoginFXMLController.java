/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
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
    generalFunc gf = new generalFunc();
    String type1 = "user";
    String type2 = "admin";
            
    @FXML
    public void signIn(ActionEvent event) throws IOException, SQLException { 
        /*String username = usernametxtfield.getText();
        String password = passwordtxtfield.getText();
        String type ="user";
        String sql = "select * from login where username = username password = password type = type";
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        pst = connection.prepareStatement(sql);
        pst.setString(1,usernametxtfield.getText());
        pst.setString(2,passwordtxtfield.getText());
        pst.setString(3,type);
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
                System.out.println("Successfull Login");
                gf.openStageFunc("adminPanelFXML.fxml", signInBtn);
            } else {
                gf.openStageFunc("menuFXML.fxml", signInBtn);
                System.err.println("Wrong Login");
            }
         */   
           gf.openStageFunc("adminPanelFXML.fxml", signInBtn);
              //  System.out.println("Matched");
             //gf.openStageFunc("menuFXML.fxml", signInBtn);
            //System.out.println("Didn't matched");
        //gf.loginUser(usernametxtfield.getText(),passwordtxtfield.getText());
        //gf.loginAdmin(usernametxtfield.getText(),passwordtxtfield.getText());
    }
    
    
    

       
    @FXML
    void forgot(ActionEvent event) {}
    @FXML
    void exitLogin(ActionEvent event) {
            Platform.exit();
            System.out.println("EXIT");
    }
    @FXML
    void signUp(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "insert into login values(?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,usernameInsert.getText());
        pst.setString(2,passwordInsert.getText());
        pst.setString(3,"user");
        JOptionPane.showMessageDialog(null, "You have registered!");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) { }    
    
}
