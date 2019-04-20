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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafxapplication2.AllProductsCompFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AllProductsPhoneFXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    generalFunc gf = new generalFunc();
    static ObservableList<phoneProduct> phoneProductData = FXCollections.observableArrayList();
    @FXML private TableColumn<?, ?> colphoneProdctsAdmi;
    @FXML private TableColumn<?, ?> colPhoneProductPrice;
    @FXML private Button exitProductPhoneButton;
    @FXML private Button showPhoneProdBtn;
    @FXML private TableView<phoneProduct> phoneProducttableview;
    @FXML private Button backPhoneProductsButton;
  

    @FXML
    void backPhoneProduct(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", backPhoneProductsButton);
    }

    @FXML
    void showProductPhones(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String sqlView = "select * from [project].[dbo].[phoneView]";
        ResultSet rs = connection.createStatement().executeQuery(sqlView);
        while(rs.next()){
            phoneProductData.add(new phoneProduct(rs.getString("model"),rs.getInt("price")));
        }
        colphoneProdctsAdmi.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhoneProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        phoneProducttableview.setItems(phoneProductData);
    }

    @FXML
    void exitPhoneProducts(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
