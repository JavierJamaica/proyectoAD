/**
 * 
 */
package Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 26 sept 2022 - 21:48:02
 */
public class Select_General {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejercicio6", "root",
					"12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			Statement sentencia2 = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleados");
			ResultSet resul2 = ((java.sql.Statement) sentencia2).executeQuery("SELECT * FROM departamentos");
			while (resul.next()) {
				System.out.println("\nId del empleado: " + resul.getInt(1) + "\n" + "Apellido: "
						+ resul.getString("apellidoEmpleados") + "\n" + "Cargo: " + resul.getString(3) + "\n"
						+ "Salario: " + resul.getString("salario") + "\n" + "Departamento: "
						+ resul.getInt("idDepartamentos") + "\n" + "--------------");
			}
			System.out.println("-------------------------------");
			while (resul2.next()) {
				System.out.println("\nId del departamento: " + resul2.getInt(1) + "\n " + "Nombre: "
						+ resul2.getString(2) + "\n " + "Ciudad: " + resul2.getString(3) + "\n" + "--------------");
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
		}

	}
}