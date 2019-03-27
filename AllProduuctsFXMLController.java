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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafxapplication2.HeadphonesFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AllProduuctsFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    static ObservableList<headphone> headphoneData = FXCollections.observableArrayList();
    @FXML
    private TableColumn<?, ?> colProductsPrices;

    @FXML
    private Button productsBackBtn;

    @FXML
    private TableView<?> productsTableView;

    @FXML
    private Button productsExitBtn;

    @FXML
    private TableColumn<?, ?> colProductsNames;
    @FXML
    private Button showProductsBtn;
    generalFunc gf = new generalFunc();
    @FXML
    void productsBack(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", productsBackBtn);
    }

    @FXML
    void showProducts(ActionEvent event) {
        
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
        /*connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery(query);
        while(rs.next()){
            headphoneData.add(new headphone(rs.getString("brand"),rs.getString("model"),rs.getInt("price")));
        }
        colHeadphoneBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colHeadphoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colHeadphonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        headphoneTableView.setItems(headphoneData); */
    }
    public void usingView(){
        
    }
    
}
