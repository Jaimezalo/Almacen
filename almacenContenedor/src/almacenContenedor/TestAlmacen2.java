package almacenContenedor;

import java.util.Scanner;

import almacenContenedor.Almacen2;

/**
 * Clase principal para testear la clase Almacen2
 * @author Jaime Zaloña
 * @since 01/01/2019
 *
 */
public class TestAlmacen2 {

	static public void main(String[] argv) {

		Almacen2 prueba = new Almacen2(); /* Creacion de una instancia */
		Scanner sc = new Scanner(System.in);
		int opcion;
		int valor = 0; /* Variable que sera usada para poner o quitar valores en el almacen */

		mostrarMenu();
		opcion = sc.nextInt(); /* El usuario elige una opcion del menu */
		while (opcion != 0) {
			procesarOpcion(opcion, valor, prueba);
			mostrarMenu();
			opcion = sc.nextInt();
		}
		System.out.println();
		System.out.println("CONTROL DEL ALMACEN FINALIZADO");
		sc.close();
		
	}
	

	/**
	 * Muestra en pantalla el menu con las diferentes opciones
	 */
	static void mostrarMenu() {
		System.out.println("--- MENÚ DE  CONTROL DEL ALMACÉN -----");
		System.out.println(" 1.- Mostrar contenido del Almacén");
		System.out.println(" 2.- Poner un Valor  ");
		System.out.println(" 3.- Buscar un Valor ");
		System.out.println(" 4.- Borrar un Valor");
		System.out.println(" 5.- Contar posiciones ocupadas.");
		System.out.println(" 6.- Contar posiciones libres.");
		System.out.println(" 0.- Terminar");
     System.out.print(" Introduzca una opción:[1-6]:");
	}


	/**
	 * Procesa la opción introducida operando sobre el objeto Almacen1.
	 * @param opcion Valor introducido por el usuario para seleccionar una opción del menú.
	 * @param valor Variable que sera usada para poner o quitar valores en el almacen.
	 * @param parAlmacen Llamada a un método de la clase Almacen1.
	 */
	static void procesarOpcion(int opcion, int valor, Almacen2 parAlmacen) {

		switch (opcion) {
		case 1:
			System.out.println();
			System.out.println("Contenido del almacen = " + parAlmacen.toString());
			break;
		case 2:
			System.out.println();
			System.out.println("Introduzca un valor = " + parAlmacen.ponValor(valor));
			break;
		case 3:
			System.out.println();
			System.out.println("Esta el valor = " + parAlmacen.estaValor(valor));
			break;
		case 4:
			System.out.println();
			System.out.println("Introduzca un valor = " + parAlmacen.sacarValor(valor));
		case 5:
			System.out.println();
			System.out.println("Posiciones ocupadas = " + parAlmacen.numPosicionesOcupadas());
			break;
		case 6:
			System.out.println();
			System.out.println(" Posiciones libres = " + parAlmacen.numPosicionesLibres());
			break;
		default:
			System.out.println();
			System.out.println("Opcion incorrecta");

		}

	}

}

