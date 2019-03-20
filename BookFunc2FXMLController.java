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
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafxapplication2.BookFuncFXMLController.connection;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class BookFunc2FXMLController implements Initializable {

    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;tablename=phoneTable;integratedSecurity = true";
    static Connection connection;
    PreparedStatement ps = null;
    @FXML private TableColumn<?, ?> colAuthorDelete;
    @FXML private Button deletebookBtn;
    @FXML private TableColumn<?, ?> colBooknameDelete;
    @FXML private TableColumn<?, ?> colTypeDelete;
    @FXML private TableView<book> adminDeleteBookTable;
    @FXML private TableColumn<?, ?> colPriceDelete;
    @FXML private TextField deleteBooktxtfield;
    static ObservableList<book> bookData = FXCollections.observableArrayList();
    
    @FXML
    void bookDelete(ActionEvent event) throws SQLException {
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        String query = "delete from bookTable where bookName = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, deleteBooktxtfield.getText());
        pst.executeUpdate();
        System.out.println("Silindi");
        JOptionPane.showMessageDialog(null,"Success");
        deleteBooktxtfield.clear();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            showBooksToAdmin();
        } catch (SQLException ex) {
            Logger.getLogger(BookFunc2FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    public void showBooksToAdmin() throws SQLException{
        connection = DriverManager.getConnection(conStr,"sa","123456789");
        ResultSet rs = connection.createStatement().executeQuery("select * from bookTable");
        while(rs.next()){
            bookData.add(new book(rs.getString("bookName"),rs.getString("bookAuthor"),rs.getString("bookType"),rs.getInt("price")));
        }
        colBooknameDelete.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAuthorDelete.setCellValueFactory(new PropertyValueFactory<>("author"));
        colTypeDelete.setCellValueFactory(new PropertyValueFactory<>("type"));
        colPriceDelete.setCellValueFactory(new PropertyValueFactory<>("price"));
        adminDeleteBookTable.setItems(bookData);
        System.out.println("Kitaplar gösterildi");
    }
    

    
}
