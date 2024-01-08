package ventanasadd;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import bd.BDCanciones;
import bd.BDExcepcion;
import canciones.Cancion;
import ventanas.VentanaPrincipal;

public class Listeners {

	public VentanaPrincipal ventana;
	public GestorCanciones gestorCan;
	BDCanciones bdc;

	private TogleBoton togle;

	private CambiarFondo cambiarfondo = new CambiarFondo();
	private OrdenarTabla OT;
	private BuscarEnTabla buscar;
	Properties properties;

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
	
	
	public ActionListener BotonPausarActivarBarra() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ventana.activador==false) {
					ventana.activador = true;
					//cambio de la imagen del boton
					ventana.b_pausar_can.setIcon(ventana.i_pausar);
					ventana.deslizador.deslizador1(ventana.activador);
					//que el reporductor se active
					Reproductor.play();
				}else {
					ventana.activador = false;
					//cambio de la imagen del boton
					ventana.b_pausar_can.setIcon(ventana.i_play);
					ventana.deslizador.deslizador1(ventana.activador);
					//que el reproductor se pare
					Reproductor.pause();

				}
			}
		};
	}

	public ActionListener BotonPausarFlechaIzqListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.deslizador.reiniciarDeslizador();
				Reproductor.restart();
			}
		};
	}

	public ActionListener BotonPausarFlechaDereListener() {
		properties = new Properties();
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (FileReader reader = new FileReader("configuracion.properties")) {
					if(ventana.canciones.size() > 1) {
					properties.load(reader);
					Reproductor.close();
					//hay que meter la lista de canciones para que coja la siguiente cancione
					File a = new File(properties.getProperty("dirCan") + "She Don't Give a Fo.wav");
					ventana.deslizador.reiniciarDeslizador();
					Reproductor.reproduce(a);
					} else {
						properties.load(reader);
						ventana.deslizador.finalizarDeslizador();
						Reproductor.close();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
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
	

	
	 public ActionListener Agregarcan() {
	        return new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	bdc = new BDCanciones();
	                int selectedRow = ventana.tabla_canciones.getSelectedRow();
	                if (selectedRow == -1) {
	                	JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ninguna canción.", "Error", JOptionPane.ERROR_MESSAGE);
	                } else {
	                	String nombreCan = (String) ventana.tabla_canciones.getValueAt(selectedRow, 0);
	                	Cancion c = null;
	                	try {
	                		bdc.connect("Usuario.db");
	                		c= bdc.getCancion(nombreCan);
	                		bdc.disconnect();

	                	} catch (BDExcepcion e1) {
	                		// TODO Auto-generated catch block
	                		e1.printStackTrace();
	                	}
	                	for (Cancion c1: ventana.canciones) {
	                		if (c.getName_can().equals(c1.getName_can())) {
	                			JOptionPane.showMessageDialog(ventana, "La canción ya está en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
	                		} else {
	                			ventana.canciones.add(c);
	                			System.out.println(ventana.ColaCancion);
	                			// Update the JList or perform any other necessary actions
	                		}
	                	}
	                }
	            }
	        };
	 }
	

}
