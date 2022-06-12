package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Compte;
import model.Operation;
import util.DBUtil;

public class OperationDao {


	public static ObservableList<Operation> getOperations() throws ClassNotFoundException, SQLException {

		ObservableList<Operation> operationsList = FXCollections.observableArrayList();
		String selectStmt = "SELECT id_Operation, type_Op, date_Op, valeur_Op FROM operation";

		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			operationsList = getAccountsFromResultSet(rsEmp);
			// Return employee object
			return operationsList;

		} catch (SQLException e) {
			System.out.println("While retrieving Operations, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}
	
	
	public static ObservableList<Operation> getOperationsByNum(int operationNum) throws ClassNotFoundException, SQLException {

		ObservableList<Operation> operationsList = FXCollections.observableArrayList();
		String selectStmt = "SELECT id_Operation, type_Op, date_Op, valeur_Op FROM operation WHERE id_Operation=" + operationNum;

		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			operationsList = getAccountsFromResultSet(rsEmp);
			// Return employee object
			return operationsList;

		} catch (SQLException e) {
			System.out.println("While retrieving Operations, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}

	// Use ResultSet from DB as parameter and set ObservableList<Operation> Object's
	// attributes
	// and return ObservableList<Operation> object.
	private static ObservableList<Operation> getAccountsFromResultSet(ResultSet rs) throws SQLException {
		ObservableList<Operation> operationsList = FXCollections.observableArrayList();
		while (rs.next()) {
			Operation uneOperation = new Operation(rs.getInt("id_Operation"), rs.getString("type_Op"),
					rs.getString("date_Op"), rs.getString("valeur_Op"));
			operationsList.add(uneOperation);
		}
		return operationsList;
	}

}