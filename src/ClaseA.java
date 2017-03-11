import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class ClaseA {
	HashMap<String, String> hmap = null;
	BufferedReader breader = null;
	BufferedWriter bwriter = null;
	FileReader fReader = null;
	File archivo = null;

	public HashMap<String, String> leerFichero() {// Leer fichero y generar ED
		hmap = new HashMap<String, String>();
				
		try {
			archivo = new File("fichero.txt");
			fReader = new FileReader(archivo);
			breader = new BufferedReader(fReader);
			String line;
			while ((line = breader.readLine()) != null) {
				String[] aux = line.split(";");
				String autor = aux[0];
				String obra = aux[1];
				hmap.put(autor, obra);
			}
			breader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hmap;
	}
		
	public boolean crearFichero(HashMap<String, String> hmap) {// Leer ED y escribir fichero
		archivo = new File("fichero.txt");
		
		try {
			bwriter = new BufferedWriter(new FileWriter(archivo));
			for (HashMap.Entry<String, String> entrada : hmap.entrySet()) {
				bwriter.write(entrada.getKey() + ";" + entrada.getValue());
				bwriter.newLine();
				System.err.println("Metodo Crear Fichero: " + entrada.getKey() + ";" + entrada.getValue());
			}
			bwriter.close();
		} catch (IOException e1) {
			System.out.println(e1.getMessage());
		} 
		return true;
	}	
}