package ventanasadd;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import bd.BDCanciones;
import bd.BDExcepcion;
import canciones.Cancion;
import canciones.ContenedorCanciones;

public class CargarCanciones {
	BDCanciones bdc;
	CambioSegundoMinuto csm;
	
	//metodo para lo por defecto de la tabla de canciones
	
	@SuppressWarnings("static-access")
	public DefaultTableModel cargar_modelo_tabla_canciones(DefaultTableModel a){
		bdc = new BDCanciones();
		csm = new CambioSegundoMinuto();
		
		a.addColumn("Nomber");
		a.addColumn("Autor");
		a.addColumn("Álbum");
		a.addColumn("Duracion");
		for(Cancion c: ContenedorCanciones.canciones) {
			a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
		}
		
		
        try {
			bdc.connect("Usuario.db");
			List<Cancion> canciones = bdc.getAllCanciones();
			for(Cancion c: canciones) {
	        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
	        }
			bdc.disconnect();
			
		} catch (BDExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return a;
	}

}
