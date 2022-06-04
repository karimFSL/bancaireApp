package controllers;

import java.io.IOException;

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

public class AccueilController {

	// ----client
	// _______la base
	@FXML
	private TableView<Client> tbClient;
	@FXML
	private TableColumn<Client, String> clNom;
	@FXML
	private TableColumn<Client, String> clPrenom;
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
	private TextField tfNom;
	@FXML
	private TextField tfPrenom;
	@FXML
	private Button butfind;

	private FXMLLoader fxmlLoader;

	// operation
	@FXML
	private TableView<Operation> tbOperation;
	@FXML
	private TableColumn<Operation, Integer> IdOp;
	@FXML
	private TableColumn<Operation, Integer> typeOp;
	@FXML
	private TableColumn<Operation, String> dateOp;
	@FXML
	private TableColumn<Operation, Integer> valeurOp;

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

		// intialise compte
//		txtIdCmp.setCellValueFactory(cellData -> cellData.getValue().id_compteProperty().asObject());
//		txtSolde.setCellValueFactory(cellData -> cellData.getValue().solde_compteProperty().asObject());
//		txtIdCl.setCellValueFactory(cellData -> cellData.getValue().idClientProperty().asObject());

		// afficher details ompte

		// butfind.setCellValueFactory(cellData -> cellData.getValue() );

		// initialise operation
		IdOp.setCellValueFactory(cellData -> cellData.getValue().id_OperationProperty().asObject());
		typeOp.setCellValueFactory(cellData -> cellData.getValue().type_OpProperty().asObject());
		dateOp.setCellValueFactory(cellData -> cellData.getValue().date_OpProperty());
		valeurOp.setCellValueFactory(cellData -> cellData.getValue().valeur_OpProperty().asObject());

		// labels

		// client
		tbClient.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> AfficherDetailsClient(newValue));

		// compte
//		tbCompte.getSelectionModel().selectedItemProperty()
//				.addListener((observable, oldValue, newValue) -> AfficherDetailsCompte(newValue));

		fillTAbClient();
		// fillTabCompte();
		fillTabOperation();
	}

	// controle partie client
	private ObservableList<Client> lstClients = FXCollections.observableArrayList();

	public void fillTAbClient() {
		ClientDao cldao = new ClientDao();
		lstClients = cldao.trouverClients();
		tbClient.setItems(lstClients);
	}

	// controle partie compte
	private ObservableList<Compte> lstComptes = FXCollections.observableArrayList();

	public void fillTabCompte() {
		CompteDao cmpdao = new CompteDao();
		lstComptes = cmpdao.trouverComptes();
		tbCompte.setItems(lstComptes);
	}

	// controle partie operation
	private ObservableList<Operation> lstOperations = FXCollections.observableArrayList();
	private Stage dialogStage;

	public void fillTabOperation() {
		OperationDao opdao = new OperationDao();
		lstOperations = opdao.trouverOperations();
		tbOperation.setItems(lstOperations);
	}

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
	// --------/sec1

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

}