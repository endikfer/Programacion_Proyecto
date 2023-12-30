package ventanasadd;

import java.awt.event.KeyEvent;

import ventanas.VentanaPrincipal;

public class TogleBoton {

	private VentanaPrincipal ventana;

	public TogleBoton(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void ActivarBarraEspaciadora() {
		if (ventana.t_barra.isSelected()) {
			ventana.b_pausar_can.setMnemonic(KeyEvent.VK_ENTER);
		}else {
			ventana.b_pausar_can.setMnemonic(0);
		}
	}


	public void ActivarFlechaDerecha() {
		if (ventana.t_flecha.isSelected()) {
			ventana.b_adelantar_can.setMnemonic(KeyEvent.VK_RIGHT);
		}else {
			ventana.b_adelantar_can.setMnemonic(0);
		}
	}


	public void ActivarFlechaIzquierda() {
		if (ventana.t_flecha.isSelected()) {
			ventana.b_atras_can.setMnemonic(KeyEvent.VK_LEFT);
		}else {
			ventana.b_atras_can.setMnemonic(0);
		}
	}

}
