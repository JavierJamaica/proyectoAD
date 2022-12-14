/**
 * 
 */
package Main;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 31 oct 2022 - 22:43:29
 */
public class Cliente {
	private int id;
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private String profesion;

	public Cliente(int id, String dni, String nombre, String apellidos, int edad, String profesion) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.profesion = profesion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	@Override
	public String toString() {
		return "Id: " + id + ", dni: " + dni + ", nombre: " + nombre + ", apellidos: " + apellidos + ", edad: " + edad
				+ ", profesion: " + profesion;
	}

}
