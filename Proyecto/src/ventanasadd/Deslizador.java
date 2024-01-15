package ventanasadd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import ventanas.VentanaPrincipal;

public class Deslizador {
	public int valorActual = 0;
	private int incremento = 1;
	private Timer timer;
	public CambioSegundoMinuto cambiosecmin;

	private VentanaPrincipal ventana;

	public Deslizador(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void deslizador1(boolean activador) {
		cambiosecmin = new CambioSegundoMinuto();
		// Si el temporizador no se ha creado previamente, crearlo
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (valorActual != ventana.tiempo) {
						valorActual += incremento;
						System.out.println(valorActual);
						ventana.duracion_can.setValue(valorActual);
						System.out.println(ventana.duracion_can.getValue());
						ventana.t_duracion.setText(CambioSegundoMinuto.cambioSec(valorActual));
					}else {
						ventana.activador = false;
					}
					if(valorActual >= ventana.tiempo) {
						timer.stop();
						Reproductor.pause();
						ventana.b_pausar_can.setIcon(ventana.i_play);
						ventana.activador = false;
					}
				}
			});
		}
		if (activador) {
			timer.start();
		} else {
			timer.stop();
		}
	}
	
	public void reiniciarDeslizador() {
	    valorActual = 0;
	    ventana.duracion_can.setValue(valorActual);
	    ventana.t_duracion.setText(CambioSegundoMinuto.cambioSec(valorActual));
	}
	
	public void finalizarDeslizador() {
		valorActual = ventana.tiempo;
		ventana.duracion_can.setValue(valorActual);
	    ventana.t_duracion.setText(CambioSegundoMinuto.cambioSec(valorActual));
	}

}
