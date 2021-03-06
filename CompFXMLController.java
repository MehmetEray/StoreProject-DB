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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFXMLController.connection;

public class CompFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    static ObservableList<comp> compData = FXCollections.observableArrayList();
    @FXML private Button compBackBtn;
    @FXML private Button compAppleBtn;
    @FXML private Button compDellBtn;
    @FXML private Button compLogoutBtn;
    @FXML private Button compLenovoBtn;
    @FXML private Button compExitBtn;
    @FXML private Button compBuyBtn;
    @FXML private TableColumn<comp, String> colCompModel;
    @FXML private TableColumn<comp, String> colCompProcessor;
    @FXML private TableColumn<comp, Integer> colCompSSD;
    @FXML private TableColumn<comp, Integer> colCompHDD;
    @FXML private TableColumn<comp, Integer> colCompPrice;
    @FXML private TableView<comp> compTableView;
    @FXML private TextField compOrdertf;
    @FXML private Button compSaveOrderBtn;
    @FXML private TextArea compTextArea;
    @FXML private Label compLabelName;
   
    generalFunc gf = new generalFunc();
    @FXML
    void compLenovo(ActionEvent event) throws SQLException {
        showCompFunc("Exec comps lenovo");
        System.out.println("Lenovo bilgisayarlar gösterildi");
    }
    @FXML
    void compSaveOrder(ActionEvent event) {
        compTextArea.setText("Siparişiniz alınmıştır");
    }
    @FXML
    void compApple(ActionEvent event) throws SQLException {
        showCompFunc("Exec comps apple");
        System.out.println("Apple bilgisayarlar gösterildi");
    }

    @FXML
    void compDell(ActionEvent event) throws SQLException {
        showCompFunc("Exec comps dell");
        System.out.println("Dell bilgisayarlar gösterildi");
    }

    @FXML
    void compExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void compBack(ActionEvent event) throws IOException {
        gf.openStageFunc("menuFXML.fxml", compBackBtn);
    }

    @FXML
    void compLogOut(ActionEvent event) throws IOException {
        gf.openStageFunc("loginFXML.fxml", compLogoutBtn);
    }
    @FXML
    void compBuy(ActionEvent event) throws IOException {
        
        gf.openStageFunc("creditCardFXML.fxml", compBuyBtn);
    }
    public void showCompFunc(String query) throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs3 = connection.createStatement().executeQuery(query);
        while(rs3.next()){
            compData.add(new comp(rs3.getString("model"),rs3.getInt("SSD"),rs3.getInt("HDD"),rs3.getString("processor"),rs3.getInt("price")));
        }
        colCompModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colCompSSD.setCellValueFactory(new PropertyValueFactory<>("SSD"));
        colCompHDD.setCellValueFactory(new PropertyValueFactory<>("HDD"));
        colCompProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colCompPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        compTableView.setItems(compData);
    }
    public void initialize(URL url, ResourceBundle rb) { }    


}
