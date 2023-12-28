package ventanasadd;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import ventanas.VentanaPrincipal;

public class Listeners {

	private VentanaPrincipal ventana;

	private TogleBoton togle;

	private CambiarFondo cambiarfondo = new CambiarFondo();
	private OrdenarTabla OT;
	private BuscarEnTabla buscar;

	public Listeners(VentanaPrincipal ventana) {
		this.ventana = ventana;
		inicializarOT();
		inicializarBuscar();
	}


	private void inicializarOT() {
		OT = new OrdenarTabla(ventana);
	}
	
	private void inicializarBuscar() {
		buscar = new BuscarEnTabla(ventana);
	}

	//listeners de los botones
	//para el boton perfil
	public ActionListener BotonPerfilListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.centro.removeAll();
				ventana.centro.add(ventana.p_perfil);
				ventana.centro.revalidate();
				ventana.centro.repaint();
			}
		};
	}

	//para el boton canciones
	public ActionListener BotonCancionListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.centro.removeAll();
				ventana.centro.add(ventana.p_canciones);
				ventana.centro.revalidate();
				ventana.centro.repaint();
			}
		};
	}

	//para el boton cola
	public ActionListener BotonColaListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.centro.removeAll();
				ventana.centro.add(ventana.p_cola);
				ventana.centro.revalidate();
				ventana.centro.repaint();
			}
		};
	}

	//para el boton ajuste
	public ActionListener BotonAjustesListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.centro.removeAll();
				ventana.centro.add(ventana.p_ajustes);
				ventana.centro.revalidate();
				ventana.centro.repaint();
			}
		};
	}




	//Listener del radiobutton
	public ActionListener BotonVisuContraListener() {
		return new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ventana.b_contra.isSelected()) {
					ventana.p_contra.remove(ventana.p_contra_f);
					Font font = ventana.p_contra_f.getFont();
					ventana.t_contra.setFont(font.deriveFont(font.getSize() + 10f));
					ventana.t_contra.setText(ventana.p_contra_f.getText());
					ventana.p_contra.add(ventana.t_contra, BorderLayout.CENTER);
				}else {
					ventana.p_contra.remove(ventana.t_contra);
					ventana.p_contra.add(ventana.p_contra_f, BorderLayout.CENTER);
				}

				ventana.p_contra.revalidate();
				ventana.p_contra.repaint();
			}
		};
	}



	//listener de los toglebotons
	//fondo oscuro
	public ActionListener ToggleFondoOscuroListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cambiarfondo.cambiarFondonegro(ventana);
			}
		};
	}


	//flecha izq
	public ActionListener ToggleFlechaIzqListener() {
		togle = new TogleBoton(ventana);
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				togle.ActivarFlechaIzquierda();
			}
		};
	}

	//flecha dere
	public ActionListener ToggleFlechaDereListener() {
		togle = new TogleBoton(ventana);
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				togle.ActivarFlechaDerecha();
			}
		};
	}

	//barra espaciadora
	public ActionListener ToggleBarraEspaciadoraListener() {
		togle = new TogleBoton(ventana);
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				togle.ActivarBarraEspaciadora();
			}
		};
	}

	public ActionListener BotonPausarFlechaIzqListener() {
		togle = new TogleBoton(ventana);
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
	}

	public ActionListener BotonPausarFlechaDereListener() {
		togle = new TogleBoton(ventana);
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		};
	}

	public WindowListener PararCancionesAlCerrar() {

		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				super.windowClosing(e);
				// Aquí detienes el reproductor
				Reproductor.pause();
			}
		});
		return null;
	}



	//Ordenar JComboBox
	public ActionListener OrdenarCombo() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				int selectedOption =  ventana.orden.getSelectedIndex();
				// Aquí obtienes el criterio de orden seleccionado y actualizas la tabla
				OT.ordenarLista(selectedOption);
			}
		};
	}

	//Funicionamiento Barra de Busqueda
	public ActionListener BarraBusq() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				buscar.Buscar();
			}
		};
	}

}
