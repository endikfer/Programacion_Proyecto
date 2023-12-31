package bd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import canciones.Artista;
import canciones.Cancion;

public class BDCancionesPrueba {
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		BDCanciones dbManager = new BDCanciones();
        try {
            System.out.println("Conectando con la base de datos...");
            dbManager.connect("Usuario.db");
            dbManager.EliminarTablaCanc();
            // Creamos la tabla de Cancion al iniciar el programa.
            dbManager.CrearTablaCanc();

            // Vamos a insertar 5 Cancion .
            System.out.println("Introduciendo Cancniones ...");
            Cancion cancion = new Cancion();
            cancion.setName_can("She Don't give a Fo");
            cancion.setNombre_Ar("Duki");
            cancion.setDuration(230);
            cancion.setAlbum("Temporada de diablo II");
            Cancion cancion1 = new Cancion();
            cancion1.setName_can("Givenchy");
            cancion1.setNombre_Ar("Duki");
            cancion1.setDuration(230);
            cancion1.setAlbum("Temporada de diablo II");
            dbManager.guardarCan(cancion);
            dbManager.guardarCan(cancion1); 
            System.out.println("Cancniones añadidas");

            // Se cierra la conexión a la base de datos.
            dbManager.disconnect();

        } catch (BDExcepcion e) {
            System.out.println("Error. Se ha producido un error al acceder a la base de datos.");
            // Imprimimos la pila de llamadas para poder depurar los posibles errores.
            e.printStackTrace();
        }

	}


}
