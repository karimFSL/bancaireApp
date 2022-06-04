package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;

public class ModifController {

	@FXML
	private TextField fdnom;
	@FXML
	private TextField fdprenom;
	@FXML
	private TextField fdville;
	@FXML
	private TextField fdadresse;
	@FXML
	private TextField fdtel;
	@FXML
	private TextField fdemail;
	@FXML
	private TextField fdbirthday;

	private Stage dialogStage;
	private Client unclient;
	private boolean okClicked = false;

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setClient(Client unclient) {
		this.unclient = unclient;

		fdnom.setText(unclient.getNomClient());
		fdprenom.setText(unclient.getPrenomClient());
		fdadresse.setText(unclient.getAdresseClient());
		fdville.setText(unclient.getVilleClient());
		fdtel.setText(unclient.getTelClient());
		fdemail.setText(unclient.getEmailClient());

		fdbirthday.setText(unclient.getDateClient());
	}

	public boolean isOkClicked() {
		return okClicked;
	}

	@FXML
	private void handleOk() {
		if (isInputValid()) {
			unclient.setNomClient(fdnom.getText());
			;
			unclient.setPrenomClient(fdprenom.getText());
			unclient.setVilleClient(fdville.getText());
			// unclient.setPostalCode(Integer.parseInt(postalCodeField.getText()));
			unclient.setAdresseClient(fdadresse.getText());
			unclient.setAdresseClient(fdtel.getText());
			unclient.setAdresseClient(fdemail.getText());
			unclient.setDateClient(fdbirthday.getText());

			okClicked = true;
			dialogStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	private boolean isInputValid() {
		String errorMessage = "";

		if (fdnom.getText() == null || fdnom.getText().length() == 0) {
			errorMessage += "Nom invalide!\n";
		}
		if (fdprenom.getText() == null || fdprenom.getText().length() == 0) {
			errorMessage += "prenom invalide!\n";
		}
		if (fdville.getText() == null || fdville.getText().length() == 0) {
			errorMessage += "ville invalide!\n";
		}

		if (fdadresse.getText() == null || fdadresse.getText().length() == 0) {
			errorMessage += "adresse invalide !\n";
		} /*
			 * else { // try to parse the postal code into an int. try {
			 * Integer.parseInt(postalCodeField.getText()); } catch (NumberFormatException
			 * e) { errorMessage += "No valid postal code (must be an integer)!\n"; } }
			 */

		if (fdtel.getText() == null || fdtel.getText().length() == 0) {
			errorMessage += "No valid city!\n";
		}

		if (fdemail.getText() == null || fdemail.getText().length() == 0) {
			errorMessage += "email invalide!\n";
		}

		if (fdbirthday.getText() == null || fdbirthday.getText().length() == 0) {
			errorMessage += "email invalide!\n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("champs invalide");
			alert.setHeaderText("veuillez remplir les champs");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}
