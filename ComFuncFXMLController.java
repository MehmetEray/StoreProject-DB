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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import static javafxapplication2.PhoneFuncFXMLController.connection;
import javax.swing.JOptionPane;


public class ComFuncFXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private TextField compModeltxtfield;
    @FXML private Button adminCompInsertBtn;
    @FXML private TextField compProcessortxtfield;
    @FXML private TextField compRamtxtfield;
    @FXML private TextField compCameratxtfield;
    @FXML private TextField compPricetxtfield;
    
    @FXML
    void compInsert(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "insert into compTable values(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,compModeltxtfield.getText());
        pst.setString(2,compRamtxtfield.getText());
        pst.setString(3,compProcessortxtfield.getText());
        pst.setString(4,compCameratxtfield.getText());
        pst.setString(5,compPricetxtfield.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Bilgisayar eklendi");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
