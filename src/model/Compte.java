package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Compte {

	private IntegerProperty id_compte;
	private IntegerProperty idClient;
	private IntegerProperty solde_compte;
	// details
	private StringProperty nomClient;
	private StringProperty prenomClient;
	private StringProperty date_compte;

	public Compte(int idCompte, int soldeCompte, int idClient, String nomClient, String prenomClient, String dateCompte) {
		super();

		this.id_compte = new SimpleIntegerProperty(idCompte);
		this.solde_compte = new SimpleIntegerProperty(soldeCompte);
		this.idClient = new SimpleIntegerProperty(idClient);
		// details
		this.nomClient = new SimpleStringProperty(nomClient);
		this.prenomClient = new SimpleStringProperty(prenomClient);
		this.date_compte = new SimpleStringProperty(dateCompte);

	}

	public final IntegerProperty id_compteProperty() {
		return this.id_compte;
	}

	public final int getId_compte() {
		return this.id_compteProperty().get();
	}

	public final void setId_compte(final int id_compte) {
		this.id_compteProperty().set(id_compte);
	}

	public final IntegerProperty idClientProperty() {
		return this.idClient;
	}

	public final int getIdClient() {
		return this.idClientProperty().get();
	}

	public final void setIdClient(final int idClient) {
		this.idClientProperty().set(idClient);
	}

	public final IntegerProperty solde_compteProperty() {
		return this.solde_compte;
	}

	public final int getSolde_compte() {
		return this.solde_compteProperty().get();
	}

	public final void setSolde_compte(final int solde_compte) {
		this.solde_compteProperty().set(solde_compte);
	}

	// Details
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

	public final StringProperty date_compteProperty() {
		return this.date_compte;
	}

	public final String getDate_compte() {
		return this.date_compteProperty().get();
	}

	public final void setDate_compte(final String date_compte) {
		this.date_compteProperty().set(date_compte);
	}

	@Override
	public String toString() {
		return "Compte [id_compte=" + id_compte + ", idClient=" + idClient + ", solde_compte=" + solde_compte
				+ ", nomClient=" + nomClient + ", prenomClient=" + prenomClient + ", date_compte=" + date_compte + "]";
	}

}
