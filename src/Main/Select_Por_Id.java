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
 * @date 4 oct 2022 - 0:05:45
 */
public class Select_Por_Id {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		String sql2;
		PreparedStatement ps2;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");

			System.out.println("Pon el id del empleado que quieres ver: ");
			System.out.print("Id: ");
			int id_em = Integer.parseInt(br.readLine());

			sql = "SELECT * FROM empleados WHERE idempleados = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, id_em);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("\nId del empleado: " + rs.getInt(1) + "\n" + "Apellido: " + rs.getString(2) + "\n"
						+ "Cargo: " + rs.getString(3) + "\n" + "Salario: " + rs.getString("salario") + "\n"
						+ "Departamento: " + rs.getInt("idDepartamentos"));
			} else {
				System.out.println("Empleado no existe");
			}

			System.out.println("\nPon el id del departamento que quieres ver: ");
			System.out.print("Id: ");
			int id_dept = Integer.parseInt(br.readLine());

			sql2 = "SELECT * FROM departamentos WHERE iddepartamentos = ?";
			ps2 = conexion.prepareStatement(sql2);
			ps2.setInt(1, id_dept);
			ResultSet rs2 = ps2.executeQuery();
			if (rs2.next()) {
				System.out.println("\nId del empldepartamento: " + rs2.getInt("iddepartamentos") + "\n" + "Nombre: "
						+ rs2.getString("nombreDepartamento") + "\n" + "Ciudad: "
						+ rs2.getString("ciudadDepartamento"));
			} else {
				System.out.println("Departamento no existe");
			}
			rs.close();
			rs2.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		} catch (NumberFormatException e) {
			System.out.println("Tiene que ser un numero!");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}
