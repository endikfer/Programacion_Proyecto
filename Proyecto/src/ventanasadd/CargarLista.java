package ventanasadd;

import javax.swing.DefaultListModel;
import canciones.Cancion;
import ventanas.VentanaPrincipal;

public class CargarLista {
	
	public CambioSegundoMinuto csm;
	public VentanaPrincipal ventana;
	
	public CargarLista(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "static-access" })
	public DefaultListModel cargar_modelo_lista(DefaultListModel a){
		csm = new CambioSegundoMinuto();
		
		for(Cancion c: ventana.ColaCancion) {
//        	a.addElement(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum(), csm.cambioSec(c.getDuration())});
        	a.addElement(c.getName_can());
        }
        System.out.println(a);
		return a;
	}

}
