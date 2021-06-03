package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Plan")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idPlan;

	@Column(name = "nombrePlan", nullable = false, length = 12)
	public String nombrePlan;

	public int creditos;
	public float precio;

	public Plan() {
		super();
	}

	public Plan(int idPlan, String nombrePlan, int creditos, float precio) {
		super();
		this.idPlan = idPlan;
		this.nombrePlan = nombrePlan;
		this.creditos = creditos;
		this.precio = precio;
	}

	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public String getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

}
