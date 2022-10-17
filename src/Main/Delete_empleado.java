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
 * @date 3 oct 2022 - 19:50:30
 */
public class Delete_empleado {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleados");
			while (resul.next()) {
				System.out.println("Id del empleado: " + resul.getInt(1) + "\n " + "Apellido: "
						+ resul.getString("apellidoEmpleados") + "\n " + "Cargo: " + resul.getString(3));
			}
			System.out.println("Escribe el id del empleado que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			sql = "DELETE FROM empleados where idempleados = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idborrar);
			ps.executeUpdate();
			while (resul.next()) {
				System.out.println("Id del empleado: " + resul.getInt(1) + "\n " + "Apellido: " + resul.getString(2)
						+ "\n " + "Cargo: " + resul.getString(3));
			}
			System.out.println("Se ha borrado al empleado de la base de datos!");
			Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");
			Statement sentencia2 = (Statement) conexion.createStatement();

			ResultSet resul2 = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleados");
			while (resul2.next()) {
				System.out.println("Id del empleado: " + resul2.getInt(1) + "\n " + "Apellido: " + resul2.getString(2)
						+ "\n " + "Cargo: " + resul2.getString(3));
			}
			resul.close();// Cerrar ResultSet
			resul2.close();
			sentencia.close();
			sentencia2.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Tiene que ser un numero!");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
