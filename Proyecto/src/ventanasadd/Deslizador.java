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
						ventana.duracion_can.setValue(valorActual);
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

}
