package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Tarjeta")
public class Tarjeta implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idTarjeta;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@Column(name = "nombreTitular", nullable = false, length = 25)
	private String nombreTitular;

	private int numeroTarjeta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaVencimiento", nullable = false, length = 45)
    @DateTimeFormat(pattern = "yyy-MM-dd")
	private Date fechaVencimiento;
	private int cvv;

	public Tarjeta() {
		super();
	}

	public Tarjeta(int idTarjeta, Usuario usuario, String nombreTitular, int numeroTarjeta, Date fechaVencimiento,
			int cvv) {
		super();
		this.idTarjeta = idTarjeta;
		this.usuario = usuario;
		this.nombreTitular = nombreTitular;
		this.numeroTarjeta = numeroTarjeta;
		this.fechaVencimiento = fechaVencimiento;
		this.cvv = cvv;
	}

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public int getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(int numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

}