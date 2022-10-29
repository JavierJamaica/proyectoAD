/**
 * 
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 17 oct 2022 - 19:50:48
 */
public class Main {

	public static void main(String[] args) throws ParseException {
		int rMenu = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			do {
				System.out.println("Bienvenido al gestor de agencias");

				System.out.println("Elige la agencia a la que quieres ir \n" + "1. Agencia 1.\n" + "2. Agencia 2.\n"
						+ "3. Agencia 3.\n" + "4. Salir.");
				System.out.print("Opcion: ");

				rMenu = Integer.parseInt(br.readLine());
				switch (rMenu) {
				case 1:
					int r;
					do {
						System.out.println("Bienvenido a la agencia 1, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						r = Integer.parseInt(br.readLine());
						switch (r) {
						case 1:
							do {
								System.out.println("Bienvenido a visitas:\n" + "1. Ver visitas\n" + "2. Crear visita\n"
										+ "3. Modificar visita\n" + "4. Borrar visita\n" + "5. Atras");
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
									break;
								default:
									System.out.println("Tiene que ser una de las opciones validas");
									break;
								}
							} while (r != 5);
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
								System.out.println("Bienvenido a visitas:\n" + "1. Ver visitas\n" + "2. Crear visita\n"
										+ "3. Modificar visita\n" + "4. Borrar visita\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
							} while (r != 5);
							break;
						case 4:
							do {
								System.out.println("Bienvenido a visitas:\n" + "1. Ver visitas\n" + "2. Crear visita\n"
										+ "3. Modificar visita\n" + "4. Borrar visita\n" + "5. Atras");
								System.out.println("Opcion: ");
								r = Integer.parseInt(br.readLine());
							} while (r != 5);
							break;
						case 5:
							break;
						default:
							System.out.println("Tiene que ser una de las opciones validas");
							break;
						}
					} while (r != 5);
					break;
				case 2:
					int r2;
					do {
						System.out.println("Bienvenido a la agencia 1, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						r2 = Integer.parseInt(br.readLine());
					} while (r2 != 5);
					break;
				case 3:
					int r3;
					do {
						System.out.println("Bienvenido a la agencia 1, que deseas hacer? \n" + "1. Visitas\n"
								+ "2. Empleados\n" + "3. Clientes\n" + "4. Datos BD\n" + "5. Salir");
						r3 = Integer.parseInt(br.readLine());
					} while (r3 != 5);
					break;
				case 4:
					break;
				default:
					System.out.println("Tiene que ser una de las opciones validas");
					break;
				}
			} while (rMenu != 4);
			System.out.println("Adios");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Error tiene que ser un numero!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
