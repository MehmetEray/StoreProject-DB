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
        String sql = "insert into login(username,password) values ('"+ userName+ "','"+ password2 + "')";
        database.dbexecuteQuery(sql);
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
    /*
    public static ObservableList<phone> getAllRecords() {
        String sql = "select * from phoneTable";
        ResultSet rsSet;
        try {
            rsSet = database.dbExecute(sql);
            ObservableList<phone> phoneList = getPhoneObjects(rsSet);
            return phoneList;
        } catch (SQLException ex) {
            Logger.getLogger(loginClass.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error is getting records");
        }
        return null;
        
        
        
        
    }*/
/*
    private static ObservableList<phone> getPhoneObjects(ResultSet rsSet) { 
        try {
            ObservableList<phone> phoneList = FXCollections.observableArrayList();
            while(rsSet.next()){
                phone p = new phone();
                p.setPhoneModel(rsSet.getInt("model"));
                p.setPhoneRam(rsSet.getString("ram"));
                p.setPhoneProcessor(rsSet.getString("processor"));
                p.setPhoneCamera(rsSet.getInt("camera"));
                phoneList.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(loginClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */
    
     
}
