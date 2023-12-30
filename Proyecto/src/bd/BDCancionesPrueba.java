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
            for (int i = 1; i <= 15; i++) {
            	Random random = new Random();
                Cancion c = new Cancion();
                c.setName_can("nombre" + i);
                c.setNombre_Ar("artista" + i);
                c.setDuration(random.nextInt(500));
                c.setAlbum("album" + i);
                

                // Se guarda el Cancion en la base de datos y
                dbManager.guardarCan(c);
                System.out.println("Hola");
            }


            // Recuperamos un Cancion de la base de datos.
            // se crea de cero al iniciar el programa
            System.out.println("Recuperando cancion con nombre 'nombre2'");
            Cancion can = dbManager.getCancion("nombre2");
            System.out.println("Cancion recuperado: " + can);

            // Se borra el usuario recuperado.
//            dbManager.eliminarCan(can);

            // Se recuperan todos los Cancion de la base de datos
            // en una lista. Comprobamos que se ha borrado el Cancion '2'
            // y que se ha modificado el Cancion '3'.
            List<Cancion> canc = dbManager.getAllCanciones();
            for (Cancion c1 : canc) {
                System.out.println("Cancion en la base de datos");
                System.out.println(c1);
            }

            // Al terminar se borra la tabla de Cancion de la base de datos.
            // Esto no es lo normal ya que queremos que los datos se mantengan
            // entre ejecuciones del programa, pero sirve como ejemplo.
//            dbManager.EliminarTablaCanc();

            // Se cierra la conexión a la base de datos.
            dbManager.disconnect();

        } catch (BDExcepcion e) {
            System.out.println("Error. Se ha producido un error al acceder a la base de datos.");
            // Imprimimos la pila de llamadas para poder depurar los posibles errores.
            e.printStackTrace();
        }

	}


}
