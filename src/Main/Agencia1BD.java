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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 17 oct 2022 - 20:49:13
 */
public class Agencia1BD {

	public static void selectEmpleados() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleado");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("Id del empleado: " + resul.getInt("idEmpleado") + "\n" + "Nombre: "
						+ resul.getString("nombreEmpleado") + "\n" + "Primer apellido: "
						+ resul.getString("primerApellidoEmpleado") + "\n" + "Fecha de nacimiento: "
						+ resul.getDate("fechaNacimientoEmpleado") + "\n" + "Fecha de contratacion: "
						+ resul.getDate("fechaContratacionEmpleado") + "\n" + "Nacionalidad: "
						+ resul.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
						+ resul.getString("cargoEmpleado"));

			}
			System.out.println("------------------------------------");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void selectVisitas() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM agencia1.visitaguiada");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("\nNumero de visita: " + resul.getInt("idVisita") + "\n" + "Nombre de la visita: "
						+ resul.getString("nombreVisita") + "\n" + "Punto de partida: "
						+ resul.getString("puntoPartida") + "\n" + "Curso academico: "
						+ resul.getString("cursoAcademico") + "\n" + "Tematica de la visita: "
						+ resul.getString("tematicaVisita") + "\n" + "Coste de la visita: "
						+ resul.getDouble("costeVisita") + "\n" + "Numero maximo de clientes: "
						+ resul.getInt("numMaxClientes") + "\n" + "Empleado asignado: " + resul.getInt("empleadoId")
						+ "\n");

			}
			System.out.println("------------------------------------");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertarEmpleado() throws ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Empleado emple;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleado");

			System.out.println("Escribe el nombre del empleado: ");
			System.out.print("Nombre: ");
			String nombreEmple = br.readLine();
			System.out.println("Escribe el dni del empleado: ");
			System.out.print("Dni: ");
			String dni = br.readLine();
			System.out.println("Escribe el primer apellido: ");
			System.out.print("Primer apellido: ");
			String primerApellido = br.readLine();
			System.out.println("Escribe la fecha de nacimiento ");
			System.out.print("Fecha: ");
			String fechaNacimiento = br.readLine();
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
			Date fechaNacForm = format.parse(fechaNacimiento);
			System.out.println("Escribe la fecha de contratacion ");
			System.out.print("Fecha: ");
			String fechaContratacion = br.readLine();
			SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
			Date fechaContForm = format.parse(fechaContratacion);
			System.out.println("Escribe la nacionalidad del empleado");
			System.out.print("Nacionalidad: ");
			String nacionalidad = br.readLine();
			System.out.println("Escribe el cargo del empleado: ");
			System.out.print("Cargo: ");
			String cargo = br.readLine();
			emple = new Empleado(dni, nombreEmple, primerApellido, fechaNacForm, fechaContForm, nacionalidad, cargo);
			java.sql.Date fechaNacSql = new java.sql.Date(emple.getFechaNacimientoEmpleado().getTime());
			java.sql.Date fechaContSql = new java.sql.Date(emple.getFechaContratacionEmpleado().getTime());
			sql = "INSERT INTO `agencia1`.`empleado` (`dniEmpleado`, `nombreEmpleado`, "
					+ "`primerApellidoEmpleado`, `fechaNacimientoEmpleado`,`fechaContratacionEmpleado`, `nacionalidadEmpleado`,`cargoEmpleado`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, emple.getDni());
			ps.setString(2, emple.getNombre());
			ps.setString(3, emple.getPrimerApellido());
			ps.setDate(4, fechaNacSql);
			ps.setDate(5, fechaContSql);
			ps.setString(6, emple.getNacionalidad());
			ps.setString(7, emple.getCargo());
			ps.executeUpdate();
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
			System.out.println("Se ha agregado el empleado a la base de datos.");
		} catch (ParseException e) {
			System.out.println("Error tiene que ser un formato: año/mes/dia");

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

	public static void insertarVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Visita vis;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleado");

			System.out.println("Escribe el nombre de la visita: ");
			System.out.print("Nombre: ");
			String nombreVis = br.readLine();
			System.out.println("Escribe el punto de partida: ");
			System.out.print("Punto de partida: ");
			String puntoPar = br.readLine();
			System.out.println("Escribe el curso academico de la visita: ");
			System.out.print("Curso: ");
			String cursoAca = br.readLine();
			System.out.println("Escribe la tematica: ");
			System.out.print("Tematica: ");
			String tematica = br.readLine();
			System.out.println("Escribe el coste de la visita: ");
			System.out.print("Coste: ");
			Double costeVis = Double.parseDouble(br.readLine());
			System.out.println("Escribe el numero maximo de clientes para la visita: ");
			System.out.print("Max: ");
			int maxClientes = Integer.parseInt(br.readLine());

			System.out.println("Escoge al empleado que hara la visita: ");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("Id del empleado: " + resul.getInt("idEmpleado") + "\n" + "Nombre: "
						+ resul.getString("nombreEmpleado") + "\n" + "Primer apellido: "
						+ resul.getString("primerApellidoEmpleado") + "\n" + "Fecha de nacimiento: "
						+ resul.getDate("fechaNacimientoEmpleado") + "\n" + "Fecha de contratacion: "
						+ resul.getDate("fechaContratacionEmpleado") + "\n" + "Nacionalidad: "
						+ resul.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
						+ resul.getString("cargoEmpleado"));
			}
			System.out.println("------------------------------------");

			System.out.print("Id: ");
			int idEmpleado = Integer.parseInt(br.readLine());

			vis = new Visita(nombreVis, puntoPar, cursoAca, tematica, costeVis, maxClientes, idEmpleado);
			sql = "INSERT INTO `agencia1`.`visitaguiada` (`nombreVisita`, `puntoPartida`, "
					+ "`cursoAcademico`, `tematicaVisita`,`costeVisita`, `numMaxClientes`,`empleadoId`) VALUES (?, ?, ?, ?, ?, ?, ?)";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, vis.getNombre());
			ps.setString(2, vis.getPuntoPartida());
			ps.setString(3, vis.getCursoAcademico());
			ps.setString(4, vis.getTematica());
			ps.setDouble(5, vis.getCoste());
			ps.setInt(6, vis.getMaxClientes());
			ps.setInt(7, vis.getEmpleadoId());
			ps.executeUpdate();
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
			System.out.println("Se ha agregado la visita a la base de datos.");
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

	public static void borrarEmpleado() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM empleado");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("Id del empleado: " + resul.getInt("idEmpleado") + "\n" + "Nombre: "
						+ resul.getString("nombreEmpleado") + "\n" + "Primer apellido: "
						+ resul.getString("primerApellidoEmpleado") + "\n" + "Fecha de nacimiento: "
						+ resul.getDate("fechaNacimientoEmpleado") + "\n" + "Fecha de contratacion: "
						+ resul.getDate("fechaContratacionEmpleado") + "\n" + "Nacionalidad: "
						+ resul.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
						+ resul.getString("cargoEmpleado"));
			}
			System.out.println("Escribe el id del empleado que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			sql = "DELETE FROM empleado where idEmpleado = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idborrar);
			ps.executeUpdate();
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("Id del empleado: " + resul.getInt("idEmpleado") + "\n" + "Nombre: "
						+ resul.getString("nombreEmpleado") + "\n" + "Primer apellido: "
						+ resul.getString("primerApellidoEmpleado") + "\n" + "Fecha de nacimiento: "
						+ resul.getDate("fechaNacimientoEmpleado") + "\n" + "Fecha de contratacion: "
						+ resul.getDate("fechaContratacionEmpleado") + "\n" + "Nacionalidad: "
						+ resul.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
						+ resul.getString("cargoEmpleado"));
			}
			System.out.println("Se ha borrado al empleado de la base de datos!");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (

		ClassNotFoundException cn) {
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

	public static void borrarVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM visitaguiada");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("\nNumero de visita: " + resul.getInt("idVisita") + "\n" + "Nombre de la visita: "
						+ resul.getString("nombreVisita") + "\n" + "Punto de partida: "
						+ resul.getString("puntoPartida") + "\n" + "Curso academico: "
						+ resul.getString("cursoAcademico") + "\n" + "Tematica de la visita: "
						+ resul.getString("tematicaVisita") + "\n" + "Coste de la visita: "
						+ resul.getDouble("costeVisita") + "\n" + "Numero maximo de clientes: "
						+ resul.getInt("numMaxClientes") + "\n" + "Empleado asignado: " + resul.getInt("empleadoId")
						+ "\n");
			}
			System.out.println("Escribe el id de la visita que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			sql = "DELETE FROM visitaguiada where idVisita = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idborrar);
			ps.executeUpdate();
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("\nNumero de visita: " + resul.getInt("idVisita") + "\n" + "Nombre de la visita: "
						+ resul.getString("nombreVisita") + "\n" + "Punto de partida: "
						+ resul.getString("puntoPartida") + "\n" + "Curso academico: "
						+ resul.getString("cursoAcademico") + "\n" + "Tematica de la visita: "
						+ resul.getString("tematicaVisita") + "\n" + "Coste de la visita: "
						+ resul.getDouble("costeVisita") + "\n" + "Numero maximo de clientes: "
						+ resul.getInt("numMaxClientes") + "\n" + "Empleado asignado: " + resul.getInt("empleadoId")
						+ "\n");
			}
			System.out.println("Se ha la visita de la base de datos!");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (

		ClassNotFoundException cn) {
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

	public static void modificarEmpleado() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM agencia1.empleado");

			while (resul.next()) {
				System.out.println("Id del empleado: " + resul.getInt("idEmpleado") + "\n" + "Nombre: "
						+ resul.getString("nombreEmpleado") + "Dni: " + resul.getString("dniEmpleado") + "\n"
						+ "Primer apellido: " + resul.getString("primerApellidoEmpleado") + "\n"
						+ "Fecha de nacimiento: " + resul.getDate("fechaNacimientoEmpleado") + "\n"
						+ "Fecha de contratacion: " + resul.getDate("fechaContratacionEmpleado") + "\n"
						+ "Nacionalidad:" + resul.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
						+ resul.getString("cargoEmpleado") + "\n" + "---------------------------------");

			}
			System.out.println("------------------------------------");
			System.out.println("Escoge el empleado que vas a modificar: ");
			System.out.print("Id: ");
			int idEmpleado = Integer.parseInt(br.readLine());
			System.out.println("Que quieres modificar: \n" + "1.DNI  \n" + "2. Nombre\n" + "3. Primer apellido\n"
					+ "4. Fecha de nacimiento\n" + "5. Fecha de contratacion\n" + "6. Nacionalidad\n" + "7. Cargo");
			System.out.print("R: ");
			int empleModif = Integer.parseInt(br.readLine());

			switch (empleModif) {
			case 1:
				System.out.println("Escribe el nuevo DNI del empleado : ");
				System.out.print("DNI: ");
				String dni = br.readLine();
				sql = "UPDATE empleado SET dniEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, dni);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modificado el dni del empleado en la base de datos");
				break;
			case 2:
				System.out.println("Escribe el nuevo nombre del empleado: ");
				System.out.print("Nombre: ");
				String nombre = br.readLine();
				sql = "UPDATE empleado SET nombreEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modicado el nombre del empleado en la base de datos");
				break;
			case 3:
				System.out.println("Escribe el nuevo apellido del empleado: ");
				System.out.print("Apellido: ");
				String apellido = br.readLine();
				sql = "UPDATE empleado SET primerApellidoEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, apellido);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha primer apellido del empleado en la base de datos");
				break;
			case 4:
				System.out.println("Escribe la nueva fecha de nacimiento del empleado: ");
				System.out.print("Fecha: ");
				String fechaNacimiento = br.readLine();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
				Date fechaNacForm = format.parse(fechaNacimiento);
				java.sql.Date fechaNacSql = new java.sql.Date(fechaNacForm.getTime());

				sql = "UPDATE empleado SET fechaNacimientoEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDate(1, fechaNacSql);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modicado la fecha de nacimiento del empleado en la base de datos");
				break;
			case 5:
				System.out.println("Escribe la nueva fecha de contratacion del empleado: ");
				System.out.print("Fecha: ");
				String fechaContratacion = br.readLine();
				SimpleDateFormat format2 = new SimpleDateFormat("yyyy/MM/dd");
				Date fechaContForm = format2.parse(fechaContratacion);
				java.sql.Date fechaContSql = new java.sql.Date(fechaContForm.getTime());

				sql = "UPDATE empleado SET fechaContratacionEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDate(1, fechaContSql);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modicado la fecha de contratacion del empleado en la base de datos");
				break;
			case 6:
				System.out.println("Escribe la nueva nacionalidad del empleado: ");
				System.out.print("Nacionalidad: ");
				String nacionalidad = br.readLine();
				sql = "UPDATE empleado SET nacionalidadEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, nacionalidad);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modicado la nacionalidad en la base de datos");
				break;
			case 7:
				System.out.println("Escribe el nuevo cargo del empleado: ");
				System.out.print("Cargo: ");
				String cargo = br.readLine();
				sql = "UPDATE empleado SET cargoEmpleado = ? WHERE idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, cargo);
				ps.setInt(2, idEmpleado);
				ps.executeUpdate();
				System.out.println("Se ha modicado el cargo en la base de datos");

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void modificarVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM agencia1.visitaguiada");

			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("\nNumero de visita: " + resul.getInt("idVisita") + "\n" + "Nombre de la visita: "
						+ resul.getString("nombreVisita") + "\n" + "Punto de partida: "
						+ resul.getString("puntoPartida") + "\n" + "Curso academico: "
						+ resul.getString("cursoAcademico") + "\n" + "Tematica de la visita: "
						+ resul.getString("tematicaVisita") + "\n" + "Coste de la visita: "
						+ resul.getDouble("costeVisita") + "\n" + "Numero maximo de clientes: "
						+ resul.getInt("numMaxClientes") + "\n" + "Empleado asignado: " + resul.getInt("empleadoId")
						+ "\n");

			}
			System.out.println("------------------------------------");
			System.out.println("Escoge la visita que vas a modificar: ");
			System.out.print("Id: ");
			int id_visita = Integer.parseInt(br.readLine());
			System.out.println(
					"Que quieres modificar: \n" + "1. Nombre \n" + "2. Punto de partida\n" + "3. Curso academico\n"
							+ "4. Tematica\n" + "5. Coste\n" + "6. Numero maximo de clientes\n" + "7. Empleado");
			System.out.print("R: ");
			int visModif = Integer.parseInt(br.readLine());

			switch (visModif) {
			case 1:
				System.out.println("Escribe el nuevo nombre de la visita : ");
				System.out.print("Nombre: ");
				String nombre = br.readLine();
				sql = "UPDATE visitaguiada SET nombreVisita = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado el nombre de la visita en la base de datos");
				break;
			case 2:
				System.out.println("Escribe el nuevo punto de partida: ");
				System.out.print("Punto de partida: ");
				String puntoPartida = br.readLine();
				sql = "UPDATE visitaguiada SET puntoPartida = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, puntoPartida);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado el punto de partida de la visita en la base de datos");
				break;
			case 3:
				System.out.println("Escribe el nuevo curso academico de la visita: ");
				System.out.print("Curso: ");
				String curso = br.readLine();
				sql = "UPDATE visitaguiada SET cursoAcademico = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, curso);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado el salario del empleado en la base de datos");
				break;
			case 4:
				System.out.println("Escribe la nueva tematica de la visita: ");
				System.out.print("Tematica: ");
				String tematica = br.readLine();
				sql = "UPDATE visitaguiada SET tematicaVisita = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setString(1, tematica);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado la tematica de la visita en la base de datos");
				break;
			case 5:
				System.out.println("Escribe el nuevo coste de la visita: ");
				System.out.print("Curso: ");
				double coste = Double.parseDouble(br.readLine());
				sql = "UPDATE visitaguiada SET costeVisita = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDouble(1, coste);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado coste de la visita en la base de datos");
				break;
			case 6:
				System.out.println("Escribe el nuevo numero maximo de clientes de la visita: ");
				System.out.print("Curso: ");
				int numMax = Integer.parseInt(br.readLine());
				sql = "UPDATE visitaguiada SET numMaxClientes = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setInt(1, numMax);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado numero maximo de clientes en la base de datos");
				break;
			case 7:
				Statement sentencia2 = (Statement) conexion.createStatement();
				ResultSet resul2 = ((java.sql.Statement) sentencia2).executeQuery("SELECT * FROM agencia1.empleado");

				while (resul2.next()) {
					System.out.println("Id del empleado: " + resul2.getInt("idEmpleado") + "\n" + "Nombre: "
							+ resul2.getString("nombreEmpleado") + "\n" + "Primer apellido: "
							+ resul2.getString("primerApellidoEmpleado") + "\n" + "Fecha de nacimiento: "
							+ resul2.getDate("fechaNacimientoEmpleado") + "\n" + "Fecha de contratacion: "
							+ resul2.getDate("fechaContratacionEmpleado") + "\n" + "Nacionalidad:"
							+ resul2.getString("nacionalidadEmpleado") + "\n" + "Cargo: "
							+ resul2.getString("cargoEmpleado") + "\n" + "---------------------------------");
				}
				System.out.println("Escoge el nuevo empleado");
				System.out.print("R:");
				int idEmple = Integer.parseInt(br.readLine());
				sql = "UPDATE visitaguiada SET empleadoId = ? WHERE idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setDouble(1, idEmple);
				ps.setInt(2, id_visita);
				ps.executeUpdate();
				System.out.println("Se ha modicado el empleado de la visitia guiada en la base de datos");
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
