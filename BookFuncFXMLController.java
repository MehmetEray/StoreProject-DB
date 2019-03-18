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
public class BookFuncFXMLController implements Initializable {

    @FXML
    private TextField typetf;

    @FXML
    private TextField pricetf;

    @FXML
    private TextField authortf;

    @FXML
    private Button bookInsertBtn;

    @FXML
    private TextField bookNametf;

   

    @FXML
    void bookInsert(ActionEvent event) throws SQLException {
        adminInsertClass.insertBook(bookNametf.getText(), authortf.getText(), typetf.getText(), pricetf.getText());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
