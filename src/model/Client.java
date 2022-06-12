package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {

	// Declaration des attributs d'un objet de type Client
	private IntegerProperty idClient;
	private StringProperty nomClient;
	private StringProperty prenomClient;
	private StringProperty villeClient;
	private StringProperty adresseClient;
	private StringProperty telClient;
	private StringProperty emailClient;
	private StringProperty dateClient;
	
	
	// Constructeurs
	public Client() {
		this(0, null, null, null, null, null, null, null);
	}

	public Client(int idClient, String nomClient, String prenomClient, String villeClient, String adresseClient,
			String telClient, String emailClient, String dateClient) {

		this.idClient = new SimpleIntegerProperty(idClient);
		this.nomClient = new SimpleStringProperty(nomClient);
		this.prenomClient = new SimpleStringProperty(prenomClient);
		this.villeClient = new SimpleStringProperty(villeClient);
		this.adresseClient = new SimpleStringProperty(adresseClient);
		this.telClient = new SimpleStringProperty(telClient);
		this.emailClient = new SimpleStringProperty(emailClient);
		this.dateClient = new SimpleStringProperty(dateClient);
	}

	public Client(int idClient, String nomClient, String prenomClient) {

		this.idClient = new SimpleIntegerProperty(idClient);
		this.nomClient = new SimpleStringProperty(nomClient);
		this.prenomClient = new SimpleStringProperty(prenomClient);

	}

	// Getters & setters
	public final IntegerProperty idClientProperty() {
		return this.idClient;
	}

	public final int getIdClient() {
		return this.idClientProperty().get();
	}

	public final void setIdClient(final int idClient) {
		this.idClientProperty().set(idClient);
	}

	public final StringProperty nomClientProperty() {
		return this.nomClient;
	}

	public final String getNomClient() {
		return this.nomClientProperty().get();
	}

	public final void setNomClient(final String nomClient) {
		this.nomClientProperty().set(nomClient);
	}

	public final StringProperty prenomClientProperty() {
		return this.prenomClient;
	}

	public final String getPrenomClient() {
		return this.prenomClientProperty().get();
	}

	public final void setPrenomClient(final String prenomClient) {
		this.prenomClientProperty().set(prenomClient);
	}

	public final StringProperty villeClientProperty() {
		return this.villeClient;
	}

	public final String getVilleClient() {
		return this.villeClientProperty().get();
	}

	public final void setVilleClient(final String villeClient) {
		this.villeClientProperty().set(villeClient);
	}

	public final StringProperty adresseClientProperty() {
		return this.adresseClient;
	}

	public final String getAdresseClient() {
		return this.adresseClientProperty().get();
	}

	public final void setAdresseClient(final String adresseClient) {
		this.adresseClientProperty().set(adresseClient);
	}

	public final StringProperty telClientProperty() {
		return this.telClient;
	}

	public final String getTelClient() {
		return this.telClientProperty().get();
	}

	public final void setTelClient(final String telClient) {
		this.telClientProperty().set(telClient);
	}

	public final StringProperty emailClientProperty() {
		return this.emailClient;
	}

	public final String getEmailClient() {
		return this.emailClientProperty().get();
	}

	public final void setEmailClient(final String emailClient) {
		this.emailClientProperty().set(emailClient);
	}

	public final StringProperty dateClientProperty() {
		return this.dateClient;
	}

	public final String getDateClient() {
		return this.dateClientProperty().get();
	}

	public final void setDateClient(final String localDate) {
		this.dateClientProperty().set(localDate);
	}
	///



}