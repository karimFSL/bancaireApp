package controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

import com.mysql.jdbc.StringUtils;

import application.Main;
import dao.ClientDao;
import dao.CompteDao;
import dao.OperationDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Client;
import model.Compte;
import model.Operation;
import util.Util;

public class AccueilController {

	// ----client
	// _______la base
	@FXML
	private TableView<Client> tbClient;
	@FXML
	private TableColumn<Client, String> clNom;
	@FXML
	private TableColumn<Client, String> clPrenom;
	@FXML
	private TableColumn<Client, String> clVille;
	@FXML
	private TableColumn<Client, String> clAdresse;
	// ___interaction
	@FXML
	private Label lblnom;
	@FXML
	private Label lblprenom;
	@FXML
	private Label lbladresse;
	@FXML
	private Label lblville;
	@FXML
	private Label lbltel;
	@FXML
	private Label lblemail;
	@FXML
	private Label lblbirthday;

	// Compte
	@FXML
	private TableView<Compte> tbCompte;
	@FXML
	private TableColumn<Compte, Integer> txtIdCmp;
	@FXML
	private TableColumn<Compte, Integer> txtIdCl;
	@FXML
	private TableColumn<Compte, Integer> txtSolde;
	@FXML
	private TableColumn<Compte, Integer> txtdateCmp;
	@FXML
	private Label lblnomc;
	@FXML
	private Label lblprenomc;
	@FXML
	private Label lbldatecrea;
	@FXML
	private Label lblsolde;
	// interaction
	@FXML
	private TextField textFieldNom;
	@FXML
	private TextField textFieldPrenom;
	@FXML
	private TextField textFieldVille;
	@FXML
	private TextField numOperation;
	@FXML
	private TextField textFieldNumeroCompte;

	@FXML
	private TextField numCompteTextField;
	@FXML
	private TextField nomCompteTextField;
	@FXML
	private TextField dateCreationCompteTextField;
	@FXML
	private TextField soldeCompteTextField;

	@FXML
	private Button butfind;

	private FXMLLoader fxmlLoader;

	// operation
	@FXML
	private TableView<Operation> tbOperation;
	@FXML
	private TableColumn<Operation, Integer> IdOp;
	@FXML
	private TableColumn<Operation, String> typeOp;
	@FXML
	private TableColumn<Operation, String> dateOp;
	@FXML
	private TableColumn<Operation, String> valeurOp;

	private Stage dialogStage;

	private HomeEditButtonListener homeEditButtonListener;

	private HomeAddButtonListener homeAddButtonListener;

	private void AfficherDetailsClient(Client unclient) {
		lblnom.setText(unclient.getNomClient());
		lblprenom.setText(unclient.getPrenomClient());
		lbladresse.setText(unclient.getAdresseClient());
		lblville.setText(unclient.getVilleClient());
		lbltel.setText(unclient.getTelClient());
		lblemail.setText(unclient.getEmailClient());

		lblbirthday.setText(unclient.getDateClient());
	}

	private void AfficherDetailsCompte(Compte uncompte) {
		System.out.println(uncompte.getNomClient());
		System.out.println(uncompte.getPrenomClient());
		System.out.println(uncompte.getDate_compte());
		String nom = uncompte.getNomClient();
		String date = uncompte.getDate_compte();
		System.out.println("date = " + date);
		lblnomc.setText(nom);
		lblprenomc.setText(uncompte.getPrenomClient());
		lbldatecrea.setText(date);

		lblsolde.setText(Integer.toString(uncompte.getSolde_compte()));
	}

