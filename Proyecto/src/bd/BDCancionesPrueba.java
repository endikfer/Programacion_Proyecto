package bd;

import java.util.List;
import java.util.Random;

import canciones.Cancion;

public class BDCancionesPrueba {
	

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		BDCanciones dbManager = new BDCanciones();
        try {
            System.out.println("Conectando con la base de datos...");
            dbManager.connect("src/bd/Usuario.db");
            // Creamos la tabla de Cancion al iniciar el programa.
            dbManager.CrearTablaCanc();

            // Vamos a insertar 5 Cancion .
            System.out.println("Introduciendo Cancniones ...");
            for (int i = 1; i <= 5; i++) {
            	Random random = new Random();
                Cancion c = new Cancion();
                c.setName_can("Nombre" + i);
                c.setNombre_Ar("Artista" + i);
                c.setDuration(random.nextInt(500));
                c.setAlbum("Album" + i);
                

                // Se guarda el Cancion en la base de datos y
                dbManager.guardarCan(c);

            }

            // Recuperamos un Cancion de la base de datos.
            // se crea de cero al iniciar el programa
            System.out.println("Recuperando usuario con id '2'");
            Cancion can = dbManager.getCancion("Nombre2");
            System.out.println("Usuario recuperado: " + can);

            // Se borra el usuario recuperado.
            dbManager.eliminarCan(can);

            // Se recuperan todos los Cancion de la base de datos
            // en una lista. Comprobamos que se ha borrado el Cancion '2'
            // y que se ha modificado el Cancion '3'.
            List<Cancion> canc = dbManager.getAllCanciones();
            for (Cancion c : canc) {
                System.out.println("Cancion en la base de datos");
                System.out.println(c);
            }

            // Al terminar se borra la tabla de Cancion de la base de datos.
            // Esto no es lo normal ya que queremos que los datos se mantengan
            // entre ejecuciones del programa, pero sirve como ejemplo.
            dbManager.EliminarTablaCanc();


            // Se cierra la conexión a la base de datos.
            dbManager.disconnect();

        } catch (BDExcepcion e) {
            System.out.println("Error. Se ha producido un error al acceder a la base de datos.");
            // Imprimimos la pila de llamadas para poder depurar los posibles errores.
            e.printStackTrace();
        }

	}


}
