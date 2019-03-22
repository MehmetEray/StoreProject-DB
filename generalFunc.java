/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFuncFXMLController.connection;
import javax.swing.JOptionPane;


public class generalFunc {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    public void openStageFunc(String file,Button button) throws IOException{
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(file));
        stage.setScene(new Scene(root,700,600));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        button.getScene().getWindow().hide();
    }
   
}
