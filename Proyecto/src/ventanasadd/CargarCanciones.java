package ventanasadd;

import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import canciones.Cancion;
import canciones.ContenedorCanciones;

public class CargarCanciones {
	CambioSegundoMinuto csm;
	GestorCanciones gs;
	
	//metodo para lo por defecto de la tabla de canciones
	
	@SuppressWarnings("static-access")
	public DefaultTableModel cargar_modelo_tabla_canciones(DefaultTableModel a){
		csm = new CambioSegundoMinuto();
		gs = new GestorCanciones();
		
		a.addColumn("Nomber");
		a.addColumn("Autor");
		a.addColumn("Álbum");
		a.addColumn("Duracion");
		for(Cancion c: ContenedorCanciones.canciones) {
			a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
		}
		
		
		Collections.sort(gs.obtenerCanciones());
		for(Cancion c: gs.obtenerCanciones()) {
        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
        }
        
		return a;
	}

}
