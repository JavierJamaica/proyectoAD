/**
 * 
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 17 oct 2022 - 19:50:48
 */
public class Main {

	public static void main(String[] args) throws ParseException {
		int rMenu = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			try {
				System.out.println("Bienvenido al gestor de agencias");

				System.out.println("Elige la agencia a la que quieres ir \n" + "1. Agencia 1.\n" + "2. Agencia 2.\n"
						+ "3. Agencia 3.\n" + "4. Salir.");
				System.out.print("Opcion: ");

				rMenu = Integer.parseInt(br.readLine());
				switch (rMenu) {
				case 1:
					int r3;
					int r;
					do {
						System.out.println("Bienvenido a la agencia 1, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						System.out.print("Opcion: ");
						r3 = Integer.parseInt(br.readLine());
						switch (r3) {
						case 1:
							do {
								System.out.println("Bienvenido a visitas:\n" + "1. Ver visitas\n" + "2. Crear visita\n"
										+ "3. Modificar visita\n" + "4. Borrar visita\n" + "5. Gestionar visitas\n"
										+ "6. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:

									Agencia1BD.selectVisitas();
									break;
								case 2:
									Agencia1BD.insertarVisita();
									break;
								case 3:
									Agencia1BD.modificarVisita();
									break;
								case 4:
									Agencia1BD.borrarVisita();
									break;
								case 5:
									int r2;
									do {
										System.out.println("Que deseas hacer?\n" + "1. Ver visitas agendadas\n"
												+ "2. Agendar visita\n" + "3. Modificar agenda\n"
												+ "4. Eliminar una visita agendada\n" + "5. Atras");
										r2 = Integer.parseInt(br.readLine());
										switch (r2) {
										case 1:
											Agencia1BD.selectHorarioVisita();
											break;
										case 2:
											Agencia1BD.insertarHorarioVisita();
											break;
										case 3:
											Agencia1BD.modificarHorarioVisita();
											break;
										case 4:
											Agencia1BD.borrarHorarioVisita();
											break;
										case 5:
											break;
										default:
											break;
										}
									} while (r2 != 5);
									break;
								case 6:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}
							} while (r != 6);
							break;
						case 2:
							do {
								System.out.println(
										"Bienvenido a empleados:\n" + "1. Ver empleados\n" + "2. Crear empleado\n"
												+ "3. Modificar empleado\n" + "4. Borrar empleado\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:
									Agencia1BD.selectEmpleados();
									break;
								case 2:
									Agencia1BD.insertarEmpleado();
									break;
								case 3:
									Agencia1BD.modificarEmpleado();
									break;
								case 4:
									Agencia1BD.borrarEmpleado();
									break;
								case 5:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}
							} while (r != 5);
							break;
						case 3:
							do {
								System.out
										.println("Bienvenido a clientes:\n" + "1. Ver clientes\n" + "2. Crear cliente\n"
												+ "3. Modificar cliente\n" + "4. Borrar cliente\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());

								switch (r) {
								case 1:
									Agencia1BD.selectClientes();
									break;
								case 2:
									Agencia1BD.insertarCliente();
									break;
								case 3:
									Agencia1BD.modificarCliente();
									break;
								case 4:
									Agencia1BD.borrarCliente();
									break;
								case 5:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}

							} while (r != 5);
							break;
						case 4:
							do {
								System.out.println("Bienvenido a base de datos:\n" + "1. Ver datos de la BBDDD\n"
										+ "2. Datos de las tablas\n" + "3. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:
									Agencia1BD.datosBBDD();
									break;
								case 2:
									Agencia1BD.datosTablas();
									break;
								case 3:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}

							} while (r != 3);
							break;
						case 5:
							break;
						default:
							System.out.println("Tiene que ser una de las opciones validas");
							break;
						}
					} while (r3 != 5);
					break;
				case 2:
					int r2;
					do {
						System.out.println("Bienvenido a la agencia 2, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						System.out.print("R: ");
						r2 = Integer.parseInt(br.readLine());
						
						switch (r2) {
						case 1:
							do {
								System.out.println("Bienvenido a visitas:\n" + "1. Ver visitas\n" + "2. Crear visita\n"
										+ "3. Modificar visita\n" + "4. Borrar visita\n" + "5. Gestionar visitas\n"
										+ "6. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:

									Agencia2BD.selectVisitas();
									break;
								case 2:
									Agencia2BD.insertarVisita();
									break;
								case 3:
									Agencia2BD.modificarVisita();
									break;
								case 4:
									Agencia2BD.borrarVisita();
									break;
								case 5:
									int ra2;
									do {
										System.out.println("Que deseas hacer?\n" + "1. Ver visitas agendadas\n"
												+ "2. Agendar visita\n" + "3. Modificar agenda\n"
												+ "4. Eliminar una visita agendada\n" + "5. Atras");
										ra2 = Integer.parseInt(br.readLine());
										switch (ra2) {
										case 1:
											Agencia2BD.selectHorarioVisita();
											break;
										case 2:
											Agencia2BD.insertarHorarioVisita();
											break;
										case 3:
											Agencia2BD.modificarHorarioVisita();
											break;
										case 4:
											Agencia2BD.borrarHorarioVisita();
											break;
										case 5:
											break;
										default:
											break;
										}
									} while (ra2 != 5);
									break;
								case 6:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}
							} while (r != 6);
							break;
						case 2:
							do {
								System.out.println(
										"Bienvenido a empleados:\n" + "1. Ver empleados\n" + "2. Crear empleado\n"
												+ "3. Modificar empleado\n" + "4. Borrar empleado\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:
									Agencia2BD.selectEmpleados();
									break;
								case 2:
									Agencia2BD.insertarEmpleado();
									break;
								case 3:
									Agencia2BD.modificarEmpleado();
									break;
								case 4:
									Agencia2BD.borrarEmpleado();
									break;
								case 5:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}
							} while (r != 5);
							break;
						case 3:
							do {
								System.out
										.println("Bienvenido a clientes:\n" + "1. Ver clientes\n" + "2. Crear cliente\n"
												+ "3. Modificar cliente\n" + "4. Borrar cliente\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());

								switch (r) {
								case 1:
									Agencia2BD.selectClientes();
									break;
								case 2:
									Agencia2BD.insertarCliente();
									break;
								case 3:
									Agencia2BD.modificarCliente();
									break;
								case 4:
									Agencia2BD.borrarCliente();
									break;
								case 5:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}

							} while (r != 5);
							break;
						case 4:
							do {
								System.out.println("Bienvenido a base de datos:\n" + "1. Ver datos de la BBDDD\n"
										+ "2. Datos de las tablas\n" + "3. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
								switch (r) {
								case 1:
									Agencia2BD.datosBBDD();
									break;
								case 2:
									Agencia2BD.datosTablas();
									break;
								case 3:
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}

							} while (r != 3);
							break;
						case 5:
							break;
						default:
							System.out.println("Tiene que ser una de las opciones validas");
							break;
						}
						
					} while (r2 != 5);
					break;
				case 3:
					int r4;
					do {
						System.out.println("Bienvenido a la agencia 3, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						r4 = Integer.parseInt(br.readLine());
					} while (r4 != 5);
					break;
				case 4:
					break;
				default:
					System.out.println("Tiene que ser una de las opciones validas");
					break;
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				System.out.println("Error tiene que ser un numero!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (rMenu != 4);
		System.out.println("Adios");

	}

}
