/**
 * 
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 3 oct 2022 - 19:00:54
 */
public class Insert_empleado {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Empleado em;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM departamentos");

			System.out.println("Escribe el apellido del empleado: ");
			System.out.print("Apellido: ");
			String apellido = br.readLine();
			System.out.println("Escribe el cargo del empleado: ");
			System.out.print("R: ");
			String cargo = br.readLine();
			System.out.println("Escribe el salario del empleado: ");
			System.out.print("R: ");
			double salario = Double.parseDouble(br.readLine());

			System.out.println("Escoge el departamento al cual va a ir: ");
			while (resul.next()) {
				System.out.println("Id del departamento: " + resul.getInt(1) + "\n " + "Nombre: " + resul.getString(2)
						+ "\n " + "Ciudad: " + resul.getString(3));
			}

			System.out.print("R:");
			int idDepart = Integer.parseInt(br.readLine());

			em = new Empleado(apellido, cargo, salario, idDepart);
			sql = "INSERT INTO `ejercicio6`.`empleados` (`apellidoEmpleados`, `oficioEmpleados`, "
					+ "`salario`, `idDepartamentos`) VALUES (?, ?, ?, ?)";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, em.getApellido());
			ps.setString(2, em.getOficio());
			ps.setDouble(3, em.getSalario());
			ps.setInt(4, em.getDepartamento());
			ps.executeUpdate();
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
			System.out.println("Se ha agregado el empleado a la base de datos");
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Tiene que ser un numero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}

	}

}
