package application;

import java.io.IOException;
import java.net.URL;

import controllers.AccueilController;
import controllers.LoginController;
import controllers.ModifController;
import controllers.AccueilController.HomeAddButtonListener;
import controllers.AccueilController.HomeEditButtonListener;
import controllers.LoginController.ConnectionListener;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Client;

public class Main extends Application {

	/*
	 * @FXML private TableView<Client> tbClient;
	 * 
	 * @FXML private TableView<Compte> tbCompte;
	 * 
	 * 
	 */
	private Stage primaryStage;

	private AnchorPane root;

	private AnchorPane loginWin;

	private static FXMLLoader fxmlLoader;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("App Bank");
		loginUser();
	}

	public void loginUser() {
		try {
			URL fxmlURL = getClass().getResource("/view/login.fxml");
			
			System.out.println(fxmlURL);
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Parent loginWin = fxmlLoader.load();
			LoginController controller = fxmlLoader.getController();
			controller.setListener(new connectionButtonListenerImplementation());

			Scene scene = new Scene((Parent) loginWin);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ---------------- edit/delete/add

	private boolean affichClientModifDialog(Client client) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			URL fxmlURL = getClass().getResource("/view/ClientModif.fxml");
			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);

			Parent modifWind = fxmlLoader.load();
			Scene secondScene = new Scene((Parent) modifWind);
//			// Create the dialog Stage.

			Stage newWindow = new Stage();
			newWindow.setTitle("Modifier Client");
			newWindow.initModality(Modality.WINDOW_MODAL);
			// newWindow.initOwner(newWindow);
			newWindow.setScene(secondScene);

			// Set the person into the controller.
			ModifController controller = fxmlLoader.getController();
			controller.setDialogStage(newWindow);
			controller.setClient(client);

			// Show the dialog and wait until the user closes it
			newWindow.showAndWait();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// -------------------------
	/**
	 * The data as an observable list of Persons.
	 */

	// ----------------

	// -----------------fin-----------------\\

	// ----------------MAIN------------------\\
	public static void main(String[] args) {
		launch(args);

	}
	// -----------------fin-----------------\\

	public static Window getPrimaryStage() {
		// TODO Auto-generated method stub
		return null;
	}

	public class connectionButtonListenerImplementation implements ConnectionListener {

		@Override
		public void connectionButtonClicked() {
			try {
				URL fxmlURL = getClass().getResource("/view/Accueil.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				Parent accueilWin = fxmlLoader.load();
				AccueilController accueilController = fxmlLoader.getController();
				accueilController.setListener(new HomeEditButtonListenerImplementation());
				accueilController.setListener(new HomeAddButtonListenerImplementation());

				Scene scene = new Scene((Parent) accueilWin);
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public class HomeEditButtonListenerImplementation implements HomeEditButtonListener {

		@Override
		public boolean editButtonClicked(Client selectedPerson) {
			return affichClientModifDialog(selectedPerson);
		}

	}

	// not done yet , 149-

	public class HomeAddButtonListenerImplementation implements HomeAddButtonListener {

		@Override
		public boolean addButtonClicked(Client newClient) {
			return affichClientModifDialog(newClient);
		}

	}// not done yet

}
