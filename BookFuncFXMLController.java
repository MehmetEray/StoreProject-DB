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
import static javafxapplication2.PhoneFXMLController.connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class BookFuncFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private TextField typetf;
    @FXML private TextField authortf;
    @FXML private TextField pricetf;
    @FXML private Button bookInsertBtn;
    @FXML private TextField bookNametf;

    @FXML
    void bookInsert(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "insert into bookTable values(?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,bookNametf.getText());
        pst.setString(2,authortf.getText());
        pst.setString(3,typetf.getText());
        pst.setString(4,pricetf.getText());
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Kitap eklendi");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
