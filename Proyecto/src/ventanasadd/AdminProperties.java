package ventanasadd;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class AdminProperties {
	 static Properties prop = new Properties();
	public static void lectura() {
		try (FileReader reader = new FileReader("prueba.properties")) {
			prop.load(reader);
			
			System.out.format("dirImg: %s%n", prop.getProperty("dirImg"));
            System.out.format("dirCan: %s%n", prop.getProperty("dirCan"));
            System.out.format("Bd: %s%n", prop.getProperty("Bd"));
			
			
		}catch (IOException e) {
			System.out.println("Error abriendo el fichero de propiedades.");
			e.printStackTrace();
		}
	}
	
	public static void escritura() {
		try (FileWriter writer = new FileWriter("nuevaprueba.properties")) {
			prop.store(writer, "Este es el nuevo fichero de configuración");
		}catch (IOException e) {
            System.out.println("No se pudo escribir el nuevo fichero de propiedades.");
        }
	}
	
	public static void main(String[] args) {
		lectura();
		escritura();
	}
}
