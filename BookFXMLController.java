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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static javafxapplication2.PhoneFXMLController.connection;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class BookFXMLController implements Initializable {
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    @FXML private Button showbook;
    @FXML private Button exitbook;
    @FXML private Button bookBackBtn;
    @FXML private Button bookLogOutBtn;
    @FXML private Button bookBuyBtn;
   
   
    @FXML private TableView<book> bookTableview;
    @FXML private TableColumn<book, String> colBookType;
    @FXML private TableColumn<book, String> colBookName;    
    @FXML private TableColumn<book, String> colBookAuthor;
    @FXML private TableColumn<book, String> colBookPrice;
    static ObservableList<book> bookData = FXCollections.observableArrayList();
    @FXML
    void showbook(ActionEvent event) throws IOException, SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("select * from bookTable");
        while(rs.next()){
            bookData.add(new book(rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("bookType"),rs.getInt("price")));
        }
        colBookName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colBookAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colBookType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colBookPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        bookTableview.setItems(bookData);
        
        System.out.println("Kitaplar gösterildi");
    }
      @FXML
    void exitBook(ActionEvent event) {
        Platform.exit();
    }
    @FXML
    void bookBack(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    void bookLogOut(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("loginFXML.fxml"));
        stage.setScene(new Scene(root,600,500));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }
    @FXML
    void bookBuy(ActionEvent event) {

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
