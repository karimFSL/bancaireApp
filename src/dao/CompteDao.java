package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Compte;
import util.DBUtil;

public class CompteDao {

	public ObservableList<Compte> trouverComptes() {

		ObservableList<Compte> lstComptes = FXCollections.observableArrayList();

		try {
			Connection connect2 = DBUtil.initConnection();
			java.sql.Statement state2 = connect2.createStatement();
			ResultSet result2 = state2.executeQuery(
					"SELECT id_Compte,  solde_Cmp, client.Id_Client, nom_Cl, Prenom_Cl, date_Cmp FROM compte INNER JOIN client WHERE client.Id_Client=compte.Id_Client");
			while (result2.next()) {
				Compte unCompte = new Compte(result2.getInt("id_compte"), result2.getInt("solde_Cmp"),
						result2.getInt("client.id_Client"), result2.getString("nom_Cl"), result2.getString("Prenom_Cl"),
						result2.getString("date_Cmp"));
				lstComptes.add(unCompte);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstComptes;
	}

}
