package controllers;

import java.sql.SQLException;
import java.util.Objects;

import dao.Agent_bancaireDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Agent_bancaire;

public class LoginController {
	@FXML
	private TextField loginEmail;

	@FXML
	private TextField loginMdp;

	private ConnectionListener connectionListener;

	public void login() throws ClassNotFoundException, SQLException {
		String email = loginEmail.getText();
		String password = loginMdp.getText();
		Agent_bancaire agentBancaire = Agent_bancaireDao.searchAgentBancaire(email, password);
	
		
		if (!Objects.isNull(agentBancaire) && (agentBancaire.getPersonnelEmail().equals(email) && agentBancaire.getPersonnelPassword().equals(password))) {
			System.out.println("Email user trouvé ");
			connectionListener.connectionButtonClicked();
		} else {
			System.out.println("veuillez verifier les identifiants ");
		}

	}

	/**
	 * Set connection button listener
	 * 
	 * @param connectionListener
	 */
	public void setListener(ConnectionListener connectionListener) {
		this.connectionListener = connectionListener;
	}

	/**
	 * 
	 * Connection Listener interface
	 *
	 */
	public interface ConnectionListener {
		void connectionButtonClicked();
	}

}
