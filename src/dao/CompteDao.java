package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;
import model.Compte;
import util.DBUtil;

public class CompteDao {

	public static ObservableList<Compte> getAccountById(String accountNumber) throws ClassNotFoundException, SQLException {

		ObservableList<Compte> accountsList = FXCollections.observableArrayList();
		String selectStmt = "SELECT id_Compte,  sole_Cmp, client.Id_Client, nom_Cl, Prenom_Cl, date_Cmp FROM compte INNER JOIN client WHERE client.Id_Client=compte.Id_Client AND compte.id_Compte='" + accountNumber + "'";

		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			accountsList = getAccountsFromResultSet(rsEmp);
			// Return employee object
			return accountsList;
			

		} catch (SQLException e) {
			System.out.println("While retrieving Account, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}

	// Use ResultSet from DB as parameter and set ObservableList<Compte> Object's
	// attributes
	// and return ObservableList<Compte> object.
	private static ObservableList<Compte> getAccountsFromResultSet(ResultSet rs) throws SQLException {
		ObservableList<Compte> accountsList = FXCollections.observableArrayList();
		while (rs.next()) {
			Compte unCompte = new Compte(rs.getInt("id_Compte"), rs.getInt("sole_Cmp"),
					rs.getInt("Id_Client"), rs.getString("nom_Cl"), rs.getString("Prenom_Cl"),
					rs.getString("date_Cmp"));
			accountsList.add(unCompte);
		}
		return accountsList;
	}

}
