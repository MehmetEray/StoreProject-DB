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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static javafxapplication2.PhoneFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class CompFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    static ObservableList<comp> compData = FXCollections.observableArrayList();
    @FXML private Button compBackBtn;
    @FXML private Button compAppleBtn;
    @FXML private Button compDellBtn;
    @FXML private Button compLogoutBtn;
    @FXML private Button compLenovoBtn;
    @FXML private Button compExitBtn;
    
    @FXML private TableColumn<comp, String> colCompModel;
    @FXML private TableColumn<comp, String> colCompProcessor;
    @FXML private TableColumn<comp, Integer> colCompSSD;
    @FXML private TableColumn<comp, Integer> colCompHDD;
    @FXML private TableColumn<comp, Integer> colCompPrice;
    @FXML private TableView<comp> compTableView;

    @FXML
    void compLenovo(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs2 = connection.createStatement().executeQuery("Exec comps lenovo");
        while(rs2.next()){
            compData.add(new comp(rs2.getString("model"),rs2.getInt("SSD"),rs2.getInt("HDD"),rs2.getString("processor"),rs2.getInt("price")));
        }
        colCompModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colCompSSD.setCellValueFactory(new PropertyValueFactory<>("SSD"));
        colCompHDD.setCellValueFactory(new PropertyValueFactory<>("HDD"));
        colCompProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colCompPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        compTableView.setItems(compData);
        
        System.out.println("Lenovo bilgisayarlar gösterildi");
    }

    @FXML
    void compApple(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs2 = connection.createStatement().executeQuery("Exec comps apple");
        while(rs2.next()){
            compData.add(new comp(rs2.getString("model"),rs2.getInt("SSD"),rs2.getInt("HDD"),rs2.getString("processor"),rs2.getInt("price")));
        }
        colCompModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colCompSSD.setCellValueFactory(new PropertyValueFactory<>("SSD"));
        colCompHDD.setCellValueFactory(new PropertyValueFactory<>("HDD"));
        colCompProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colCompPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        compTableView.setItems(compData);
        
        System.out.println("Apple bilgisayarlar gösterildi");
    }

    @FXML
    void compDell(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs2 = connection.createStatement().executeQuery("Exec comps dell");
        while(rs2.next()){
            compData.add(new comp(rs2.getString("model"),rs2.getInt("SSD"),rs2.getInt("HDD"),rs2.getString("processor"),rs2.getInt("price")));
        }
        colCompModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colCompSSD.setCellValueFactory(new PropertyValueFactory<>("SSD"));
        colCompHDD.setCellValueFactory(new PropertyValueFactory<>("HDD"));
        colCompProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colCompPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        compTableView.setItems(compData);
        
        System.out.println("Dell bilgisayarlar gösterildi");
    }

    @FXML
    void compExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void compBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        stage.setScene(new Scene(root,800,850));
        stage.show();
        compBackBtn.getScene().getWindow().hide();
    }

    @FXML
    void compLogOut(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,800,850));
        stage.show();
        compLogoutBtn.getScene().getWindow().hide();
    }
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
