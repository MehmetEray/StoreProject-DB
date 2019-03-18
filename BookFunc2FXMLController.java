/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mehmet eray
 */
public class BookFunc2FXMLController implements Initializable {

    @FXML
    private TextField booknameDeletetf;

    @FXML
    private Button bookDeleteBtn;

    @FXML
    private TextField bookAuthorDeletetf;

    @FXML
    private TextField booktypeDeletetf;

    @FXML
    void bookDelete(ActionEvent event) throws SQLException {
        adminInsertClass.deleteBook(booknameDeletetf.getText(), bookAuthorDeletetf.getText(), booktypeDeletetf.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
