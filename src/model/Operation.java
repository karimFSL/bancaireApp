package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Operation {

	private IntegerProperty id_Operation;
	private IntegerProperty type_Op;
	private StringProperty date_Op;
	private IntegerProperty valeur_Op;

	public Operation(int int1, int int2, String string, int int3) {
		// TODO Auto-generated constructor stub
		super();

		this.id_Operation = new SimpleIntegerProperty(int1);
		this.type_Op = new SimpleIntegerProperty(int2);
		this.date_Op = new SimpleStringProperty(string);
		this.valeur_Op = new SimpleIntegerProperty(int3);
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

	public final IntegerProperty type_OpProperty() {
		return this.type_Op;
	}

	public final int getType_Op() {
		return this.type_OpProperty().get();
	}

	public final void setType_Op(final int type_Op) {
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

	public final IntegerProperty valeur_OpProperty() {
		return this.valeur_Op;
	}

	public final int getValeur_Op() {
		return this.valeur_OpProperty().get();
	}

	public final void setValeur_Op(final int valeur_Op) {
		this.valeur_OpProperty().set(valeur_Op);
	}

}
