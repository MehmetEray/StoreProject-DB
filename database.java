package javafxapplication2;

import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/*@author mehmet eray
 */
public class database {
    private static final String jdbc_driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static Connection connection = null;
    private static final String conStr = "jdbc:sqlserver://localhost:1433;databaseName=project;integratedSecurity = true";
    public static void dbconnect() throws ClassNotFoundException, SQLException{
        Class.forName(jdbc_driver);
        System.out.println("jdbc driver has been registered");
    }
    
    /*Connection con = null;
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    String url = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=123456789;integratedSecurity = true";
    connection = DriverManager.getConnection(url);
    System.out.println("Success");
    java.sql.Statement state = con.createStatement();
        
    return con;*/
            
    public static void dbdisconnect() throws SQLException{
        if(connection != null && !connection.isClosed()){
            connection.close();
        }
    }
    public static void dbexecuteQuery(String sqlStatement) throws SQLException{
        Statement statement = null;
        try {
            dbconnect();
            statement = connection.createStatement();
            statement.executeUpdate(sqlStatement);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problem at dbexecuteWuery");
        }
        finally{
            if(statement != null){
                statement.close();
            }
        }
    }
    public static ResultSet dbExecute(String sqlQuery) throws SQLException{
        Statement statement2 = null;
        ResultSet rs = null;
        CachedRowSetImpl crs = null;
        
        try {
            dbconnect();
            statement2 = connection.createStatement();
            rs = statement2.executeQuery(sqlQuery);
            crs = new CachedRowSetImpl();
            crs.populate(rs);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(rs != null){
                rs.close();
            }if(statement2  != null){
                statement2.close();
            }
            dbdisconnect();
        }
        return crs;
        
        
        
        
    }
}
