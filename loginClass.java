/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import java.sql.SQLException;


/**
 *
 * @author mehmet eray
 */
public class loginClass{
    public static void insert(String userName,String password2) throws SQLException{
        String sql = "insert into login(username,password) values ('"+ userName+ "','"+ password2 + "')";
        database.dbexecuteQuery(sql);
    }
}
