package ventanasadd;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import bd.BDCanciones;
import bd.BDExcepcion;
import canciones.Cancion;
import ventanas.VentanaPrincipal;

public class SiguienteCancion {
	public VentanaPrincipal ventana;
	public GestorCanciones gestorCan;
	BDCanciones bdc;
	Properties properties;

	
	public void CancionSig() {
		try (FileReader reader = new FileReader("configuracion.properties")) {
			if(ventana.ColaCancion.size() > 0) {
				properties.load(reader);
				Reproductor.close();

				try {
					bdc.connect("Usuario.db");
					String nombreCan = ventana.CancionEjectuda;
					Cancion c = bdc.getCancion(nombreCan);
					int posicion = ventana.ColaCancion.indexOf(c);
					if (posicion+1 < ventana.ColaCancion.size()) {
						Cancion c1 = ventana.ColaCancion.get(posicion+1);
						ventana.CancionEjectuda = c1.getName_can();
						File a = new File(properties.getProperty("dirCan") + c1.getName_can() + ".wav");
						ventana.deslizador.reiniciarDeslizador();
						Reproductor.reproduce(a);
					} else if (ventana.t_bucle.isSelected()) {
						posicion = 0;
						Cancion c1 = ventana.ColaCancion.get(posicion);
						ventana.CancionEjectuda = c1.getName_can();
						File a = new File(properties.getProperty("dirCan") + c1.getName_can() + ".wav");
						ventana.deslizador.reiniciarDeslizador();
						Reproductor.reproduce(a);
					}
				} catch (BDExcepcion e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			} else {
				ventana.deslizador.finalizarDeslizador();
				Reproductor.close();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
	}

}
