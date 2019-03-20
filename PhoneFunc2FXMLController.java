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
import static javafxapplication2.BookFunc2FXMLController.connection;
import static javafxapplication2.PhoneFXMLController.phoneData;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class PhoneFunc2FXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    static ObservableList<phone> phoneData = FXCollections.observableArrayList();
    
    @FXML private TableColumn<?, ?> colAdminPhoneModel;
    @FXML private TableColumn<?, ?> colAdminPhoneRam;
    @FXML private TableColumn<?, ?> colAdminPhoneProcessor;
    @FXML private TableView<phone> adminPhoneTableView;
    @FXML private TableColumn<?, ?> colAdminPhoneCamera;
    @FXML private TableColumn<?, ?> colAdminPhonePrice;
    @FXML private TextField phoneModeltxtfield;
    @FXML private Button phoneDeleteBtn;
    @FXML
    private Button adminExitBtn;
     @FXML
    private Button adminBackBtn;

    @FXML
    void phoneDelete(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "delete from phone_Table where model = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, phoneModeltxtfield.getText());
        pst.executeUpdate();
        System.out.println("deleted");
        JOptionPane.showMessageDialog(null,"Success");
        phoneModeltxtfield.clear();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showPhonesToAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(PhoneFunc2FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void showPhonesToAdmin() throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("select * from phone_Table");
        while(rs.next()){
            phoneData.add(new phone(rs.getString("model"),rs.getInt("ram"),rs.getString("processor"),rs.getInt("camera"),rs.getInt("price")));
        }
        colAdminPhoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colAdminPhoneRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
        colAdminPhoneProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colAdminPhoneCamera.setCellValueFactory(new PropertyValueFactory<>("camera"));
        colAdminPhonePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        adminPhoneTableView.setItems(phoneData);
        System.out.println("Kitaplar gösterildi");
    }
    @FXML
    void adminBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("adminPanelFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
        adminBackBtn.getScene().getWindow().hide();
    }

    @FXML
    void adminExit(ActionEvent event) {
        Platform.exit();
    }
    
}
