package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Client;
import util.DBUtil;

public class ClientDao {

	public ObservableList<Client> trouverClients() {

		ObservableList<Client> lstClients = FXCollections.observableArrayList();

		try {
			Connection connect = DBUtil.initConnection();
			java.sql.Statement state = connect.createStatement();
			ResultSet result = state.executeQuery(
					"SELECT Id_Client, Nom_Cl, Prenom_Cl,Ville_Cl,Adresse_Cl, tel_Cl, email_Cl, birthday  FROM client");
			while (result.next()) {
				Client unClient = new Client(result.getInt("Id_Client"), result.getString("nom_Cl"),
						result.getString("prenom_Cl"), result.getString("Ville_CL"), result.getString("Adresse_Cl"),
						result.getString("tel_Cl"), result.getString("email_Cl"), result.getString("birthday"));
				lstClients.add(unClient);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstClients;

		// ------ici creer methode pour inserer new person dans la BDD getpersondata
		// ..pfff

	}

}
