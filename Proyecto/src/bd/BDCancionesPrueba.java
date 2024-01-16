package bd;

import modelos.Cancion;

public class BDCancionesPrueba {
	

	public static void main(String[] args) {
		BDCanciones dbManager = new BDCanciones();
        try {
            System.out.println("Conectando con la base de datos...");
            dbManager.connect("Usuario.db");
            // Creamos la tabla de Cancion al iniciar el programa.

            // Vamos a insertar 5 Cancion .
            System.out.println("Introduciendo Canciones ...");
            
            Cancion cancion = new Cancion();
            cancion.setName_can("A Veces");
            cancion.setNombre_Ar("Paulo Londra");
            cancion.setDuration(191);
            cancion.setAlbum("Back to the Game");
            
            Cancion cancion1 = new Cancion();
            cancion1.setName_can("La Inocente");
            cancion1.setNombre_Ar("Mora");
            cancion1.setDuration(201);
            cancion1.setAlbum("MicroDosis");
            
            Cancion cancion2 = new Cancion();
            cancion2.setName_can("Madrid City");
            cancion2.setNombre_Ar("Ana Mena");
            cancion2.setDuration(172);
            cancion2.setAlbum("Madrid City");
            
            Cancion cancion3 = new Cancion();
            cancion3.setName_can("Mariposas");
            cancion3.setNombre_Ar("Aitana");
            cancion3.setDuration(172);
            cancion3.setAlbum("Estate Canzoni per bambini");
            
            
            Cancion cancion5 = new Cancion();
            cancion5.setName_can("Memorias");
            cancion5.setNombre_Ar("Mora");
            cancion5.setDuration(228);
            cancion5.setAlbum("MicroDosis");
            
            Cancion cancion6 = new Cancion();
            cancion6.setName_can("MonAmour Remix");
            cancion6.setNombre_Ar("Aitana");
            cancion6.setDuration(180);
            cancion6.setAlbum("New Global Hot Hits");
            
            Cancion cancion7 = new Cancion();
            cancion7.setName_can("Playa del Ingles");
            cancion7.setNombre_Ar("Quevedo");
            cancion7.setDuration(237);
            cancion7.setAlbum("Donde quiero estar");
            
            Cancion cancion8 = new Cancion();
            cancion8.setName_can("Punto G");
            cancion8.setNombre_Ar("Quevedo");
            cancion8.setDuration(155);
            cancion8.setAlbum("Donde quiero estar");
            
            Cancion cancion9 = new Cancion();
            cancion9.setName_can("Quiero Decirte");
            cancion9.setNombre_Ar("Ana Mena");
            cancion9.setDuration(223);
            cancion9.setAlbum("Quiero decirte");
            
            Cancion cancion10 = new Cancion();
            cancion10.setName_can("Te Pintaron Pajaritos");
            cancion10.setNombre_Ar("Andy Rivera");
            cancion10.setDuration(172);
            cancion10.setAlbum("La rumba del año");
            
            Cancion cancion11 = new Cancion();
            cancion11.setName_can("Givenchy");
            cancion11.setNombre_Ar("Duki");
            cancion11.setDuration(225);
            cancion11.setAlbum("Temporada de reggaetón 2");
            
            Cancion cancion12 = new Cancion();
            cancion12.setName_can("She Don't Give a Fo");
            cancion12.setNombre_Ar("Duki");
            cancion12.setDuration(230);
            cancion12.setAlbum("She Don't Give a Fo");
            
            
            
            
            dbManager.EliminarTablaCanc();
            
            dbManager.CrearTablaCanc();
            
            dbManager.guardarCan(cancion);
            dbManager.guardarCan(cancion1);
            dbManager.guardarCan(cancion2);
            dbManager.guardarCan(cancion3);
            dbManager.guardarCan(cancion5);
            dbManager.guardarCan(cancion6);
            dbManager.guardarCan(cancion7);
            dbManager.guardarCan(cancion8);
            dbManager.guardarCan(cancion9);
            dbManager.guardarCan(cancion10);
            dbManager.guardarCan(cancion11);
            dbManager.guardarCan(cancion12);
            

            // Se cierra la conexión a la base de datos.
            dbManager.disconnect();

        } catch (BDExcepcion e) {
            System.out.println("Error. Se ha producido un error al acceder a la base de datos.");
            // Imprimimos la pila de llamadas para poder depurar los posibles errores.
            e.printStackTrace();
        }

	}


}
