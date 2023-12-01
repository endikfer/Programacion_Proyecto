package ventanasadd;

import javax.swing.table.DefaultTableModel;

import canciones.Cancion;
import canciones.ContenedorCanciones;

public class CargarCanciones {

	//metodo para lo por defecto de la tabla de canciones
	
	@SuppressWarnings("static-access")
	public static DefaultTableModel cargar_modelo_tabla_canciones(DefaultTableModel a){
		a.addColumn("Nomber");
		a.addColumn("Autor");
		a.addColumn("Álbum");
		for(Cancion c: ContenedorCanciones.canciones) {
			a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum()});
		}
		return a;
	}

}
