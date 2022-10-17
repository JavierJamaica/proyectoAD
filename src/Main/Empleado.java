/**
 * 
 */
package Main;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 3 oct 2022 - 19:09:58
 */
public class Empleado {
	private String apellido;
	private String oficio;
	private double salario;
	private int departamento;

	public Empleado(String apellido, String oficio, double salario, int idDepart) {
		super();
		this.apellido = apellido;
		this.oficio = oficio;
		this.salario = salario;
		this.departamento = idDepart;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [apellido=" + apellido + ", oficio=" + oficio + ", salario=" + salario + ", departamento="
				+ departamento + "]";
	}

}
