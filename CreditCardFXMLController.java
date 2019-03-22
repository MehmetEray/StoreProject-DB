/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafxapplication2.PhoneFuncFXMLController.connection;
import javax.swing.JOptionPane;


public class CreditCardFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private TextField cardNametf;
    @FXML private TextField cardDatetf;
    @FXML private TextField cardCodetf;
    @FXML private Button cardInfoSubmitBtn;
    @FXML private TextField cardNumbertf;
    
     @FXML
    private Button credirExitBtn;
    @FXML
    void cardInfoSubmit(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "insert into creditCard values(?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,cardNumbertf.getText());
        pst.setString(2,cardCodetf.getText());
        pst.setString(3,null);
        pst.setString(4,cardDatetf.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Siparişiniz alınmıştır.Teşekkür ederiz");
    }
     @FXML
    void creditExit(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
