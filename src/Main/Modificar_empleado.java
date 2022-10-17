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
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 3 oct 2022 - 20:34:35
 */
public class Modificar_empleado {

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
				System.out.println("Id del empleado: " + resul.getInt(1) + "\n" + "Apellido: " + resul.getString(2)
						+ "\n" + "Cargo: " + resul.getString(3) + "\n" + "Salario: " + resul.getDouble("salario") + "\n"
						+ "Departamento: " + resul.getInt("idDepartamentos") + "\n" + "------------------");

			}
			System.out.println("Escoge el empleado que vas a modificar: ");
			System.out.print("Id: ");
			int id_em = Integer.parseInt(br.readLine());
			System.out.println(
					"Que quieres modificar: \n" + "1. Apellido \n" + "2. Cargo\n" + "3. Salario\n" + "4. Departamento");
			System.out.print("R: ");
			int res_modif = Integer.parseInt(br.readLine());

			switch (res_modif) {
			case 1:
				System.out.println("Escribe el nuevo apellido del empleado : ");
				System.out.print("Apellido: ");
				String apellido = br.readLine();
				sql = "UPDATE empleados SET apellidoEmpleados = ? WHERE idempleados = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, apellido);
				ps.setInt(2, id_em);
				ps.executeUpdate();
				System.out.println("Se ha modicado el apellido del empleado en la base de datos");
				break;
			case 2:
				System.out.println("Escribe el nuevo cargo del empleado: ");
				System.out.print("R: ");
				String cargo = br.readLine();
				sql = "UPDATE empleados SET oficioEmpleados = ? WHERE idempleados = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, cargo);
				ps.setInt(2, id_em);
				ps.executeUpdate();
				System.out.println("Se ha modicado el oficio del empleado en la base de datos");
				break;
			case 3:
				System.out.println("Escribe el salario del empleado: ");
				System.out.print("R: ");
				double salario = Double.parseDouble(br.readLine());
				sql = "UPDATE empleados SET salario = ? WHERE idempleados = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDouble(1, salario);
				ps.setInt(2, id_em);
				ps.executeUpdate();
				System.out.println("Se ha modicado el salario del empleado en la base de datos");
				break;
			case 4:
				Statement sentencia2 = (Statement) conexion.createStatement();
				ResultSet resul2 = ((java.sql.Statement) sentencia2).executeQuery("SELECT * FROM departamentos");

				while (resul2.next()) {
					System.out.println(
							"\nId del departamento: " + resul2.getInt(1) + "\n" + "Nombre: " + resul2.getString(2)
									+ "\n" + "Ciudad: " + resul2.getString(3) + "\n" + "------------------");

				}
				System.out.println("Escoge el nuevo departamento");
				System.out.print("R:");
				int idDepart = Integer.parseInt(br.readLine());
				sql = "UPDATE empleados SET idDepartamentos = ? WHERE idempleados = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDouble(1, idDepart);
				ps.setInt(2, id_em);
				ps.executeUpdate();
				System.out.println("Se ha modicado el departamento del empleado en la base de datos");
				break;
			default:
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
		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("No existe ese departamento, prueba con uno que si " + "\uD83D\uDE09");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}

	}

}
