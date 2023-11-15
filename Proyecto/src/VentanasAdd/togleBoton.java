package VentanasAdd;

import java.awt.event.KeyEvent;

import Ventanas.VentanaPrincipal;

public class togleBoton {

	private VentanaPrincipal ventana;

	public togleBoton(VentanaPrincipal ventana) {
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
			ventana.b_pausar_can.setMnemonic(KeyEvent.VK_RIGHT);
		}else {
			ventana.b_pausar_can.setMnemonic(0);
		}
	}


	public void ActivarFlechaIzquierda() {
		if (ventana.t_flecha.isSelected()) {
			ventana.b_pausar_can.setMnemonic(KeyEvent.VK_LEFT);
		}else {
			ventana.b_pausar_can.setMnemonic(0);
		}
	}

}
