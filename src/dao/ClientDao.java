package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;
import util.DBUtil;

public class ClientDao {

	public static ObservableList<Client> getClients() throws ClassNotFoundException, SQLException {

		ObservableList<Client> clientsList = FXCollections.observableArrayList();
		String selectStmt = "SELECT Id_Client, Nom_Cl, Prenom_Cl,Ville_Cl,Adresse_Cl, tel_Cl, email_Cl, birthday  FROM client";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			clientsList = getClientsFromResultSet(rsEmp);
			// Return employee object
			return clientsList;
		} catch (SQLException e) {
			System.out.println("While retrieving clients, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}

	public static ObservableList<Client> getClientsByNomEtPrenom(String nom, String prenom, String ville)
			throws ClassNotFoundException, SQLException {

		ObservableList<Client> clientsList = FXCollections.observableArrayList();
		
		StringBuilder builderSelectStmt = new StringBuilder( "SELECT Id_Client, Nom_Cl, Prenom_Cl,Ville_Cl,Adresse_Cl, tel_Cl, email_Cl, birthday  FROM client WHERE Nom_Cl='"
				+ nom + "' AND Prenom_Cl='" + prenom + "'");
		
		if (!ville.isEmpty()) {
			builderSelectStmt.append(" AND Ville_Cl='" + ville + "'");
		}

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(builderSelectStmt.toString());
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			clientsList = getClientsFromResultSet(rsEmp);
			// Return employee object
			return clientsList;
		} catch (SQLException e) {
			System.out.println("While retrieving clients, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}

	// Use ResultSet from DB as parameter and set ObservableList<Client> Object's
	// attributes
	// and return ObservableList<Client> object.
	private static ObservableList<Client> getClientsFromResultSet(ResultSet rs) throws SQLException {
		ObservableList<Client> clientsList = FXCollections.observableArrayList();
		while (rs.next()) {
			Client unClient = new Client(rs.getInt("Id_Client"), rs.getString("nom_Cl"), rs.getString("prenom_Cl"),
					rs.getString("Ville_CL"), rs.getString("Adresse_Cl"), rs.getString("tel_Cl"),
					rs.getString("email_Cl"), rs.getString("birthday"));
			clientsList.add(unClient);
		}
		return clientsList;
	}

}