	@FXML
	private void initialize() {
		// initialisation nom prenom
		clNom.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
		clPrenom.setCellValueFactory(cellData -> cellData.getValue().prenomClientProperty());
		clVille.setCellValueFactory(cellData -> cellData.getValue().villeClientProperty());
		clAdresse.setCellValueFactory(cellData -> cellData.getValue().adresseClientProperty());

		// intialise compte
//		txtIdCmp.setCellValueFactory(cellData -> cellData.getValue().id_compteProperty().asObject());
//		txtSolde.setCellValueFactory(cellData -> cellData.getValue().solde_compteProperty().asObject());
//		txtIdCl.setCellValueFactory(cellData -> cellData.getValue().idClientProperty().asObject());

		// afficher details ompte

		// butfind.setCellValueFactory(cellData -> cellData.getValue() );

		// initialise operation
		IdOp.setCellValueFactory(cellData -> cellData.getValue().id_OperationProperty().asObject());
		typeOp.setCellValueFactory(cellData -> cellData.getValue().type_OpProperty());
		dateOp.setCellValueFactory(cellData -> cellData.getValue().date_OpProperty());
		valeurOp.setCellValueFactory(cellData -> cellData.getValue().valeur_OpProperty());

		// labels

		// client
		tbClient.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> AfficherDetailsClient(newValue));

		// compte
//		tbCompte.getSelectionModel().selectedItemProperty()
//				.addListener((observable, oldValue, newValue) -> AfficherDetailsCompte(newValue));

