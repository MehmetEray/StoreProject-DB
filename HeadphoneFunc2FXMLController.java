/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafxapplication2.PhoneFunc2FXMLController.connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class HeadphoneFunc2FXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    static ObservableList<headphone> headphonesData = FXCollections.observableArrayList();
    @FXML
    private TextField headphoneModeltf;

    @FXML
    private TableColumn<?, ?> colHeadphonePrice;

    @FXML
    private Button headphoneDeleteBtn;

    @FXML
    private TableColumn<?, ?> colHeadphoneModel;

    @FXML
    private TableColumn<?, ?> colHeadphoneBrand;
    @FXML
    private TableView<headphone> headphoneAdminTableView;
    @FXML
    void headphoneDelete(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "delete from headphonesTable where model = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, headphoneModeltf.getText());
        pst.executeUpdate();
        System.out.println("deleted");
        JOptionPane.showMessageDialog(null,"Success");
        headphoneModeltf.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showHeadphonesToAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(HeadphoneFunc2FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void showHeadphonesToAdmin() throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs2 = connection.createStatement().executeQuery("select * from headphonesTable");
        while(rs2.next()){
            headphonesData.add(new headphone(rs2.getString("brand"),rs2.getString("model"),rs2.getInt("price")));
        }
        colHeadphoneBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colHeadphoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colHeadphonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        headphoneAdminTableView.setItems(headphonesData);
        System.out.println("Kulaklıklar gösterildi");
    }
    
}
