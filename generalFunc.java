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
import static javafxapplication2.PhoneFXMLController.connection;
import static javafxapplication2.PhoneFuncFXMLController.connection;
import javax.swing.JOptionPane;


public class generalFunc {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    String type1 = "user";
    String type2 = "admin";
    public void openStageFunc(String file,Button button) throws IOException{
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource(file));
        stage.setScene(new Scene(root,700,470));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        button.getScene().getWindow().hide();
    }
   public boolean loginUser(String userName,String Password) throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        
        PreparedStatement preparedStatement;
        ResultSet rs;
        String query = "select * from login where username = ? and password = ? type = ?";
        String query2 = "select * from login where username = ? and password = ? type = ?";
        boolean check = false;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            System.out.println("1");
            preparedStatement.setString(2,Password);
            System.out.println("2");
            preparedStatement.setString(3,type1);
            System.out.println("3");
            rs = preparedStatement.executeQuery();
            System.out.println("4");
            if (rs.next()) {
                System.out.println("True");
                return check = true;

            } else {
                System.out.println("False a");
                return check = false;
            }
        } catch (Exception e) {
            System.out.println("False b");
            return check = false;
            }
        
        
    }
   public boolean loginAdmin(String userName,String Password) throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        PreparedStatement preparedStatement;
        ResultSet rs;
        String query = "select * from login where username = ? and password = ? type = ?";
        boolean check = false;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,userName);
            System.out.println("1");
            preparedStatement.setString(2,Password);
            System.out.println("2");
            preparedStatement.setString(3,type2);
            System.out.println("3");
            rs = preparedStatement.executeQuery();
            System.out.println("4");
            if (rs.next()) {
                System.out.println("True");
                return check = true;

            } else {
                System.out.println("False a");
                return check = false;
            }
        } catch (Exception e) {
            System.out.println("False b");
            return check = false;
            }
    }
}
