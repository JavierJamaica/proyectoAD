/**
 * 
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 17 oct 2022 - 20:49:13
 */
public class Agencia1BD {

	public static boolean comprobarClienteHorarioVisita(int idCliente, int idVisita) {
		String sql;
		PreparedStatement ps;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			sql = "SELECT * FROM horariovisita WHERE visitaId = ? AND clienteId = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idVisita);
			ps.setInt(2, idCliente);
			ResultSet horarioVisitaRS = ps.executeQuery();
			while (horarioVisitaRS.next()) {
				if (horarioVisitaRS.getInt("clienteId") == idCliente) {
					return false;
				}
			}
			sentencia.close();
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Tiene que ser un numero!");
			e.printStackTrace();
		}

		return true;

	}

	public static boolean selectIdHorarioVisita(int idHorarioVisita) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia)
					.executeQuery("SELECT idHorarioVisita FROM horariovisita");
			while (resul.next()) {
				if (idHorarioVisita == resul.getInt("idHorarioVisita")) {
					return true;
				}

			}
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return false;
	}

	public static boolean selectIdClientes(int idCliente) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT idCliente FROM cliente");
			while (resul.next()) {
				if (idCliente == resul.getInt("idCliente")) {
					return true;
				}

			}
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return false;
	}

	public static boolean selectIdEmpleados(int idEmpleado) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT idEmpleado FROM empleado");
			while (resul.next()) {
				if (idEmpleado == resul.getInt("idEmpleado")) {
					return true;
				}

			}
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return false;
	}

	public static boolean selectIdVisitas(int idVisita) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT idVisita FROM visitaguiada");
			while (resul.next()) {
				if (idVisita == resul.getInt("idVisita")) {
					return true;
				}

			}
			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
		return false;
	}

	public static void selectHorarioVisita() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM horariovisita");

			while (resul.next()) {
				int idVisita = resul.getInt("visitaId");
				int idCliente = resul.getInt("clienteId");
				System.out.println("------------------------------------");
				System.out.println("Identificador de la visita: " + resul.getInt("idHorarioVisita") + "\n"
						+ "Visita asignada: " + selectClaseVisita(idVisita).toString() + "\n" + "Clientes: "
						+ selectClaseCliente(idCliente).toString() + "\n" + "Fecha: " + resul.getDate("fecha"));
			}
			System.out.println("------------------------------------");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	public static void selectClientes() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();
			ResultSet resul = ((java.sql.Statement) sentencia).executeQuery("SELECT * FROM cliente");
			while (resul.next()) {
				System.out.println("------------------------------------");
				System.out.println("Id del cliente: " + resul.getInt("idCliente") + "\n" + "DNI: "
						+ resul.getString("dniCliente") + "\n" + "Nombre: " + resul.getString("nombreCliente") + "\n"
						+ "Apellidos: " + resul.getString("apellidos") + "\n" + "Edad: " + resul.getInt("edadCliente")
						+ "\n" + "Profesion: " + resul.getString("profesionCliente"));

			}
			System.out.println("------------------------------------");

			resul.close();// Cerrar ResultSet
			sentencia.close();
			conexion.close();// Cerrar conexion
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

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
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
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
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}
	}

	public static Visita selectClaseVisita(int idVisita) {
		String sql;
		PreparedStatement ps;
		Visita visita = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			sql = "SELECT * FROM visitaguiada where idVisita = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idVisita);
			ResultSet visitaRS = ps.executeQuery();
			while (visitaRS.next()) {
				visita = new Visita(visitaRS.getInt("idVisita"), visitaRS.getString("nombreVisita"),
						visitaRS.getString("puntoPartida"), visitaRS.getString("cursoAcademico"),
						visitaRS.getString("tematicaVisita"), visitaRS.getDouble("costeVisita"),
						visitaRS.getInt("numMaxClientes"), visitaRS.getInt("empleadoId"));
			}
			sentencia.close();
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Tiene que ser un numero!");
			e.printStackTrace();
		}

		return visita;

	}

	public static Cliente selectClaseCliente(int idCliente) {
		String sql;
		PreparedStatement ps;
		Cliente cliente = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			sql = "SELECT * FROM cliente where idCliente = ?";
			ps = conexion.prepareStatement(sql);
			ps.setInt(1, idCliente);
			ResultSet clienteRS = ps.executeQuery();
			while (clienteRS.next()) {
				cliente = new Cliente(clienteRS.getInt("idCliente"), clienteRS.getString("dniCliente"),
						clienteRS.getString("nombreCliente"), clienteRS.getString("apellidos"),
						clienteRS.getInt("edadCliente"), clienteRS.getString("profesionCliente"));
			}
			sentencia.close();
			conexion.close();// Cerrar conexion

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			System.out.println("Tiene que ser un numero!");
			e.printStackTrace();
		}
		return cliente;

	}

	public static void insertarHorarioVisita() throws ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		HorarioVisita horaVisita;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

			selectVisitas();
			System.out.println("Escoge a una visita para agendar");
			System.out.print("Id de la visita: ");
			int idVisita = Integer.parseInt(br.readLine());

			if (selectIdVisitas(idVisita)) {
				Visita visita = selectClaseVisita(idVisita);
				selectClientes();
				System.out.println("Escoge a un cliente para agendarlo en esa visita: ");
				System.out.print("Id del cliente: ");
				int idCliente = Integer.parseInt(br.readLine());
				if (selectIdClientes(idCliente)) {
					Cliente cliente = selectClaseCliente(idCliente);
					if (comprobarClienteHorarioVisita(idCliente, idVisita)) {
						System.out.println("Fecha (YYYY/MM/DD): ");
						String fechaVisita = br.readLine();
						SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/DD");
						Date fechaAgendada = format.parse(fechaVisita);
						horaVisita = new HorarioVisita(visita, cliente, fechaAgendada);
						java.sql.Date fechaSql = new java.sql.Date(fechaAgendada.getTime());

						sql = "INSERT INTO `agencia1`.`horariovisita` (`visitaId`, `clienteId`, "
								+ "`fecha`) VALUES (?, ?, ?)";
						ps = conexion.prepareStatement(sql);
						ps.setInt(1, visita.getId());
						ps.setInt(2, cliente.getId());
						ps.setDate(3, fechaSql);

						ps.executeUpdate();
						sentencia.close();
						conexion.close();// Cerrar conexion
						System.out.println("Se agendo una visita en la base de datos");

					} else {
						System.out.println("Esta visita ya tiene un cliente con ese id");
					}

				} else {
					System.out.println("No hay un cliente con ese id");
				}

			} else {
				System.out.println("No hay una visita con ese id");
			}

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

	public static void insertarEmpleado() throws ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Empleado emple;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

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

	public static void insertarCliente() throws ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;
		Cliente cliente;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

			System.out.println("Escribe el dni del cliente: ");
			System.out.print("Dni: ");
			String dni = br.readLine();
			System.out.println("Escribe el nombre cliente: ");
			System.out.print("Nombre: ");
			String nombreCliente = br.readLine();
			System.out.println("Escribe los apellidos del cliente: ");
			System.out.print("Apellidos: ");
			String apellidos = br.readLine();
			System.out.println("Escribe la edad del cliente");
			System.out.print("Edad: ");
			int edad = Integer.parseInt(br.readLine());
			System.out.println("Escribe la profesion del cliente");
			System.out.print("Profesion: ");
			String profesion = br.readLine();

			cliente = new Cliente(0, dni, nombreCliente, apellidos, edad, profesion);

			sql = "INSERT INTO `agencia1`.`cliente` (`dniCliente`, `nombreCliente`, "
					+ "`apellidos`, `edadCliente`,`profesionCliente`) VALUES (?, ?, ?, ?, ?)";
			ps = conexion.prepareStatement(sql);
			ps.setString(1, cliente.getDni());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setInt(4, cliente.getEdad());
			ps.setString(5, cliente.getProfesion());
			ps.executeUpdate();
			sentencia.close();
			conexion.close();// Cerrar conexion

			System.out.println("Se ha agregado el cliente a la base de datos.");

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
			selectEmpleados();

			System.out.print("Id: ");
			int idEmpleado = Integer.parseInt(br.readLine());

			vis = new Visita(0, nombreVis, puntoPar, cursoAca, tematica, costeVis, maxClientes, idEmpleado);
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

	public static void borrarCliente() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			selectClientes();
			System.out.println("Escribe el id del cliente que quieres borrar: ");
			System.out.print("Id: ");
			int idBorrar = Integer.parseInt(br.readLine());
			if (selectIdClientes(idBorrar)) {
				sql = "DELETE FROM cliente where idCliente = ?";
				ps = conexion.prepareStatement(sql);
				ps.setInt(1, idBorrar);
				ps.executeUpdate();
				System.out.println("Se ha borrado el cliente de la base de datos");
				sentencia.close();
				conexion.close();// Cerrar conexion
			} else {
				System.out.println("No existe un cliente con ese id!");
			}

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

	public static void borrarEmpleado() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			selectEmpleados();
			System.out.println("Escribe el id del empleado que quieres borrar: ");
			System.out.print("Id: ");
			int idBorrar = Integer.parseInt(br.readLine());
			if (selectIdEmpleados(idBorrar)) {
				sql = "DELETE FROM empleado where idEmpleado = ?";
				ps = conexion.prepareStatement(sql);
				ps.setInt(1, idBorrar);
				ps.executeUpdate();
				System.out.println("Se ha borrado el empleado de la base de datos");
				sentencia.close();
				conexion.close();// Cerrar conexion
			} else {
				System.out.println("No existe un empleado con ese id!");
			}

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

	public static void borrarHorarioVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			Statement sentencia = (Statement) conexion.createStatement();

			selectHorarioVisita();
			System.out.println("Escribe el id de la visita que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			if (selectIdHorarioVisita(idborrar)) {
				sql = "DELETE FROM horariovisita where idHorarioVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setInt(1, idborrar);
				ps.executeUpdate();
				System.out.println("Se ha borrado la visita");
				sentencia.close();
				conexion.close();// Cerrar conexion
			} else {
				System.out.println("No existe una visita con ese id!");
			}

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

			selectVisitas();
			System.out.println("Escribe el id de la visita que quieres borrar: ");
			System.out.print("Id: ");
			int idborrar = Integer.parseInt(br.readLine());
			if (selectIdVisitas(idborrar)) {
				sql = "DELETE FROM visitaguiada where idVisita = ?";
				ps = conexion.prepareStatement(sql);
				ps.setInt(1, idborrar);
				ps.executeUpdate();
				System.out.println("Se ha borrado la visita");
				sentencia.close();
				conexion.close();// Cerrar conexion
			} else {
				System.out.println("No existe una visita con ese id!");
			}

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

			selectEmpleados();

			System.out.println("Escoge el empleado que vas a modificar: ");
			System.out.print("Id: ");
			int idEmpleado = Integer.parseInt(br.readLine());
			if (selectIdEmpleados(idEmpleado)) {
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

				sentencia.close();
				conexion.close();// Cerrar conexion

			} else {
				System.out.println("No existe un empleado con ese id!");
			}

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

	public static void modificarCliente() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

			selectClientes();

			System.out.println("Escoge el cliente que vas a modificar: ");
			System.out.print("Id: ");
			int idCliente = Integer.parseInt(br.readLine());
			if (selectIdClientes(idCliente)) {
				System.out.println("Que quieres modificar: \n" + "1. DNI\n" + "2. Nombre\n" + "3. ApellidoS\n"
						+ "4. Edad\n" + "5. Profesion");
				System.out.print("R: ");
				int clienteModif = Integer.parseInt(br.readLine());

				switch (clienteModif) {
				case 1:
					System.out.println("Escribe el nuevo DNI del cliente : ");
					System.out.print("DNI: ");
					String dni = br.readLine();
					sql = "UPDATE cliente SET dniCliente = ? WHERE idCliente = ?";
					ps = conexion.prepareStatement(sql);
					ps.setString(1, dni);
					ps.setInt(2, idCliente);
					ps.executeUpdate();
					System.out.println("Se ha modificado el dni del cliente en la base de datos");
					break;
				case 2:
					System.out.println("Escribe el nuevo nombre del cliente: ");
					System.out.print("Nombre: ");
					String nombre = br.readLine();
					sql = "UPDATE cliente SET nombreCliente = ? WHERE idCliente = ?";
					ps = conexion.prepareStatement(sql);
					ps.setString(1, nombre);
					ps.setInt(2, idCliente);
					ps.executeUpdate();
					System.out.println("Se ha modicado el nombre del cliente en la base de datos");
					break;
				case 3:
					System.out.println("Escribe los nuevos apellidos del cliente ");
					System.out.print("Apellidos: ");
					String apellido = br.readLine();
					sql = "UPDATE cliente SET apellidos = ? WHERE idCliente = ?";
					ps = conexion.prepareStatement(sql);
					ps.setString(1, apellido);
					ps.setInt(2, idCliente);
					ps.executeUpdate();
					System.out.println("Se han modificado los apellidos del cliente en la base de datos");
					break;
				case 4:
					System.out.println("Escribe la nueva edad del cliente: ");
					System.out.print("Edad: ");
					int edad = Integer.parseInt(br.readLine());
					sql = "UPDATE cliente SET edadCliente = ? WHERE idCliente = ?";
					ps = conexion.prepareStatement(sql);
					ps.setInt(1, edad);
					ps.setInt(2, idCliente);
					ps.executeUpdate();
					System.out.println("Se ha modicado la edad del cliente en la base de datos");
					break;
				case 5:
					System.out.println("Escribe la nueva profesion del cliente: ");
					System.out.print("Profesion: ");
					String profesion = br.readLine();
					sql = "UPDATE cliente SET profesionCliente = ? WHERE idCliente = ?";
					ps = conexion.prepareStatement(sql);
					ps.setString(1, profesion);
					ps.setInt(2, idCliente);
					ps.executeUpdate();
					System.out.println("Se ha modicado la profesion del cliente en la base de datos");
					break;

				default:
					System.out.println("Tiene que ser una opcion valida");
					break;
				}

				sentencia.close();
				conexion.close();// Cerrar conexion

			} else {
				System.out.println("No existe un empleado con ese id!");
			}

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

	public static void modificarHorarioVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

			selectHorarioVisita();

			System.out.println("Escoge la visita agendada para modificar: ");
			System.out.print("Id: ");
			int idHorarioVisita = Integer.parseInt(br.readLine());
			if (selectIdHorarioVisita(idHorarioVisita)) {
				System.out.println("Que quieres modificar: \n" + "1. Visita\n" + "2. Cliente\n");
				System.out.print("R: ");
				int horarioVisitaModif = Integer.parseInt(br.readLine());

				switch (horarioVisitaModif) {
				case 1:
					selectVisitas();
					System.out.println("Escoge la nueva visita : ");
					System.out.print("Visita");
					int idVisita = Integer.parseInt(br.readLine());
					sql = "UPDATE horariovisita SET visitaId = ? WHERE idHorarioVisita = ?";
					ps = conexion.prepareStatement(sql);
					ps.setInt(1, idVisita);
					ps.setInt(2, idHorarioVisita);
					ps.executeUpdate();
					System.out.println("Se ha modificado la visita en la base de datos");
					break;
				case 2:
					selectClientes();
					System.out.println("Escoge el nuevo cliente: ");
					System.out.print("Cliente: ");
					int idCliente = Integer.parseInt(br.readLine());
					sql = "UPDATE horariovisita SET clienteId = ? WHERE idHorarioVisita = ?";
					ps = conexion.prepareStatement(sql);
					ps.setInt(1, idCliente);
					ps.setInt(2, idHorarioVisita);
					ps.executeUpdate();
					System.out.println("Se ha modicado el cliente en la base de datos");
					break;

				default:
					System.out.println("Tiene que ser una opcion valida");
					break;
				}

				sentencia.close();
				conexion.close();// Cerrar conexion

			} else {
				System.out.println("No existe uan visita agendada con ese id!");
			}

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

	public static void modificarVisita() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sql;
		PreparedStatement ps;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");

			Statement sentencia = (Statement) conexion.createStatement();

			selectVisitas();

			System.out.println("Escoge la visita que vas a modificar: ");
			System.out.print("Id: ");
			int id_visita = Integer.parseInt(br.readLine());
			if (selectIdVisitas(id_visita)) {
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
					selectEmpleados();
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

				sentencia.close();
				conexion.close();// Cerrar conexion
			} else {
				System.out.println("No existe una visita con ese id!");
			}

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

	public static void datosBBDD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			DatabaseMetaData dbmd = conexion.getMetaData();

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACION SOBRE LA BASE DE DATOS:\n " + " Nombre: " + nombre);
			System.out.println("Driver : " + driver);
			System.out.println("URL : " + url);
			System.out.println("Usuario: " + usuario);

			conexion.close();
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

	}

	public static void datosTablas() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/agencia1", "root", "12345Abcde");
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			ResultSet resul1 = null;
			ResultSet resul2 = null;
			ResultSet resul3 = null;

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			resul = dbmd.getTables(null, "cliente", null, null);
			resul1 = dbmd.getTables(null, "empleado", null, null);
			resul2 = dbmd.getTables(null, "horariovisita", null, null);
			resul3 = dbmd.getTables(null, "visitaguiada", null, null);

			System.out.println("----------------------------------------------");
			System.out.println("Tabla cliente");
			while (resul.next()) {

				String catalogo = resul.getString(1);
				String esquema = resul.getString(2);
				String tabla = resul.getString(3);
				String tipo = resul.getString(4);
				System.out.println(tipo + " - Catalogo: " + catalogo + ", Esquema: " + esquema + ", Nombre: " + tabla);
			}
			System.out.println("----------------------------------------------");

			System.out.println("Columnas Tabla cliente: ");
			ResultSet columnas = null;
			columnas = dbmd.getColumns(null, "agencia1", "cliente", null);
			while (columnas.next()) {
				String nomCol = columnas.getString("COLUMN_NAME");
				String tipoCol = columnas.getString("TYPE_NAME");
				String tamCol = columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nomCol, tipoCol, tamCol,
						nula);
			}
			
			System.out.println("----------------------------------------------");

			System.out.println("----------------------------------------------");
			System.out.println("Tabla empleado");
			while (resul1.next()) {

				String catalogo = resul1.getString(1);
				String esquema = resul1.getString(2);
				String tabla = resul1.getString(3);
				String tipo = resul1.getString(4);
				System.out.println(tipo + " - Catalogo: " + catalogo + ", Esquema: " + esquema + ", Nombre: " + tabla);
			}
			System.out.println("----------------------------------------------");

			System.out.println("Columnas tabla visitaguiada");

			columnas = dbmd.getColumns(null, "agencia1", "empleado", null);
			while (columnas.next()) {
				String nomCol = columnas.getString("COLUMN_NAME");
				String tipoCol = columnas.getString("TYPE_NAME");
				String tamCol = columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nomCol, tipoCol, tamCol,
						nula);
			}
			
			System.out.println("----------------------------------------------");

			System.out.println("----------------------------------------------");
			System.out.println("Tabla horariovisita");
			while (resul2.next()) {

				String catalogo = resul2.getString(1);
				String esquema = resul2.getString(2);
				String tabla = resul2.getString(3);
				String tipo = resul2.getString(4);
				System.out.println(tipo + " - Catalogo: " + catalogo + ", Esquema: " + esquema + ", Nombre: " + tabla);
			}
			System.out.println("----------------------------------------------");

			System.out.println("Columnas tabla visitaguiada");

			columnas = dbmd.getColumns(null, "agencia1", "horariovisita", null);
			while (columnas.next()) {
				String nomCol = columnas.getString("COLUMN_NAME");
				String tipoCol = columnas.getString("TYPE_NAME");
				String tamCol = columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nomCol, tipoCol, tamCol,
						nula);
			}
			
			System.out.println("----------------------------------------------");

			System.out.println("----------------------------------------------");
			System.out.println("Tabla visitaguiada");
			while (resul3.next()) {

				String catalogo = resul3.getString(1);
				String esquema = resul3.getString(2);
				String tabla = resul3.getString(3);
				String tipo = resul3.getString(4);
				System.out.println(tipo + " - Catalogo: " + catalogo + ", Esquema: " + esquema + ", Nombre: " + tabla);
			}
			System.out.println("----------------------------------------------");

			System.out.println("Columnas tabla visitaguiada");
			columnas = dbmd.getColumns(null, "agencia1", "visitaguiada", null);
			while (columnas.next()) {
				String nomCol = columnas.getString("COLUMN_NAME");
				String tipoCol = columnas.getString("TYPE_NAME");
				String tamCol = columnas.getString("COLUMN_SIZE");
				String nula = columnas.getString("IS_NULLABLE");
				System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser nula? %s %n", nomCol, tipoCol, tamCol,
						nula);
			}
			System.out.println("----------------------------------------------");

	

			conexion.close();
		} catch (ClassNotFoundException cn) {
			System.out.println("Error: " + cn);
		} catch (SQLException e) {
			System.out.println("Error: " + e);
		}

	}

}
