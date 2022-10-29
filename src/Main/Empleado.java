/**
 * 
 */
package Main;

import java.util.Date;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 29 oct 2022 - 18:54:49
 */
public class Empleado {
	private String dni;
	private String nombre;
	private String primerApellido;
	private Date fechaNacimientoEmpleado;
	private Date fechaContratacionEmpleado;
	private String nacionalidad;
	private String cargo;
	

	public Empleado(String dni, String nombre, String primerApellido, Date fechaNacimientoEmpleado,
			Date fechaContratacionEmpleado, String nacionalidad, String cargo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
		this.fechaContratacionEmpleado = fechaContratacionEmpleado;
		this.nacionalidad = nacionalidad;
		this.cargo = cargo;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public Date getFechaNacimientoEmpleado() {
		return fechaNacimientoEmpleado;
	}

	public void setFechaNacimientoEmpleado(Date fechaNacimientoEmpleado) {
		this.fechaNacimientoEmpleado = fechaNacimientoEmpleado;
	}

	public Date getFechaContratacionEmpleado() {
		return fechaContratacionEmpleado;
	}

	public void setFechaContratacionEmpleado(Date fechaContratacionEmpleado) {
		this.fechaContratacionEmpleado = fechaContratacionEmpleado;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", fechaNacimientoEmpleado=" + fechaNacimientoEmpleado + ", fechaContratacionEmpleado="
				+ fechaContratacionEmpleado + ", nacionalidad=" + nacionalidad + ", cargo=" + cargo + "]";
	}

}
