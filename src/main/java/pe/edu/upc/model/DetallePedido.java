package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetallePedido")
public class DetallePedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;

	@ManyToOne
	@JoinColumn(name = "idPedido", nullable = false)
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "idComida", nullable = false)
	private Comida comida;

	public DetallePedido() {
		super();
	}

	public DetallePedido(int idDetallePedido, Pedido pedido, Comida comida) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.pedido = pedido;
		this.comida = comida;
	}

	public int getIdDetallePedido() {
		return idDetallePedido;
	}

	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Comida getComida() {
		return comida;
	}

	public void setComida(Comida comida) {
		this.comida = comida;
	}

}
