import java.util.HashMap;
import java.util.Scanner;

public class Intermediario {
	ClaseA encargadoFicheros;
	ClaseB engargadoTecladoPantalla;
	Scanner teclado;

	public Intermediario() {
		teclado = new Scanner(System.in);
		encargadoFicheros = new ClaseA();
		engargadoTecladoPantalla = new ClaseB();
	}

	public void ejecucion() {
		int opcion = 0;
		boolean salir = false;

		while (!salir) {
			System.out.println("1- Leer de fichero y escribir en pantalla \n"
							 + "2- Leer de teclado y escribir en fichero \n" 
							 + "3- Salir");
			try {
				opcion = teclado.nextInt();
				System.out.println("OPCION SELECCIONADA: " + opcion);
				switch (opcion) {
				case 1:
					leerFicheroPantalla();
					break;
				case 2:
					leerTecladoFichero();
					break;
				case 3:
					salir = true;
					break;
				default:
					System.out.println("Opcion invalida: marque un numero de 1 a 3");
					break;
				}
			} catch (Exception e) {
				System.out.println("Excepcion por opcion invalida: marque un numero de 1 a 3");
				// flushing scanner
				e.printStackTrace();
				teclado.nextLine();
			}
		}
		teclado.close();
	}

	public void leerFicheroPantalla() {
		System.out.println("Pasamos datos de fichero a pantalla");
		HashMap<String, String> ed = encargadoFicheros.leerFichero();
		boolean ok = engargadoTecladoPantalla.mostrarPantalla(ed);
		if (ok) {
			System.out.println("Se han mostrado correctamente los datos del fichero por pantalla");
		} else {
			System.out.println("Ha ocurrido un error");
		}
	}

	public void leerTecladoFichero() {
		System.out.println("Pasamos datos de teclado a fichero");
		HashMap<String, String> hm = engargadoTecladoPantalla.generarED();
		boolean ok = encargadoFicheros.crearFichero(hm);
		if (ok) {
			System.out.println("Se han escrito correctamente los datos en el fichero");
		} else {
			System.out.println("Ha ocurrido un error");
		}
	}
}