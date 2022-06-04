package controllers;

import dao.Agent_bancaireDao;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML
	private TextField loginEmail;

	@FXML
	private TextField loginMdp;

	private ConnectionListener connectionListener;

	public void login() {
		String email = loginEmail.getText();
		String password = loginMdp.getText();
		Agent_bancaireDao persodao = new Agent_bancaireDao();
		boolean user = persodao.verifLogin(email, password);

		if (user) {
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
