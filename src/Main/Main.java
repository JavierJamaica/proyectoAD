/**
 * 
 */
package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Javier Jamaica{javiernicolas.jamaica@ikasle.egibide.org} Ejercicio 5
 * @date 17 oct 2022 - 19:50:48
 */
public class Main {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Bienvenido al gestor de agencias");

			System.out.println("Elige la agencia a la que quieres ir \n" + "1. Agencia 1.\n" + "2. Agencia 2.\n"
					+ "3. Agencia 3.");
			System.out.print("Opcion: ");

			int rMenu = Integer.parseInt(br.readLine());
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
