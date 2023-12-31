package ventanasadd;

import java.util.ArrayList;
import java.util.List;

import bd.BDCanciones;
import bd.BDExcepcion;
import canciones.Cancion;

public class GestorCanciones {

	BDCanciones bdc;


	private List<Cancion> canciones;

	public GestorCanciones() {
		bdc = new BDCanciones();
		canciones = new ArrayList<>();

		try {
			bdc.connect("Usuario.db");
			canciones = bdc.getAllCanciones();
			bdc.disconnect();
			
		} catch (BDExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Cancion> obtenerCanciones() {
		return canciones;
	}
}