		// fillTAbClient();
		// fillTabCompte();
		// fillTabOperation();
	}

	// controle partie client
	private ObservableList<Client> lstClients = FXCollections.observableArrayList();
	// Account partie operation
	private ObservableList<Compte> lstAccount = FXCollections.observableArrayList();
	// controle partie operation
	private ObservableList<Operation> lstOperations = FXCollections.observableArrayList();

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = tbClient.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			tbClient.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(Main.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	// --------cette section1 à editer meme façon que ici haut
	@FXML
	private void supprimerCompte() {
		int selectedIndex = tbCompte.getSelectionModel().getSelectedIndex();
		tbCompte.getItems().remove(selectedIndex);
	}

	@FXML
	private void supprimerOperation() {
		int selectedIndex = tbOperation.getSelectionModel().getSelectedIndex();
		tbOperation.getItems().remove(selectedIndex);
	}

	@FXML
	private void searchCompte() {
		int selectedIndex = tbCompte.getSelectionModel().getSelectedIndex();
		tbCompte.getItems().remove(selectedIndex);
	}

	@FXML
	private void searchOperation() {

		String numOperationValue = numOperation.getText();

		Alert alert = null;

		if (!numOperationValue.isEmpty() && Util.isNumeric(numOperationValue)) {
			try {
				lstOperations = OperationDao.getOperationsByNum(Integer.parseInt(numOperationValue));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (lstOperations.isEmpty()) {
				alert = new Alert(AlertType.WARNING);
				alert.initOwner(Main.getPrimaryStage());
				alert.setTitle("Num Operation research");

				alert.setHeaderText("No operation found with operation number " + numOperationValue);
				alert.setContentText("No modifcation performed. Enter please an existing operation Number.");
				alert.showAndWait();
			} else {
				tbOperation.setItems(lstOperations);
			}

		} else {
			alert = new Alert(AlertType.ERROR);
			alert.initOwner(Main.getPrimaryStage());
			alert.setTitle("Num Operation research");
			if (numOperation.getText().isEmpty()) {
				alert.setHeaderText("Operation num is empty");
				alert.setContentText("Enter please a valid operation number.");
			} else if (!Util.isNumeric(numOperation.getText())) {
				alert.setHeaderText("Operation num is not a number");
				alert.setContentText("Enter please a valid operation number.");

			}
			alert.showAndWait();
		}
	}

	@FXML
	private void searchClient() {
		String nomClientValue = textFieldNom.getText();
		String prenomClientValue = textFieldPrenom.getText();
		String villeCLientValue = textFieldVille.getText();

		Alert alert = null;

		if (!nomClientValue.isEmpty() && !prenomClientValue.isEmpty()) {
			try {
				lstClients = ClientDao.getClientsByNomEtPrenom(nomClientValue, prenomClientValue, villeCLientValue);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (lstClients.isEmpty()) {
				alert = new Alert(AlertType.WARNING);
				alert.initOwner(Main.getPrimaryStage());
				alert.setTitle("Client research");

				alert.setHeaderText("No operation found with client lastname " + nomClientValue + " and firstname "
						+ prenomClientValue);
				alert.setContentText("No modifcation performed. Enter please an existing lastname and firstname.");
				alert.showAndWait();
			} else {
				tbClient.setItems(lstClients);
			}

		} else {
			alert = new Alert(AlertType.ERROR);
			alert.initOwner(Main.getPrimaryStage());
			alert.setTitle("Client research");

			alert.setHeaderText("firstname and/or lastname is/are empty(ies)");
			alert.setContentText("Enter please a valid firstname and lastname.");
			alert.showAndWait();
		}
	}

	@FXML
	private void searchAccount() {
		String accountNumberValue = textFieldNumeroCompte.getText();

		Alert alert = null;

		if (!accountNumberValue.isEmpty()) {
			try {
				lstAccount = CompteDao.getAccountById(accountNumberValue);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (lstAccount.isEmpty()) {
				alert = new Alert(AlertType.WARNING);
				alert.initOwner(Main.getPrimaryStage());
				alert.setTitle("Account research");

				alert.setHeaderText("No account found with account number " + accountNumberValue);
				alert.setContentText("No modifcation performed. Enter please an existing account Number.");
				alert.showAndWait();
			} else {
				Compte myAccount = lstAccount.get(0);
				numCompteTextField.setText(String.valueOf(myAccount.getId_compte()));
				nomCompteTextField.setText(myAccount.getNomClient());
				dateCreationCompteTextField.setText(myAccount.getDate_compte());
				soldeCompteTextField.setText(String.valueOf(myAccount.getSolde_compte()));
			}

		} else {
			alert = new Alert(AlertType.ERROR);
			alert.initOwner(Main.getPrimaryStage());
			alert.setTitle("Account research");

			alert.setHeaderText("Account number is empty");
			alert.setContentText("Enter please a valid account number.");
			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit details
	 * for a new person.
	 * 
	 * @throws IOException
	 */
	/*
	 * @FXML private void handleNewPerson() { Client tempClient = new Client();
	 * boolean okClicked = Main.affichClientModifDialog(tempClient); if (okClicked)
	 * { Main.getPersonData().add(tempClient); // AfficherDetailsClient(tempClient);
	 * } }
	 * 
	 * /** Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */

	@FXML
	private void handleEditPerson() throws IOException {
		Client selectedPerson = tbClient.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = homeEditButtonListener.editButtonClicked(selectedPerson);
			if (okClicked) {
				AfficherDetailsClient(selectedPerson);
			}

		} else { // Nothing selected. Alert alert = new Alert(AlertType.WARNING);
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(Main.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	@FXML
	private void handleAddNewPerson() throws IOException {
		Client newClient = new Client();
		System.out.println("dsdss");
		boolean newClicked = homeAddButtonListener.addButtonClicked(newClient);
		if (newClicked) {
			AfficherDetailsClient(newClient);
			lstClients.add(newClient);

		}
	}

	/**
	 * Set home edit button listener
	 * 
	 * @param connectionListener
	 */
	public void setListener(HomeEditButtonListener homeEditButtonListener) {
		this.homeEditButtonListener = homeEditButtonListener;
	}

	/**
	 * 
	 * Connection Listener interface
	 *
	 */
	public interface HomeEditButtonListener {
		boolean editButtonClicked(Client selectedPerson);
	}

	/**
	 * Set home edit button listener
	 * 
	 * @param connectionListener
	 */
	public void setListener(HomeAddButtonListener homeAddButtonListener) {
		this.homeAddButtonListener = homeAddButtonListener;
	}

	public interface HomeAddButtonListener {

		boolean addButtonClicked(Client newClient);
	}

	public void fillTAbClient() {
		try {
			lstClients = ClientDao.getClients();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbClient.setItems(lstClients);
	}

	public void fillTabOperation() {

		try {
			lstOperations = OperationDao.getOperations();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbOperation.setItems(lstOperations);
	}

}