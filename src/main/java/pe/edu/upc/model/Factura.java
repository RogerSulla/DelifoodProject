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
@Table(name = "Factura")
public class Factura implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int idFactura;

	@ManyToOne
	@JoinColumn(name = "idPlan", nullable = false)
	public Plan plan;

	@ManyToOne
	@JoinColumn(name = "idTarjeta", nullable = false)
	public Tarjeta tarjeta;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaFacturacion", nullable = false, length = 45)
    @DateTimeFormat(pattern = "yyy-MM-dd")
	public Date fechaFacturacion;
    
	public int tipoComprobante;

	@Column(name = "tipoIdentificacion", nullable = false, length = 10)
	public String tipoIdentificacion;
	public int numeroIdentificacion;
	@Column(name = "nombresFacturacion", nullable = false, length = 25)
	public String nombresFacturacion;

	public Factura() {
		super();
	}

	public Factura(int idFactura, Plan plan, Tarjeta tarjeta, Date fechaFacturacion, int tipoComprobante,
			String tipoIdentificacion, int numeroIdentificacion, String nombresFacturacion) {
		super();
		this.idFactura = idFactura;
		this.plan = plan;
		this.tarjeta = tarjeta;
		this.fechaFacturacion = fechaFacturacion;
		this.tipoComprobante = tipoComprobante;
		this.tipoIdentificacion = tipoIdentificacion;
		this.numeroIdentificacion = numeroIdentificacion;
		this.nombresFacturacion = nombresFacturacion;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	public int getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(int tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getNombresFacturacion() {
		return nombresFacturacion;
	}

	public void setNombresFacturacion(String nombresFacturacion) {
		this.nombresFacturacion = nombresFacturacion;
	}

}
