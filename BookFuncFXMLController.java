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
    private Button adminExitBtn;
     @FXML
    private Button adminBackBtn;

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
    public void initialize(URL url, ResourceBundle rb) {}    
    
}
