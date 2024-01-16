package ventanasadd;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import canciones.Cancion;
import ventanas.VentanaPrincipal;

public class CargarLista {
	public CambioSegundoMinuto csm;
	public VentanaPrincipal ventana;

	public CargarLista(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	ArrayList<String> lista_canciones = new ArrayList<>();

	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public DefaultListModel cargar_modelo_lista(DefaultListModel a){
		csm = new CambioSegundoMinuto();

		for(Cancion c: ventana.ColaCancion) {
			// Verifica si la canción ya está en lista_canciones antes de agregarla
	        if (!lista_canciones.contains(c.getName_can())) {
	            a.addElement((c.getName_can() + ", " + c.getNombre_Ar() + ", " + c.getAlbum() + ", " + csm.cambioSec(c.getDuration())));
	            lista_canciones.add(c.getName_can());
	        }
		}
		return a;
	}
}