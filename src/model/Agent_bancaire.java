package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agent_bancaire {

	private IntegerProperty idPersonnel;
	private StringProperty personnelEmail;
	private StringProperty personnelPassword;
	
	
	   //Constructor
    public Agent_bancaire() {
        this.personnelEmail = new SimpleStringProperty();
        this.personnelPassword = new SimpleStringProperty();
    
    }
    
	public Agent_bancaire(IntegerProperty idPersonnel, StringProperty personnelEmail, StringProperty personnelPassword) {
		super();
		this.idPersonnel = idPersonnel;
		this.personnelEmail = personnelEmail;
		this.personnelPassword = personnelPassword;
	}

	public Agent_bancaire(String emailperso, String passwordperso) {
		// TODO Auto-generated constructor stub
		this.personnelEmail = new SimpleStringProperty(emailperso);
		this.personnelPassword = new SimpleStringProperty(passwordperso);
	}


	public final IntegerProperty idPersonnelProperty() {
		return this.idPersonnel;
	}

	public final int getIdPersonnel() {
		return this.idPersonnelProperty().get();
	}

	public final void setIdPersonnel(final int idPersonnel) {
		this.idPersonnelProperty().set(idPersonnel);
	}

	public final StringProperty personnelEmailProperty() {
		return this.personnelEmail;
	}

	public final String getPersonnelEmail() {
		return this.personnelEmailProperty().get();
	}

	public final void setPersonnelEmail(final String personnelEmail) {
		this.personnelEmailProperty().set(personnelEmail);
	}

	public final StringProperty personnelPasswordProperty() {
		return this.personnelPassword;
	}

	public final String getPersonnelPassword() {
		return this.personnelPasswordProperty().get();
	}

	public final void setPersonnelPassword(final String personnelPassword) {
		this.personnelPasswordProperty().set(personnelPassword);
	}

	@Override
	public String toString() {
		return "Agent_bancaire [personnelEmail=" + personnelEmail.getValue() + ", personnelPassword=" + personnelPassword.getValue() + "]";
	}
}
