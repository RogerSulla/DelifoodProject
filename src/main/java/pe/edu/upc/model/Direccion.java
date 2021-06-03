package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Direccion")
public class Direccion implements Serializable {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDireccion;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@Column(name = "direccion", nullable = false, length = 45)
	private String direccion;
	@Column(name = "referencia", nullable = false, length = 45)
	private String referencia;
	@Column(name = "instruccionesEntrega", nullable = false, length = 45)
	private String instruccionesEntrega;

    public Direccion() {
		super();
	}

	public Direccion(int idDireccion, Usuario usuario, String direccion, String referencia,
			String instruccionesEntrega) {
		super();
		this.idDireccion = idDireccion;
		this.usuario = usuario;
		this.direccion = direccion;
		this.referencia = referencia;
		this.instruccionesEntrega = instruccionesEntrega;
	}

    public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getInstruccionesEntrega() {
		return instruccionesEntrega;
	}

	public void setInstruccionesEntrega(String instruccionesEntrega) {
		this.instruccionesEntrega = instruccionesEntrega;
	}
}
