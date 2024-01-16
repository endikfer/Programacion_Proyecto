package gui;

import java.util.Collections;
import javax.swing.table.DefaultTableModel;

import domain.Cancion;

public class OrdenarTabla {
	public GestorCanciones gs;
	public VentanaPrincipal ventana;
	public CambioSegundoMinuto csm;
	
	public OrdenarTabla(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	@SuppressWarnings("static-access")
	public void ordenarLista(int opcionSeleccionada) {
		gs = new GestorCanciones();
		csm = new CambioSegundoMinuto();
		
		DefaultTableModel a = (DefaultTableModel) ventana.tabla_canciones.getModel();

		switch (opcionSeleccionada) {
		case 0: // A a la Z
			Collections.sort(gs.obtenerCanciones());
			a.setRowCount(0);
			for(Cancion c: gs.obtenerCanciones()) {
	        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
	        }
			break;
		case 1: // De Z a la A
			Collections.sort(gs.obtenerCanciones(), Collections.reverseOrder());
			a.setRowCount(0);
			for(Cancion c: gs.obtenerCanciones()) {
	        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
	        }
			break;
		case 2: // Máxima duración a mínima (por ejemplo, longitud de strings)
			Collections.sort(gs.obtenerCanciones(), new ComparadorDura());
			a.setRowCount(0);
			for(Cancion c: gs.obtenerCanciones()) {
	        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
	        }
			break;
		case 3: // Mínima duración a máxima (por ejemplo, longitud de strings)
			Collections.sort(gs.obtenerCanciones(), new ComparadorDura());
			Collections.reverse(gs.obtenerCanciones());
			a.setRowCount(0);
			for(Cancion c: gs.obtenerCanciones()) {
	        	a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
	        }
			break;
		default:
			break;
		}
	}
}