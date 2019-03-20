/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author mehmet eray
 */
public class loginClass{
    public static void insert(String userName,String password2) throws SQLException{
        String typ = "user";
        String sql = "insert into login(username,password,type) values ('"+ userName +"','"+ password2 +"','"+ typ +"')";
        //String sql = "insert into login(username,password,type) values '"+ userName +"','"+ password2 +"'" + typ;
        System.out.println("NP");
        database.dbexecuteQuery(sql);
        System.out.println("NP");
    }
    public static ObservableList<loginClass> search(String usernameSearch){
        String sql = "select * from login where username = " + usernameSearch;
        try {
            ResultSet rsSet = database.dbExecute(sql);
            if(rsSet != null){
                System.out.println("Successful login");
            }
            else{
                System.out.println("Failed");
            }
                    } catch (SQLException ex) {
            Logger.getLogger(loginClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problem is in search");
        }
        return null;
    }
  
    
     
}
