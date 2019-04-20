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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.HeadphoneFunc2FXMLController.connection;
import static javafxapplication2.PhoneFunc2FXMLController.connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class ComFunc2FXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private TableColumn<?, ?> colCompModel;
    @FXML private TableView<comp> adminCompTableView;
    @FXML private TableColumn<?, ?> colCompProcessor;
    @FXML private TextField adminCompDeletetxtfield;
    @FXML private TableColumn<?, ?> colCompSSD;
    @FXML private TableColumn<?, ?> colCompHDD;
    @FXML private Button adminCompDeleteBtn;
    @FXML private TableColumn<?, ?> colCompPrice;
    @FXML private Button adminExitBtn;
    @FXML private Button adminBackBtn;
    @FXML private TextField adminPricetf;
    @FXML private Button adminUpdateBtn;
    
    static ObservableList<comp> compData = FXCollections.observableArrayList();
    generalFunc gf = new generalFunc();
    @FXML
    void compDelete(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "delete from compTable where model = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, adminCompDeletetxtfield.getText());
        pst.executeUpdate();
        System.out.println("deleted");
        JOptionPane.showMessageDialog(null,"Success");
        adminCompDeletetxtfield.clear();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showCompsToAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(ComFunc2FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void showCompsToAdmin() throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("select * from compTable");
        while(rs.next()){
            compData.add(new comp(rs.getString("model"),rs.getInt("SSD"),rs.getInt("HDD"),rs.getString("processor"),rs.getInt("price")));
        }
        colCompModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colCompSSD.setCellValueFactory(new PropertyValueFactory<>("SSD"));
        colCompHDD.setCellValueFactory(new PropertyValueFactory<>("HDD"));
        colCompProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colCompPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        adminCompTableView.setItems(compData);
        System.out.println("Bilgisayarlar gösterildi");
    }
    
    @FXML
    void adminBack(ActionEvent event) throws IOException {
        gf.openStageFunc("adminPanelFXML.fxml", adminBackBtn);
    }
    @FXML
    void adminUpdate(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "update headphonesTable set price = ? where model = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, adminPricetf.getText());
        pst.setString(2, adminCompDeletetxtfield.getText());
        pst.executeUpdate();
        System.out.println("Updated");
        JOptionPane.showMessageDialog(null,"Success");
        adminCompDeletetxtfield.clear();
        adminPricetf.clear();
    }


    @FXML
    void adminExit(ActionEvent event) {
        Platform.exit();
    }
}
