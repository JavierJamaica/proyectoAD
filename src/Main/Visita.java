/**
 * 
 */
package Main;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 24 oct 2022 - 19:21:37
 */
public class Visita {
	private int id;
	private String nombre;
	private String puntoPartida;
	private String cursoAcademico;
	private String tematica;
	private double coste;
	private int maxClientes;
	private int empleadoId;

	public Visita(int id, String nombre, String puntoPartida, String cursoAcademico, String tematica, double coste,
			int maxClientes, int empleadoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.puntoPartida = puntoPartida;
		this.cursoAcademico = cursoAcademico;
		this.tematica = tematica;
		this.coste = coste;
		this.maxClientes = maxClientes;
		this.empleadoId = empleadoId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPuntoPartida() {
		return puntoPartida;
	}

	public void setPuntoPartida(String puntoPartida) {
		this.puntoPartida = puntoPartida;
	}

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	}

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getMaxClientes() {
		return maxClientes;
	}

	public void setMaxClientes(int maxClientes) {
		this.maxClientes = maxClientes;
	}

	public int getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(int empleadoId) {
		this.empleadoId = empleadoId;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", nombre: " + nombre + ", punto de partida: " + puntoPartida + ", curso academico: "
				+ cursoAcademico + ", tematica: " + tematica + ", coste: " + coste + ", numero maximo de clientes: "
				+ maxClientes + ", empleado asignado: " + empleadoId;
	}

}
