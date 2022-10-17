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

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 3 oct 2022 - 23:06:23
 */
public class Modificar_Departamento {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM departamentos");

			while (resul.next()) {
				System.out.println("\nId del departamento: " + resul.getInt("iddepartamentos") + "\n" + "Nombre: "
						+ resul.getString("nombreDepartamento") + "\n" + "Ciudad: "
						+ resul.getString("ciudadDepartamento") + "\n------------------");

			}
			System.out.println("Escoge el departamento que vas a modificar: ");
			System.out.print("Id: ");
			int id_dept = Integer.parseInt(br.readLine());
			System.out.println("Que quieres modificar: \n" + "1. Nombre \n" + "2. Ciudad");
			System.out.print("R: ");
			int res_modif = Integer.parseInt(br.readLine());

			switch (res_modif) {
			case 1:
				System.out.println("Escribe el nuevo nombre del departamento : ");
				System.out.print("Nombre: ");
				String nombre = br.readLine();
				sql = "UPDATE departamentos SET nombreDepartamento = ? WHERE iddepartamentos = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setInt(2, id_dept);
				ps.executeUpdate();
				System.out.println("Se ha modicado el nombre del departamento en la base de datos");
				break;
			case 2:
				System.out.println("Escribe la nueva ciudad del departamento: ");
				System.out.print("R: ");
				String ciudad = br.readLine();
				sql = "UPDATE departamentos SET ciudadDepartamento = ? WHERE iddepartamentos = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, ciudad);
				ps.setInt(2, id_dept);
				if (ps.executeUpdate() > 0) {
					System.out.println("Se ha modicado la ciudad del departamento en la base de datos");
				} else {
					System.out.println("No existe ese departamento, prueba con uno que si " + "\uD83D\uDE09");
				}

				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Tiene que ser un numero");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		} catch (SQLException e) {
			System.out.println("No existe ese departamento, prueba con uno que si " + "\uD83D\uDE09");
		}
	}

}
