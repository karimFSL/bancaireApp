package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Agent_bancaire;
import util.DBUtil;

public class Agent_bancaireDao {

	public static Agent_bancaire searchAgentBancaire(String email, String password)
			throws ClassNotFoundException, SQLException {

		String selectStmt = "SELECT userEmail, userMdp FROM personnel where userEmail='" + email + "' and userMdp='"
				+ password + "'";

		// Execute SELECT statement
		try {
			// Get ResultSet from dbExecuteQuery method
			ResultSet rsEmp = DBUtil.dbExecuteQuery(selectStmt);
			// Send ResultSet to the getEmployeeFromResultSet method and get employee object
			Agent_bancaire agentBancaire = getAgentBancaireFromResultSet(rsEmp);
			// Return employee object
			return agentBancaire;
		} catch (SQLException e) {
			System.out.println("While searching an AgentBancaire with " + email + " email, an error occurred: " + e);
			// Return exception
			throw e;
		}
	}

	// Use ResultSet from DB as parameter and set AgentBancaire Object's attributes
	// and return employee object.
	private static Agent_bancaire getAgentBancaireFromResultSet(ResultSet rs) throws SQLException {
		Agent_bancaire agent = null;
		if (rs.next()) {
			agent = new Agent_bancaire();
			agent.setPersonnelEmail(rs.getString("userEmail"));
			agent.setPersonnelPassword(rs.getString("userMdp"));
		}
		return agent;
	}
}
