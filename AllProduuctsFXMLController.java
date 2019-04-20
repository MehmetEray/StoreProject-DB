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
import static javafxapplication2.ComFunc2FXMLController.compData;
import static javafxapplication2.ComFunc2FXMLController.connection;
import static javafxapplication2.HeadphonesFXMLController.connection;
import static javafxapplication2.PhoneFXMLController.connection;
import static javafxapplication2.generalFunc.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AllProduuctsFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    static ObservableList<headphone> headphoneData = FXCollections.observableArrayList();
    @FXML private TableColumn<?, ?> colProductsPrices;
    @FXML private Button productsBackBtn;
    @FXML private TableView<product> productsTableView;
    @FXML private Button productsExitBtn;
    @FXML private Button showProductsBtn;
    @FXML private TableColumn<?, ?> colProductsNames;
   
    static ObservableList<product> productData = FXCollections.observableArrayList();
    
    PreparedStatement pst;
    ResultSet rs;
    generalFunc gf = new generalFunc();
    
    
    @FXML
    void productsBack(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", productsBackBtn);
    }

    @FXML
    void showProducts(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String sqlView = "select * from [project].[dbo].[book]";
        ResultSet rs = connection.createStatement().executeQuery(sqlView);
        while(rs.next()){
            productData.add(new product(rs.getString("bookName"),rs.getInt("price")));
        }
        colProductsNames.setCellValueFactory(new PropertyValueFactory<>("name"));
        colProductsPrices.setCellValueFactory(new PropertyValueFactory<>("price"));
        productsTableView.setItems(productData);
    }
    
    @FXML
    void productsExit(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void showProducts() throws SQLException{
        
    }
    
    
}
