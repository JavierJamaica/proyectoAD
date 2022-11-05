/**
 * 
 */
package Main;

import java.util.Date;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 31 oct 2022 - 23:26:24
 */
public class HorarioVisita {
	private Visita visita;
	private Cliente cliente;
	private Date fecha;

	public HorarioVisita(Visita visita, Cliente cliente, Date fecha) {
		super();
		this.visita = visita;
		this.cliente = cliente;
		this.fecha = fecha;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "HorarioVisita [visita=" + visita + ", cliente=" + cliente + ", fecha=" + fecha + "]";
	}

}
