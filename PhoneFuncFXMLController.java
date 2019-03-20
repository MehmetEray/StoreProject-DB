/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.BookFuncFXMLController.connection;
import javax.swing.JOptionPane;


public class PhoneFuncFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private Button phoneInserttf;
    @FXML private TextField phoneModeltf;
    @FXML private TextField phoneRamtf;
    @FXML private TextField phoneProcessortf;
    @FXML private TextField phoneCameratf;
    @FXML private TextField phonePricetf;
    @FXML
    private Button adminExitBtn;
    @FXML
    private Button adminBackBtn;
    @FXML
    void phoneInsert(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "insert into phone_Table values(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,phoneModeltf.getText());
        pst.setString(2,phoneRamtf.getText());
        pst.setString(3,phoneProcessortf.getText());
        pst.setString(4,phoneCameratf.getText());
        pst.setString(5,phonePricetf.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Telefon eklendi");
    }
    @FXML
    void adminBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("adminPanelFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminBackBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminExit(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
