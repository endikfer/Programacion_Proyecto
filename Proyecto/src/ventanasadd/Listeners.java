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
	BDCanciones bdc = new BDCanciones();

	private TogleBoton togle;
	public CambioSegundoMinuto csm = new CambioSegundoMinuto();

	private CambiarFondo cambiarfondo = new CambiarFondo();
	private OrdenarTabla OT;
	private BuscarEnTabla buscar;
	Properties properties;
	public CargarLista cl;
	public int posicion = 0;

	public Listeners(VentanaPrincipal ventana) {
		this.ventana = ventana;
		inicializarOT();
		inicializarBuscar();
		inicializarLista();
	}


	private void inicializarOT() {
		OT = new OrdenarTabla(ventana);
	}

	private void inicializarBuscar() {
		buscar = new BuscarEnTabla(ventana);
	}
	private void inicializarLista() {
		cl = new CargarLista(ventana);
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
				cl.cargar_modelo_lista(ventana.modelo_lista);
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
					try {
						Reproductor.play();
					}catch(Exception e1){
						e1.printStackTrace();
						JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					ventana.activador = false;
					//cambio de la imagen del boton
					ventana.b_pausar_can.setIcon(ventana.i_play);
					ventana.deslizador.deslizador1(ventana.activador);
					//que el reproductor se pare
					try {
						Reproductor.pause();
					}catch(Exception e1){
						e1.printStackTrace();
						JOptionPane.showMessageDialog(ventana, "No se pudo pausar la cancion.", "Error", JOptionPane.ERROR_MESSAGE);

					}


				}
			}
		};
	}

	public ActionListener BotonPausarFlechaIzqListener() {
		properties = new Properties();
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try (FileReader reader = new FileReader("configuracion.properties")) {


					properties.load(reader);
					ventana.deslizador.reiniciarDeslizador();
					Reproductor.close();
					ventana.activador = false;
					ventana.b_pausar_can.setIcon(ventana.i_play);
					ventana.deslizador.deslizador1(ventana.activador);
					File a = new File(properties.getProperty("dirCan") + ventana.CancionEjectuda + ".wav");
					Reproductor.reproduce(a);

				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		};
	}

	public ActionListener BotonPausarFlechaDereListener() {
		properties = new Properties();
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//				sigc.CancionSig();
				ventana.activador = false;
				ventana.b_pausar_can.setIcon(ventana.i_play);
				if(ventana.ColaCancion.size() > 0) {
					try (FileReader reader = new FileReader("configuracion.properties")) {
						properties.load(reader);
						if(ventana.ColaCancion.isEmpty()) {
							Reproductor.close();
						}
						try {
							bdc.connect("Usuario.db");
							String nombreCan = ventana.CancionEjectuda;
							Cancion c = bdc.getCancion(nombreCan);
							posicion = ventana.ColaCancion.indexOf(c);
							if (posicion+1 < ventana.ColaCancion.size()) {
								Cancion c1 = ventana.ColaCancion.get(posicion+1);
								posicion++;
								ventana.CancionEjectuda = c1.getName_can();
								File a = new File(properties.getProperty("dirCan") + c1.getName_can() + ".wav");
								ventana.deslizador.reiniciarDeslizador();
								Reproductor.close();
								Reproductor.reproduce(a);
								CambiarNombreLabel(posicion);
								CambiarTiempoLabel(posicion);
								ventana.deslizador.deslizador1(ventana.activador);
							} else if (ventana.t_bucle.isSelected()) {
								posicion = 0;
								Cancion c1 = ventana.ColaCancion.get(posicion);
								ventana.CancionEjectuda = c1.getName_can();
								File a = new File(properties.getProperty("dirCan") + c1.getName_can() + ".wav");
								ventana.deslizador.reiniciarDeslizador();
								Reproductor.close();
								Reproductor.reproduce(a);
								CambiarNombreLabel(posicion);
								CambiarTiempoLabel(posicion);
								ventana.deslizador.deslizador1(ventana.activador);
							}else {
								ventana.deslizador.finalizarDeslizador();
								Reproductor.close();
							}
						} catch (BDExcepcion e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else {
					ventana.deslizador.finalizarDeslizador();
					Reproductor.close();
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
					Boolean b = false;
					try {
						bdc.connect("Usuario.db");
						Cancion c= bdc.getCancion(nombreCan);
						if (!ventana.ColaCancion.isEmpty()) {
							for (Cancion c1: ventana.ColaCancion) {
								if (c.getName_can().equals(c1.getName_can())) {
									b = true;
									JOptionPane.showMessageDialog(ventana, "La canción ya está en la lista.", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							if( b != true) {
								ventana.ColaCancion.add(c);
							}
						}else { 
							ventana.ColaCancion.add(c);
						}
						bdc.disconnect();
					} catch (BDExcepcion e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		};
	}

	//Funicionamiento Boton eliminar cancion
	public ActionListener BotonEliminarCancion() {
		return new ActionListener() {
			@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = ventana.listaCan.getSelectedIndex();
				String cancion = ventana.listaCan.getSelectedValue();
				String[] partesDivididas = cancion.split(",");
				String primeraParte = partesDivididas[0];
				System.out.println(ventana.ColaCancion.contains(primeraParte));
				if (selectedRow == -1) {
					JOptionPane.showMessageDialog(ventana, "No se ha seleccionado ninguna canción.", "Error", JOptionPane.ERROR_MESSAGE);
				} else if(primeraParte.equals(ventana.CancionEjectuda)) {
					JOptionPane.showMessageDialog(ventana, "La cancion que se quiere borra esta siendo esuchada ahora, por lo que no es posible borrarla.", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					ventana.ColaCancion.remove(selectedRow);
					cl.lista_canciones.remove(selectedRow);
					ventana.modelo_lista.remove(selectedRow);
					cl.cargar_modelo_lista(ventana.modelo_lista);
					ventana.listaCan.setModel(ventana.modelo_lista);
					ventana.revalidate();
					ventana.repaint();
				}
			}
		};
	}

	public ActionListener BotonEliminarTodas() {
		return new ActionListener() {
			ArrayList<Cancion> lista = new ArrayList<>();
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				String cancion = ventana.CancionEjectuda;
				if(cancion.equals(ventana.CancionEjectuda)) {
					for (Cancion c : ventana.ColaCancion) {
						lista.add(c);

					}
					ventana.modelo_lista.removeAllElements();
					for (Cancion d : lista) {
						if(!d.getName_can().equals(cancion)) {
							ventana.ColaCancion.remove(d);
							cl.lista_canciones.remove(cancion);
						}
					}
					cl.cargar_modelo_lista(ventana.modelo_lista);
					ventana.listaCan.setModel(ventana.modelo_lista);
					ventana.revalidate();
					ventana.repaint();
				}else {
					ventana.ColaCancion.clear();
					cl.lista_canciones.clear();
					ventana.modelo_lista.removeAllElements();
					cl.cargar_modelo_lista(ventana.modelo_lista);
					ventana.listaCan.setModel(ventana.modelo_lista);
					ventana.revalidate();
					ventana.repaint();
				}
			}
		};
	}

	public void CambiarNombreLabel(int nombre) {
		if (ventana.ColaCancion.isEmpty()) {
			ventana.CancionEjectuda = "";
		}else {
			ventana.CancionEjectuda = ventana.ColaCancion.get(nombre).getName_can();
			ventana.nom_can.setText("Cancion: " + ventana.CancionEjectuda);
		}
	}

	@SuppressWarnings("static-access")
	public void CambiarTiempoLabel(int duracion) {
		if (ventana.ColaCancion.isEmpty()) {
			ventana.tiempo=0;
		}else {
			ventana.tiempo = ventana.ColaCancion.get(duracion).getDuration();
			ventana.t_final.setText(csm.cambioSec(ventana.tiempo));
			ventana.duracion_can.setMaximum(ventana.tiempo);;
		}
	}
}
