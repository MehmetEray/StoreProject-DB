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
public class adminInsertClass {
    public static void insertBook(String bookname,String author,String type,Integer price) throws SQLException{
        String sql = "insert into bookTable(bookName,bookAuthor,bookType,price) values ('"+ bookname+ "','"+ author + ","+ type+ "','"+ price + "')";
        database.dbexecuteQuery(sql);
    }
    public static void deleteBook(String bookname,String author,String type) throws SQLException{
        String sql = "DELETE FROM Customers WHERE bookName = bookname and bookAuthor = author and bookType = type";
        database.dbexecuteQuery(sql);
    }
}
