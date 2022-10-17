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
 * @date 3 oct 2022 - 20:17:27
 */
public class Delete_departamentos {
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
				System.out.println("Id del departamento: " + resul.getInt("iddepartamentos") + "\n " + "Nombre: "
						+ resul.getString("nombreDepartamento") + "\n " + "Ciudad: "
						+ resul.getString("ciudadDepartamento"));
			}
			System.out.println("Escribe el id del departamento que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			sql = "DELETE FROM departamentos where iddepartamentos = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idborrar);
			ps.executeUpdate();
			while (resul.next()) {
				System.out.println("Id del departamento: " + resul.getInt(1) + "\n " + "Nombre: " + resul.getString(2)
						+ "\n " + "Ciudad: " + resul.getString(3));
			}
			System.out.println("Se ha borrado al departamento de la base de datos!");
			Connection conexion2 = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");
			Statement sentencia2 = (Statement) conexion.createStatement();

			ResultSet resul2 = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM departamentos");
			while (resul2.next()) {
				System.out.println("Id del departamento: " + resul2.getInt(1) + "\n " + "Nombre: " + resul2.getString(2)
						+ "\n " + "Ciudad: " + resul2.getString(3));
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
