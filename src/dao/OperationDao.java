package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Operation;
import util.DBUtil;

public class OperationDao {

	public ObservableList<Operation> trouverOperations() {

		ObservableList<Operation> lstOperations = FXCollections.observableArrayList();

		try {
			Connection connect3 = DBUtil.initConnection();
			java.sql.Statement state3 = connect3.createStatement();
			ResultSet result3 = state3.executeQuery("SELECT id_Operation, type_Op, date_Op, valeur_Op FROM operation");
			while (result3.next()) {
				Operation uneoperation = new Operation(result3.getInt("id_Operation"), result3.getInt("type_Op"),
						result3.getString("date_Op"), result3.getInt("valeur_Op"));// ces memes "bleu" sont les
																					// variables
																					// à
																					// creer dans operation.Java
				lstOperations.add(uneoperation);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstOperations;
	}

}