package bd;


import java.util.List;
import canciones.Usuario;

public class BDprueba {

	public static void main(String[] args) {
		BDManejoUsu dbManager = new BDManejoUsu();
        try {
            System.out.println("Conectando con la base de datos...");
            dbManager.connect("Usuario.db");

            
            // Creamos la tabla de usuario al iniciar el programa.
            dbManager.CrearTablaUsu();

            // Vamos a insertar 5 usuarios con nombres, apellidos y fechas.
            System.out.println("Introduciendo usuarios ...");
            for (int i = 1; i <= 5; i++) {
                Usuario user = new Usuario();
                user.setName_real("Nombre" + i);
                user.setGmail(i + "@gmail.com");
                user.setName_us("Nombre_" + i);
                user.setPassword("Contraseña" + i);
                

                // Se guarda el usuario en la base de datos y
                // el id es generado automáticamente.
                dbManager.guardar(user);

            }

            // Recuperamos un usuario de la base de datos.
            // En este ejemplo podemos adivinar el id porque la tabla
            // se crea de cero al iniciar el programa y los ids generados
            // son consecutivos.
            System.out.println("Recuperando usuario con 'nombre2'");
            Usuario user = dbManager.getUser("Nombre2");
            System.out.println("Usuario recuperado: " + user);

            // Se borra el usuario recuperado.
//            dbManager.eliminar(user);

            // Se recuperan todos los usuarios de la base de datos
            // en una lista. Comprobamos que se ha borrado el usuario '2'
            // y que se ha modificado el usuario '3'.
            List<Usuario> users = dbManager.getTodosUsu();
            for (Usuario u : users) {
                System.out.println("Usuarios en la base de datos");
                System.out.println(u);
            }

            // Al terminar se borra la tabla de usuarios de la base de datos.
            // Esto no es lo normal ya que queremos que los datos se mantengan
            // entre ejecuciones del programa, pero sirve como ejemplo.
//            dbManager.EliminarTablaUsu();


            // Se cierra la conexión a la base de datos.
            dbManager.disconnect();

        } catch (BDExcepcion e) {
            System.out.println("Error. Se ha producido un error al acceder a la base de datos.");
            // Imprimimos la pila de llamadas para poder depurar los posibles errores.
            e.printStackTrace();
        }

	}

}
