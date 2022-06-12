package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Operation {

	private IntegerProperty id_Operation;
	private StringProperty type_Op;
	private StringProperty date_Op;
	private StringProperty valeur_Op;

	public Operation(int idOperation, String typeOperation, String dateOperation, String valeurOperation) {
		// TODO Auto-generated constructor stub
		super();

		this.id_Operation = new SimpleIntegerProperty(idOperation);
		this.type_Op = new SimpleStringProperty(typeOperation);
		this.date_Op = new SimpleStringProperty(dateOperation);
		this.valeur_Op = new SimpleStringProperty(valeurOperation);
	}

	public final IntegerProperty id_OperationProperty() {
		return this.id_Operation;
	}

	public final int getId_Operation() {
		return this.id_OperationProperty().get();
	}

	public final void setId_Operation(final int id_Operation) {
		this.id_OperationProperty().set(id_Operation);
	}

	public final StringProperty type_OpProperty() {
		return this.type_Op;
	}

	public final String getType_Op() {
		return this.type_Op.get();
	}

	public final void setType_Op(final String type_Op) {
		this.type_OpProperty().set(type_Op);
	}

	public final StringProperty date_OpProperty() {
		return this.date_Op;
	}

	public final String getDate_Op() {
		return this.date_OpProperty().get();
	}

	public final void setDate_Op(final String date_Op) {
		this.date_OpProperty().set(date_Op);
	}

	public final StringProperty valeur_OpProperty() {
		return this.valeur_Op;
	}

	public final String getValeur_Op() {
		return this.valeur_OpProperty().get();
	}

	public final void setValeur_Op(final String valeur_Op) {
		this.valeur_OpProperty().set(valeur_Op);
	}

}
