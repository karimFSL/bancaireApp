package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class DBUtil {

	// Declare JDBC Driver
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static Connection connect = null;
	private static String url = "jdbc:mysql://localhost:3306/banque";
	private static String user = "root";
	private static String passwd = "";

	public static void dbConnect() {
		// Setting Oracle JDBC Driver
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
		}

		System.out.println("Oracle JDBC Driver Registered!");

		try {
			connect = (Connection) DriverManager.getConnection(url, user, passwd);

		} catch (SQLException se) {
			System.out.println("Connection Failed! Check output console" + se);
			se.printStackTrace();
		}
	}

	// Close Connection
	public static void dbDisconnect()  {
		try {
			if (connect != null && !connect.isClosed()) {
				connect.close();
			}
		} catch (Exception e) {
			//throw e;
		}
	}
	
	
	  //DB Execute Query Operation
		public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        //Declare statement, resultSet and CachedResultSet as null
        ResultSet resultSet = null;
        Statement stmt = null;
        RowSetFactory aFactory = RowSetProvider.newFactory();
        CachedRowSet crs = aFactory.createCachedRowSet();
    
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            System.out.println("Select statement: " + queryStmt + "\n");
            //Create statement
            stmt = connect.createStatement();
            //Execute select (query) operation
            resultSet = stmt.executeQuery(queryStmt);
            
            //In order to prevent "java.sql.SQLRecoverableException: Closed Connection: next" error
            //We are using CachedRowSet
            crs.populate(resultSet);
   
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                //Close resultSet
                resultSet.close();
            }
            if (stmt != null) {
                //Close Statement
                stmt.close();
            }
            //Close connection
            dbDisconnect();
        }
        //Return CachedRowSet
        return crs;
    }
    
    
    //DB Execute Update (For Update/Insert/Delete) Operation
    public static void dbExecuteUpdate(String sqlStmt) {
        //Declare statement as null
        Statement stmt = null;
        try {
            //Connect to DB (Establish Oracle Connection)
            dbConnect();
            //Create Statement
            stmt = connect.createStatement();
            //Run executeUpdate operation with given sql statement
            stmt.executeUpdate(sqlStmt);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
           // throw e;
        } finally {
            if (stmt != null) {
                //Close statement
                try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            //Close connection
            dbDisconnect();
        }
    }
}
