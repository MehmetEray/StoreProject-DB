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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFXMLController.phoneData;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class PhoneFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    @FXML private Button phoneSamsungBtn;
    @FXML private Button phoneHuaweiBtn;
    @FXML private Button phoneAppleBtn;
    @FXML private Button phoneexit;
    @FXML private Button backBtn;
    @FXML private Button logoutphone;   
    @FXML private TableColumn<phone, String> colPhoneModel;
    @FXML private TableColumn<phone, Integer> colPhoneRam;
    @FXML private TableColumn<phone, String> colPhoneProcessor;
    @FXML private TableColumn<phone, Integer> colPhoneCamera;
    @FXML private TableColumn<phone, Integer> colPhonePrice;
    @FXML private TableView<phone> phoneTableView;
    @FXML private Button phoneBuyBtn; 
    private Label labelPhonelbl;
    @FXML private Label phonelbl;
    static ObservableList<phone> phoneData = FXCollections.observableArrayList();
    generalFunc gf = new generalFunc();
    @FXML 
    void phoneExit(ActionEvent event) { Platform.exit(); }
    

    @FXML
    void phoneSamsungShow(ActionEvent event) throws SQLException, ClassNotFoundException {
        showPhoneFunc("Exec phones samsung");
        System.out.println("Samsung telefonlar gösterildi");
    }

    @FXML
    void phoneAppleShow(ActionEvent event) throws SQLException {
        showPhoneFunc("Exec phones apple");
        System.out.println("Apple telefonlar gösterildi");
    }

    @FXML
    void phoneHuaweiShow(ActionEvent event) throws SQLException {
        showPhoneFunc("Exec phones huawei");
        System.out.println("Huawei telefonlar gösterildi");
    }
    @FXML
    void logoutPhone(ActionEvent event) throws IOException {
        gf.openStageFunc("loginFXML.fxml", logoutphone);
    }
    @FXML
    void phoneBack(ActionEvent event) throws IOException {
        gf.openStageFunc("menuFXML.fxml", backBtn);
    }
    @FXML
    void phoneBuy(ActionEvent event) throws IOException {
        gf.openStageFunc("creditCardFXML.fxml", phoneBuyBtn);
    }
    public void showPhoneFunc(String query) throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery(query);
        while(rs.next()){
            phoneData.add(new phone(rs.getString("model"),rs.getInt("ram"),rs.getString("processor"),rs.getInt("camera"),rs.getInt("price")));
        }
        colPhoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colPhoneRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
        colPhoneProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colPhoneCamera.setCellValueFactory(new PropertyValueFactory<>("camera"));
        colPhonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        phoneTableView.setItems(phoneData);
    }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
    
}
