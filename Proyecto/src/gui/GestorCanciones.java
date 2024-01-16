package gui;

import java.util.ArrayList;
import java.util.List;

import db.BDCanciones;
import db.BDExcepcion;
import domain.Cancion;

public class GestorCanciones {
	public BDCanciones bdc;
	private List<Cancion> canciones;

	public GestorCanciones() {
		bdc = new BDCanciones();
		canciones = new ArrayList<>();

		try {
			bdc.connect("resources/db/Usuario.db");
			canciones = bdc.getAllCanciones();
			bdc.disconnect();
		} catch (BDExcepcion e) {
			Loggers.logger.warning("Error al conectar con la BD");
		}
	}

	public List<Cancion> obtenerCanciones() {
		return canciones;
	}
}