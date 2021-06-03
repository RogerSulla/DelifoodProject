package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Comida")
public class Comida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComida;

	@Column(name = "nombreComida", nullable = false, length = 25)
	private String nombreComida;

	@Column(name = "ingredientes", nullable = false, length = 280)
	private String ingredientes;

	private int kcal;
	private int grasa;
	private int carbohidratos;
	private int proteinas;

	public Comida() {
		super();
	}

	public Comida(int idComida, String nombreComida, String ingredientes, int kcal, int grasa, int carbohidratos,
			int proteinas) {
		super();
		this.idComida = idComida;
		this.nombreComida = nombreComida;
		this.ingredientes = ingredientes;
		this.kcal = kcal;
		this.grasa = grasa;
		this.carbohidratos = carbohidratos;
		this.proteinas = proteinas;
	}

	public int getIdComida() {
		return idComida;
	}

	public void setIdComida(int idComida) {
		this.idComida = idComida;
	}

	public String getNombreComida() {
		return nombreComida;
	}

	public void setNombreComida(String nombreComida) {
		this.nombreComida = nombreComida;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	public int getGrasa() {
		return grasa;
	}

	public void setGrasa(int grasa) {
		this.grasa = grasa;
	}

	public int getCarbohidratos() {
		return carbohidratos;
	}

	public void setCarbohidratos(int carbohidratos) {
		this.carbohidratos = carbohidratos;
	}

	public int getProteinas() {
		return proteinas;
	}

	public void setProteinas(int proteinas) {
		this.proteinas = proteinas;
	}

}
