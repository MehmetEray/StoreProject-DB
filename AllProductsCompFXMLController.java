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
import static javafxapplication2.AllProduuctsFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AllProductsCompFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    generalFunc gf = new generalFunc();
    @FXML private Button exitPhooneProductAdminbtn;
    @FXML private TableColumn<?, ?> colPhoneProductsAdmin;
    @FXML private TableColumn<?, ?> colPhonePriceAdmin;
    @FXML private Button backBtnPhoneAdmin;
    @FXML private Button showPhonesAdminButton;
    @FXML private TableView<compProducts> ProductCompTableView;
   
    static ObservableList<compProducts> compProductData = FXCollections.observableArrayList();
    @FXML
    void showPhonesProductAdmin(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String sqlView = "select * from [project].[dbo].[compView]";
        ResultSet rs = connection.createStatement().executeQuery(sqlView);
        while(rs.next()){
            compProductData.add(new compProducts(rs.getString("model"),rs.getInt("price")));
        }
        colPhoneProductsAdmin.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhonePriceAdmin.setCellValueFactory(new PropertyValueFactory<>("price"));
        ProductCompTableView.setItems(compProductData);
    }

    @FXML
    void backProductPhoneAdminBtn(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", backBtnPhoneAdmin);
    }

    @FXML
    void exitPhoneProductButton(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
