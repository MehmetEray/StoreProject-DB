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
import static javafxapplication2.AllProductsPhoneFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class AllProductsHeadPFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement pst;
    ResultSet rs;
    generalFunc gf = new generalFunc();
    static ObservableList<headpProduct> headProductData = FXCollections.observableArrayList();
    @FXML
    private TableView<headpProduct> HeadpProductTableView;

    @FXML
    private Button headpProductShowBtn;

    @FXML
    private TableColumn<?, ?> colHeadpProductAdmin;

    @FXML
    private Button backHeadpProductButton;

    @FXML
    private TableColumn<?, ?> colHeadpProductPrice;

    @FXML
    private Button exitHeadpProductButton;

    @FXML
    void showHeadpProducts(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String sqlView = "select * from [project].[dbo].[headpView]";
        ResultSet rs = connection.createStatement().executeQuery(sqlView);
        while(rs.next()){
            headProductData.add(new headpProduct(rs.getString("model"),rs.getInt("price")));
        }
        colHeadpProductAdmin.setCellValueFactory(new PropertyValueFactory<>("name"));
        colHeadpProductPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        HeadpProductTableView.setItems(headProductData);
    }

    @FXML
    void backHeadpProduct(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", backHeadpProductButton);
    }

    @FXML
    void exitHeadpProduct(ActionEvent event) {
        Platform.exit();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
