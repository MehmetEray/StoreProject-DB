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
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class HeadphonesFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    static ObservableList<headphone> headphoneData = FXCollections.observableArrayList();
    @FXML private Button phılıpsHeadBtn;
    @FXML private Button huaweiHeadBtn;
    @FXML private Button appleHeadBtn;
    @FXML private Button exitHead;
    @FXML private Button headphoneLogOutBtn;
    @FXML private TableView<headphone> headphoneTableView;
    @FXML private Button headPhoneBackBtn;
    @FXML private TableColumn<headphone, String> colHeadphoneModel;
    @FXML private TableColumn<headphone, String> colHeadphoneBrand;
    @FXML private TableColumn<headphone, Integer> colHeadphonePrice;
     @FXML
    private Button headphoneBuyBtn;
   

    @FXML
    void phılıpsHeadShow(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("Exec headphones philips");
        while(rs.next()){
            headphoneData.add(new headphone(rs.getString("brand"),rs.getString("model"),rs.getInt("price")));
        }
        colHeadphoneBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colHeadphoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colHeadphonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        headphoneTableView.setItems(headphoneData);
        
        System.out.println("Philips kulaklıklar gösterildi");
    }

    @FXML
    void appleHeadShow(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("Exec headphones apple");
        while(rs.next()){
            headphoneData.add(new headphone(rs.getString("brand"),rs.getString("model"),rs.getInt("price")));
        }
        colHeadphoneBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colHeadphoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colHeadphonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        headphoneTableView.setItems(headphoneData);
        //database de kayıtlı ürün yok
        System.out.println("Apple kulaklıklar gösterildi");
    }

    @FXML
    void huaweiHeadShow(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("Exec headphones huawei");
        while(rs.next()){
            headphoneData.add(new headphone(rs.getString("brand"),rs.getString("model"),rs.getInt("price")));
        }
        colHeadphoneBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colHeadphoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colHeadphonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        headphoneTableView.setItems(headphoneData);
        //database de kayıtlı ürün yok
        System.out.println("Huawei kulaklıklar gösterildi");
    }

    @FXML
    void exitHead(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void eadPhoneBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    void headPhoneLogOut(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    @FXML
    void headphoneBuy(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
