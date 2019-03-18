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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class PhoneFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    @FXML private Button phoneSamsungBtn;
    @FXML private Button phoneHuaweiBtn;
    @FXML private Button phoneAppleBtn;
    @FXML private Button phoneexit;
    @FXML private Button backBtn;
    @FXML private Button logoutphone;   
    @FXML private TableColumn<phone, String> colPhoneModel;
    @FXML private TableColumn<phone, Integer> colPhoneRam;
    @FXML private TableColumn<phone, String> colPhoneProcessor;
    @FXML private TableColumn<phone, Integer> colPhoneCamera;
    @FXML private TableView<phone> phoneTableView;
    
    
    ObservableList<phone> phoneData = FXCollections.observableArrayList();
    @FXML
    void phoneExit(ActionEvent event) {
         Platform.exit();
    }

    @FXML
    void phoneSamsungShow(ActionEvent event) throws SQLException, ClassNotFoundException {
        
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rsset = connection.createStatement().executeQuery("select * from phone_Table where model like 'samsung%'");
        while(rsset.next()){
            phoneData.add(new phone(rsset.getString("model"),rsset.getInt("ram"),rsset.getString("processor"),rsset.getInt("camera")));
        }
        colPhoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colPhoneRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
        colPhoneProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colPhoneCamera.setCellValueFactory(new PropertyValueFactory<>("camera"));
        phoneTableView.setItems(phoneData);
        
        System.out.println("Bilgiler gösterildi");
        
    }

    @FXML
    void phoneAppleShow(ActionEvent event) throws SQLException {
        
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rsset = connection.createStatement().executeQuery("select * from phone_Table where model like 'apple%'");
        while(rsset.next()){
            phoneData.add(new phone(rsset.getString("model"),rsset.getInt("ram"),rsset.getString("processor"),rsset.getInt("camera")));
        }
        colPhoneModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colPhoneRam.setCellValueFactory(new PropertyValueFactory<>("ram"));
        colPhoneProcessor.setCellValueFactory(new PropertyValueFactory<>("processor"));
        colPhoneCamera.setCellValueFactory(new PropertyValueFactory<>("camera"));
        phoneTableView.setItems(phoneData);
        
        System.out.println("a");
    }

    @FXML
    void phoneHuaweiShow(ActionEvent event) {

    }
    @FXML
    void logoutPhone(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }
     @FXML
    void phoneBack(ActionEvent event) throws IOException {
        

        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        stage.setScene(new Scene(root,650,500));
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    /*
    private ObservableList<ObservableList> tablodoldur() throws SQLException, ClassNotFoundException{
        return null;
        /*
        phoneData = FXCollections.observableArrayList();
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String sql = "SELECT * from phoneTable";
        ResultSet rs = connection.createStatement().executeQuery(sql);
        for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
        final int j = i;
        TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
        col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){
        public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
        return new SimpleStringProperty(param.getValue().get(j).toString());
        }
        });
        phoneTableView.getColumns().addAll(col);
        System.out.println("Column ["+i+"] ");
        while(rs.next()){
        //Satırları yinele
        ObservableList<String> row = FXCollections.observableArrayList();
        for( i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
        //sütunları yinele
        row.add(rs.getString(i));
        }
        System.out.println("Satır eklendi "+row );
        phoneData.add(row);
        
        }
        phoneTableView.setItems(phoneData);
        }
         
        return null;
   
  
}  */
}
