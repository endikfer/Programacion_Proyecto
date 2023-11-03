package Ventanas;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Canciones.BD_Usuarios;
import Canciones.Cancion;
import Canciones.cancbd;
import javax.swing.JRadioButton;


public class Ventana_principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean activador = false;

	//Variables para el contador del deslizador
	private int valorActual = 0;
	private int incremento = 1;
	JSlider duracion_can;
	private Timer timer; // Declarar el temporizador como variable de instancia

	@SuppressWarnings("static-access")
	public Ventana_principal(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH); //ventana maximizada
		setTitle("Ventana Principal");
		
		

		//Elementos creados
		//Paneles principales
		JPanel izquierda = new JPanel(new GridLayout(6, 1));
		JPanel abajo = new JPanel(new GridLayout(2, 1));
		JPanel abajo_arriba = new JPanel();
		JPanel abajo_abajo = new JPanel();


		//paneles centro
		JPanel centro = new JPanel(new BorderLayout());
		
		//paneles perfil
		JPanel p_perfil = new JPanel(new GridLayout(12, 1));
		JPanel p_contra = new JPanel(new BorderLayout());
		
		//paneles canciones
		JPanel p_canciones = new JPanel(new BorderLayout());
		JPanel centro_arriba = new JPanel();
		JPanel boton_medio = new JPanel();
		JPanel centro_canciones = new JPanel();
		
		//paneles cola
		JPanel p_cola = new JPanel(new BorderLayout());
		
		//paneles ajustes
		JPanel p_ajustes = new JPanel(new BorderLayout());






		//Elementos del panel de la izquierda
		//creacion de los botones
		JButton b_perfil = new JButton();
		JButton b_canciones = new JButton();
		JButton b_cola = new JButton();
		JButton b_ajustes = new JButton();

		//imagenes de los botones
		ImageIcon i_cancion = new ImageIcon("src/Imagenes/cancion.jpg");
		ImageIcon i_ajuste = new ImageIcon("src/Imagenes/ajustes.jpg");
		ImageIcon i_perfil = new ImageIcon("src/Imagenes/perfil.jpg");
		ImageIcon i_cola = new ImageIcon("src/Imagenes/cola.jpg");

		//Texto de los botones
		JLabel l_perfil = new JLabel("Perfil");
		JLabel l_ajuste = new JLabel("Ajustes");
		JLabel l_cancion = new JLabel("Canciones");
		JLabel l_cola = new JLabel("Canciones en cola");

		//Alinear el texto en el JLabel como centrado
		l_perfil.setHorizontalAlignment(SwingConstants.CENTER);
		l_cancion.setHorizontalAlignment(SwingConstants.CENTER);
		l_cola.setHorizontalAlignment(SwingConstants.CENTER);
		l_ajuste.setHorizontalAlignment(SwingConstants.CENTER);

		//Asignar la imagen al boton
		b_perfil.setIcon(i_perfil);
		b_canciones.setIcon(i_cancion);
		b_cola.setIcon(i_cola);
		b_ajustes.setIcon(i_ajuste);

		//Asignar el layout al boton
		b_perfil.setLayout(new BorderLayout());
		b_canciones.setLayout(new BorderLayout());
		b_cola.setLayout(new BorderLayout());
		b_ajustes.setLayout(new BorderLayout());

		//añadir el texto al boton
		b_perfil.add(l_perfil, BorderLayout.SOUTH);
		b_canciones.add(l_cancion, BorderLayout.SOUTH);
		b_cola.add(l_cola, BorderLayout.SOUTH);
		b_ajustes.add(l_ajuste, BorderLayout.SOUTH);

		
		//listeners de los botones
		//para el boton perfil
		ActionListener cambiar_perfil = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centro.removeAll();
				centro.add(p_perfil);
				centro.revalidate();
				centro.repaint();
			}
		};

		//para el boton canciones
		ActionListener cambiar_canciones = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centro.removeAll();
				centro.add(p_canciones);
				centro.revalidate();
				centro.repaint();
			}
		};

		//para el boton cola
		ActionListener cambiar_cola = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centro.removeAll();
				centro.add(p_cola);
				centro.revalidate();
				centro.repaint();
			}
		};

		//para el boton cola
		ActionListener cambiar_ajustes = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centro.removeAll();
				centro.add(p_ajustes);
				centro.revalidate();
				centro.repaint();
			}
		};

		//Añadir los escuchadores de los botones
		b_perfil.addActionListener(cambiar_perfil);
		b_canciones.addActionListener(cambiar_canciones);
		b_cola.addActionListener(cambiar_cola);
		b_ajustes.addActionListener(cambiar_ajustes);





		//Elementos del panel del centro
		//Perfil
		p_perfil.setBorder(new EmptyBorder(0, 20, 20, 20));
		//Labels
		JLabel l_nombre = new JLabel("Nombre");
		JLabel l_correo = new JLabel("Correo");
		JLabel l_nom_usu = new JLabel("Nombre de usuario");
		JLabel l_contra = new JLabel("Contraseña");

		//PasswordField
		JPasswordField p_contra_f = new JPasswordField("Hola"); //hola es un ejemplo para mirar si funciona
		
		//RadioButton
		JRadioButton b_contra = new JRadioButton();
				
		//TextField
		JTextField t_nombre = new JTextField();
		JTextField t_correo = new JTextField();
		JTextField t_nom_usu = new JTextField();
		JTextField t_contra = new JTextField();
		
		//Listener del radiobutton
		ActionListener visu_contra = new ActionListener() {

			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(b_contra.isSelected()) {
					p_contra.remove(p_contra_f);
					Font font = p_contra_f.getFont();
					t_contra.setFont(font.deriveFont(font.getSize() + 10f));
					t_contra.setText(p_contra_f.getText());
					p_contra.add(t_contra, BorderLayout.CENTER);
				}else {
					p_contra.remove(t_contra);
					p_contra.add(p_contra_f, BorderLayout.CENTER);
				}
				
				p_contra.revalidate();
				p_contra.repaint();
			}
		};
		
		//Añadir el escuchador al radio buton
		b_contra.addActionListener(visu_contra);
		
		

		//Canciones
		//texto
		JTextField busqueda = new JTextField(50);

		//imagenes de los botones
		ImageIcon i_lupa = new ImageIcon("src/Imagenes/lupa.jpg");


		//Botones
		JButton b_cancion_nueva = new JButton("Añadir canción");
		JButton lupa = new JButton(i_lupa);
		
		
		//JTable
		DefaultTableModel modelo_tabla_canciones = new DefaultTableModel();
		cargar_modelo_tabla_canciones(modelo_tabla_canciones);
		JTable tabla_canciones= new JTable(modelo_tabla_canciones);
		
		
		

		//Elementos del panel de abajo
		//Label
		JLabel nom_can = new JLabel("Canción");
		JLabel foto_can = new JLabel("Foto canción");
		JLabel foto_t_duracion = new JLabel("tiempo de transcurso");
		JLabel foto_t_final = new JLabel("tiempo final");

		//imagenes de los botones
		ImageIcon i_atrasar = new ImageIcon("src/Imagenes/atrasar.jpg");
		ImageIcon i_pausar = new ImageIcon("src/Imagenes/pausar.jpg");
		ImageIcon i_adelantar = new ImageIcon("src/Imagenes/adelantar.jpg");
		ImageIcon i_play = new ImageIcon("src/Imagenes/play.jpg");

		//Botones
		JButton b_atras_can = new JButton(i_atrasar);
		JButton b_pausar_can = new JButton(i_play);
		JButton b_adelantar_can = new JButton(i_adelantar);

		//listeners de los botones
		ActionListener pausar_activar = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (activador==false) {
					activador = true;
					//cambio de la imagen del boton
					b_pausar_can.setIcon(i_pausar);
					deslizador(activador);
				}else {
					activador = false;
					//cambio de la imagen del boton
					b_pausar_can.setIcon(i_play);
					deslizador(activador);
				}
			}
		};

		//Añadir los escuchadores de los botones
		b_pausar_can.addActionListener(pausar_activar);

		//deslizador
		duracion_can = new JSlider(0, 100, 0);




		//Anaydir elementos a los paneles
		//Anaydir elementos al panel de la izquierda
		izquierda.add(b_perfil);
		izquierda.add(b_canciones);
		izquierda.add(b_cola);
		izquierda.add(b_ajustes);

		//Anaydir elementos al panel de abajo
		abajo_arriba.add(nom_can);
		abajo_abajo.add(foto_can);
		abajo_abajo.add(foto_t_duracion);
		abajo_abajo.add(duracion_can);
		abajo_abajo.add(foto_t_final);
		abajo_abajo.add(b_atras_can);
		abajo_abajo.add(b_pausar_can);
		abajo_abajo.add(b_adelantar_can);


		abajo.add(abajo_arriba);
		abajo.add(abajo_abajo);

		//panel central
		//Añadir elementos al panel de contra
		p_contra.add(p_contra_f, BorderLayout.CENTER);
		p_contra.add(b_contra, BorderLayout.EAST);
		
		
		//Añadir elementos al panel de perfil
		p_perfil.add(l_nombre);
		p_perfil.add(t_nombre);
		p_perfil.add(l_correo);
		p_perfil.add(t_correo);
		p_perfil.add(l_nom_usu);
		p_perfil.add(t_nom_usu);
		p_perfil.add(l_contra);
		p_perfil.add(p_contra);


		//Anaydir elementos al panel de canciones
		boton_medio.add(b_cancion_nueva);
		centro_arriba.add(busqueda);
		centro_arriba.add(lupa);
		centro_canciones.add(tabla_canciones);
		p_canciones.add(boton_medio, BorderLayout.SOUTH);
		p_canciones.add(centro_arriba, BorderLayout.NORTH);
		p_canciones.add(centro_canciones, BorderLayout.CENTER);
		


		//añadir el panel a centro
		centro.add(p_canciones);


		//Anaydir elementos al panel principal
		getContentPane().add(izquierda, BorderLayout.WEST);
		getContentPane().add(centro, BorderLayout.CENTER);
		getContentPane().add(abajo, BorderLayout.SOUTH);

		setVisible(true);
	}


	//metodo para que el deslizador incremenete o se pare dependiendo de como este el boton
	public void deslizador(boolean activador) {
		// Si el temporizador no se ha creado previamente, crearlo
		if (timer == null) {
			timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					valorActual += incremento;
					duracion_can.setValue(valorActual);
				}
			});
		}
		if (activador) {
			timer.start();
		} else {
			timer.stop();
		}
	}
		
	//metodo para lo por defecto de la tabla de cancioens
	public DefaultTableModel cargar_modelo_tabla_canciones(DefaultTableModel a){
		a.addColumn("Nomber");
		a.addColumn("Autor");
		a.addColumn("Álbum");
		for(Cancion c : cancbd.canciones) {
			a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum()});
		}
		return a;
	}
	

	public static void main(String[] args) {
		File fichero = new File("BD_Usuarios");
		File fichero2 = new File("BD_Canc");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BD_Usuarios.cargarUsuarios(fichero);
					cancbd.cargarCanciones(fichero2);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error al cargar los usuarios", "Usuarios Con Conflictos", JOptionPane.INFORMATION_MESSAGE);
				}
				new Ventana_principal();
				BD_Usuarios.guardarUsuarios(fichero);
				cancbd.guardarCanciones(fichero2);
			}
		});
	}
}