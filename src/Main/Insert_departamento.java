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
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 3 oct 2022 - 19:45:34
 */
public class Insert_departamento {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Departamento dep;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			System.out.println("Escribe el nombre del departamento: ");
			System.out.print("Nombre: ");
			String nombre = br.readLine();
			System.out.println("Escribe la ciudad del departamento: ");
			System.out.print("Ciudad: ");
			String ciudad = br.readLine();

			dep = new Departamento(nombre, ciudad);
			sql = "INSERT INTO `ejercicio6`.`departamentos` (`nombreDepartamento`, `ciudadDepartamento`) VALUES (?, ?)";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, ciudad);
			ps.executeUpdate();
			sentencia.close();
			conexion.close();// Cerrar conexion
			System.out.println("Se ha agregado el departamento a la base de datos");

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
