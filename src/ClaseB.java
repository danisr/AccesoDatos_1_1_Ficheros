import java.util.HashMap;
import java.util.Scanner;

public class ClaseB {	
	HashMap<String, String> libros = null;

	public HashMap<String, String> generarED() { // Leer teclado y generar ED
		String autor, libro;
		Scanner scan = new Scanner(System.in);
		System.out.print("¿Cuántos libros quieres introducir: ");
		int cantidad = scan.nextInt();
		scan.nextLine(); // Limpiar Buffer

		libros = new HashMap<String, String>();
		for (int i = 1; i <= cantidad; i++) {
			System.out.print("Introduzca el " + i + "º autor: ");
			autor = scan.nextLine();
			System.out.print("Introduzca el " + i + "º libro: ");
			libro = scan.nextLine();
			libros.put(autor, libro); // Insertar Autor y libro en HashMap
		}
		System.out.println("HashMap: " + libros.toString()); // Comprobamos HashMap
		return libros;
	}

	public boolean mostrarPantalla(HashMap<String, String> hmap) { // Recibe ED y muestra por pantalla
		if(hmap.isEmpty()) {
			return false;
		}
		
		System.out.println("Autor - Libro:");
		for (HashMap.Entry<String, String> entrada : hmap.entrySet()) {
			System.err.println(entrada.getKey() + " y " + entrada.getValue());
		}
		return true;
	}
}