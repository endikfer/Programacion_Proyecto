package Ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
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
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Canciones.BD_Usuarios;
import Canciones.Cancion;
import Canciones.cancbd;
import VentanasAdd.estilotabla;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;


public class Ventana_principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean activador = false;

	//Variables para el contador del deslizador
	private int valorActual = 0;
	private int incremento = 1;
	private Timer timer; // Declarar el temporizador como variable de instancia


	//componentes de la ventana
	JPanel izquierda;
	JPanel abajo;
	JPanel abajo_arriba;
	JPanel abajo_abajo;

	JPanel centro;

	JPanel p_perfil;
	JPanel p_contra;

	JPanel p_canciones;
	JPanel centro_arriba;
	JPanel boton_medio;
	JPanel centro_canciones;

	JPanel p_cola;

	JPanel p_ajustes;
	JPanel p_fondo;
	JPanel p_bucle;
	JPanel p_barra;
	JPanel p_flecha;

	JButton b_perfil;
	JButton b_canciones;
	JButton b_cola;
	JButton b_ajustes;

	ImageIcon i_cancion;
	ImageIcon i_ajuste;
	ImageIcon i_perfil;
	ImageIcon i_cola;

	JLabel l_perfil;
	JLabel l_ajuste;
	JLabel l_cancion;
	JLabel l_cola;

	JLabel l_nombre;
	JLabel l_correo;
	JLabel l_nom_usu;
	JLabel l_contra;

	JPasswordField p_contra_f;

	JRadioButton b_contra;

	JTextField t_nombre;
	JTextField t_correo;
	JTextField t_nom_usu;
	JTextField t_contra;

	JTextField busqueda;

	ImageIcon i_lupa;

	JButton b_cancion_nueva;
	JButton lupa;

	DefaultTableModel modelo_tabla_canciones;

	JTable tabla_canciones;

	JLabel l_fondo;
	JLabel l_bucle;
	JLabel l_atajos;
	JLabel l_barra;
	JLabel l_flecha;
	JLabel l_exp1;
	JLabel l_exp2;
	JLabel l_exp3;

	Font font;
	Font font1;
	Font font2;
	Font font3;
	Font font4;
	Font font5;
	Font font6;
	Font font7;

	JToggleButton t_bucle;
	JToggleButton t_barra;
	JToggleButton t_flecha;

	ImageIcon i_atrasar;
	ImageIcon i_pausar;
	ImageIcon i_adelantar;
	ImageIcon i_play;

	JButton b_atras_can;
	JButton b_pausar_can;
	JButton b_adelantar_can;

	JSlider duracion_can;
	JToggleButton t_fondo;
	Color colorFondo;
	JLabel foto_t_final;
	JLabel foto_t_duracion;
	JLabel foto_can;
	JLabel nom_can;

	@SuppressWarnings("static-access")
	public Ventana_principal(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH); //ventana maximizada
		setTitle("Ventana Principal");
		setLocationRelativeTo(null);
		colorFondo = this.getContentPane().getBackground();



		//Elementos creados
		//Paneles principales
		izquierda = new JPanel(new GridLayout(6, 1));
		abajo = new JPanel(new GridLayout(2, 1));
		abajo_arriba = new JPanel();
		abajo_abajo = new JPanel();




		//paneles centro
		centro = new JPanel(new BorderLayout());

		//paneles perfil
		p_perfil = new JPanel(new GridLayout(12, 1));
		p_contra = new JPanel(new BorderLayout());

		//paneles canciones
		p_canciones =  new JPanel();
		centro_arriba = new JPanel();
		boton_medio = new JPanel();
		centro_canciones = new JPanel();
		@SuppressWarnings("unused")
		JScrollPane centro_canciones_scroll = new JScrollPane(centro_canciones);

		p_canciones = new JPanel(new BorderLayout());
		centro_arriba = new JPanel();
		boton_medio = new JPanel();
		centro_canciones = new JPanel();

		//paneles cola
		p_cola = new JPanel(new BorderLayout());

		//paneles ajustes
		p_ajustes = new JPanel(new GridLayout(12, 1));
		p_fondo = new JPanel(new BorderLayout());
		p_bucle = new JPanel(new BorderLayout());
		p_barra = new JPanel(new BorderLayout());
		p_flecha = new JPanel(new BorderLayout());






		//Elementos del panel de la izquierda
		//creacion de los botones
		b_perfil = new JButton();
		b_canciones = new JButton();
		b_cola = new JButton();
		b_ajustes = new JButton();

		//imagenes de los botones
		i_cancion = new ImageIcon("src/Imagenes/cancion.jpg");
		i_ajuste = new ImageIcon("src/Imagenes/ajustes.jpg");
		i_perfil = new ImageIcon("src/Imagenes/perfil.jpg");
		i_cola = new ImageIcon("src/Imagenes/cola.jpg");

		//Texto de los botones
		l_perfil = new JLabel("Perfil");
		l_ajuste = new JLabel("Ajustes");
		l_cancion = new JLabel("Canciones");
		l_cola = new JLabel("Canciones en cola");

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
		l_nombre = new JLabel("Nombre");
		l_correo = new JLabel("Correo");
		l_nom_usu = new JLabel("Nombre de usuario");
		l_contra = new JLabel("Contraseña");

		//PasswordField
		p_contra_f = new JPasswordField("Hola"); //hola es un ejemplo para mirar si funciona

		//RadioButton
		b_contra = new JRadioButton();

		//TextField
		t_nombre = new JTextField();
		t_correo = new JTextField();
		t_nom_usu = new JTextField();
		t_contra = new JTextField();

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
		busqueda = new JTextField(50);

		//imagenes de los botones
		i_lupa = new ImageIcon("src/Imagenes/lupa.jpg");


		//Botones
		b_cancion_nueva = new JButton("Añadir canción");
		lupa = new JButton(i_lupa);


		//JTable
		DefaultTableModel modelo_tabla_canciones = new DefaultTableModel();
		modelo_tabla_canciones = new DefaultTableModel();
		cargar_modelo_tabla_canciones(modelo_tabla_canciones);
		JTable tabla_canciones= new JTable(modelo_tabla_canciones) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};

		
		
		//tamaños del JTable
		tabla_canciones.getColumnModel().getColumn(0).setPreferredWidth(400);
		tabla_canciones.getColumnModel().getColumn(1).setPreferredWidth(400);
		tabla_canciones.getColumnModel().getColumn(2).setPreferredWidth(400);
		tabla_canciones.getColumnModel().setColumnMargin(10);
		tabla_canciones.setRowMargin(10);
		tabla_canciones.setRowHeight(40);
		tabla_canciones.setRowHeight(0, 60);

		//componente para el estilo de la JTable
		estilotabla estilo = new estilotabla();

		//Estilo del Jtable
		tabla_canciones.setFont(new Font(tabla_canciones.getFont().getName(), tabla_canciones.getFont().getStyle(), 20));
		tabla_canciones.setDefaultRenderer(Object.class, estilo);

		//No poder selecionar las columnas
		tabla_canciones.setColumnSelectionAllowed(false);
		tabla_canciones.setRowSelectionAllowed(false);
		

		//Ajustes
		p_ajustes.setBorder(new EmptyBorder(0, 20, 20, 20));
		//Text Field
		l_fondo = new JLabel("Modo oscuro");
		l_bucle = new JLabel("Autoplay");
		l_atajos = new JLabel("Atajos de teclado");
		l_barra = new JLabel("Uso del enter para pausar y reanudar la cancion");
		l_flecha = new JLabel("Uso de las flechas adelante/atras para retroceder/avanzar una cancion");
		l_exp1 = new JLabel("Al clickar el enter se activara la cancion si estaba parada, o al reves, si estaba activada se pausara.");
		l_exp2 = new JLabel("Al clickar la flecha de la izquierda volvera a repetirse la cancion anterior, y al clickar la de la derecha avanzara una cancion.");
		l_exp3 = new JLabel("Activando esta funcion cuando la lista de canciones se termine volvera a empezar desde el inicio.");

		//aumento de tamaño y negrita del label de atajo de teclado
		font = new Font("Arial", Font.BOLD, 25);
		l_atajos.setFont(font);

		font1 = new Font("Arial", Font.PLAIN, 12);
		l_exp1.setFont(font1);

		font2 = new Font("Arial", Font.PLAIN, 12);
		l_exp2.setFont(font2);

		font3 = new Font("Arial", Font.PLAIN, 12);
		l_exp3.setFont(font3);

		font4 = new Font("Arial", Font.PLAIN, 20);
		l_fondo.setFont(font4);

		font5 = new Font("Arial", Font.PLAIN, 20);
		l_bucle.setFont(font5);

		font6 = new Font("Arial", Font.PLAIN, 20);
		l_barra.setFont(font6);

		font7 = new Font("Arial", Font.PLAIN, 20);
		l_flecha.setFont(font7);

		//ToggleButton
		t_fondo = new JToggleButton();
		t_bucle = new JToggleButton();
		t_barra = new JToggleButton();
		t_flecha = new JToggleButton();



		ActionListener fondo_oscuro = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				cambiarFondo();
			}
		};

		ActionListener activar_espacio = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ActivarBarraEspaciadora();
			}
		};

		//Añadir el escuchador a los togle butons
		t_fondo.addActionListener(fondo_oscuro);
		t_barra.addActionListener(activar_espacio);




		//Elementos del panel de abajo
		//Label
		nom_can = new JLabel("Canción");
		foto_can = new JLabel("Foto canción");
		foto_t_duracion = new JLabel("tiempo de transcurso");
		foto_t_final = new JLabel("tiempo final");

		//imagenes de los botones
		i_atrasar = new ImageIcon("src/Imagenes/atrasar.jpg");
		i_pausar = new ImageIcon("src/Imagenes/pausar.jpg");
		i_adelantar = new ImageIcon("src/Imagenes/adelantar.jpg");
		i_play = new ImageIcon("src/Imagenes/play.jpg");

		//Botones
		b_atras_can = new JButton(i_atrasar);
		b_pausar_can = new JButton(i_play);
		b_adelantar_can = new JButton(i_adelantar);

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

		//Anaydir elementos al panel de ajustes
		p_fondo.add(l_fondo, BorderLayout.CENTER);
		p_bucle.add(l_bucle, BorderLayout.CENTER);
		p_barra.add(l_barra, BorderLayout.CENTER);
		p_flecha.add(l_flecha, BorderLayout.CENTER);

		p_fondo.add(t_fondo, BorderLayout.EAST);
		p_bucle.add(t_bucle, BorderLayout.EAST);
		p_barra.add(t_barra, BorderLayout.EAST);
		p_flecha.add(t_flecha, BorderLayout.EAST);

		p_barra.add(l_exp1, BorderLayout.SOUTH);
		p_flecha.add(l_exp2, BorderLayout.SOUTH);
		p_bucle.add(l_exp3, BorderLayout.SOUTH);

		p_fondo.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		p_bucle.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		p_barra.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		p_flecha.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

		p_ajustes.add(p_fondo);
		p_ajustes.add(p_bucle);
		p_ajustes.add(l_atajos);
		p_ajustes.add(p_barra);
		p_ajustes.add(p_flecha);



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
	@SuppressWarnings("static-access")
	public DefaultTableModel cargar_modelo_tabla_canciones(DefaultTableModel a){
		a.addColumn("Nomber");
		a.addColumn("Autor");
		a.addColumn("Álbum");
		a.addRow(new Object[] {"Nombre", "Autor", "Album"});
		for(Cancion c : cancbd.canciones) {
			a.addRow(new Object[] {c.getName_can(), c.getNombre_Ar(), c.getAlbum()});
		}
		return a;
	}

	//metodo para cambiar el fondo de el programa a negro
	private void cambiarFondo() {
		if (t_fondo.isSelected()) {
			p_perfil.setBackground(Color.BLACK);
			izquierda.setBackground(Color.BLACK);
			abajo.setBackground(Color.BLACK);
			abajo_arriba.setBackground(Color.BLACK);
			abajo_abajo.setBackground(Color.BLACK);
			p_ajustes.setBackground(Color.BLACK);
			p_ajustes.setBackground(Color.BLACK);
			p_fondo.setBackground(Color.BLACK);
			p_bucle.setBackground(Color.BLACK);
			p_barra.setBackground(Color.BLACK);
			p_flecha.setBackground(Color.BLACK);
			boton_medio.setBackground(Color.BLACK);
			centro_arriba.setBackground(Color.BLACK);
			centro_canciones.setBackground(Color.BLACK);
			centro_canciones.setBackground(Color.BLACK);
			p_cola.setBackground(Color.BLACK);


			foto_t_final.setForeground(Color.WHITE);
			foto_t_duracion.setForeground(Color.WHITE);
			foto_can.setForeground(Color.WHITE);
			nom_can.setForeground(Color.WHITE);
			l_fondo.setForeground(Color.WHITE);
			l_bucle.setForeground(Color.WHITE);
			l_atajos.setForeground(Color.WHITE);
			l_barra.setForeground(Color.WHITE);
			l_flecha.setForeground(Color.WHITE);
			l_exp1.setForeground(Color.WHITE);
			l_exp2.setForeground(Color.WHITE);
			l_exp3.setForeground(Color.WHITE);

			l_nombre.setForeground(Color.WHITE);
			l_correo.setForeground(Color.WHITE);
			l_nom_usu.setForeground(Color.WHITE);
			l_contra.setForeground(Color.WHITE);
		} else {
			p_perfil.setBackground(colorFondo);
			izquierda.setBackground(colorFondo);
			abajo.setBackground(colorFondo);
			abajo_arriba.setBackground(colorFondo);
			abajo_abajo.setBackground(colorFondo);
			p_ajustes.setBackground(colorFondo);
			p_ajustes.setBackground(colorFondo);
			p_fondo.setBackground(colorFondo);
			p_bucle.setBackground(colorFondo);
			p_barra.setBackground(colorFondo);
			p_flecha.setBackground(colorFondo);
			boton_medio.setBackground(colorFondo);
			centro_arriba.setBackground(colorFondo);
			centro_canciones.setBackground(colorFondo);
			p_cola.setBackground(colorFondo);

			foto_t_final.setForeground(Color.BLACK);
			foto_t_duracion.setForeground(Color.BLACK);
			foto_can.setForeground(Color.BLACK);
			nom_can.setForeground(Color.BLACK);
			l_fondo.setForeground(Color.BLACK);
			l_bucle.setForeground(Color.BLACK);
			l_atajos.setForeground(Color.BLACK);
			l_barra.setForeground(Color.BLACK);
			l_flecha.setForeground(Color.BLACK);
			l_exp1.setForeground(Color.BLACK);
			l_exp2.setForeground(Color.BLACK);
			l_exp3.setForeground(Color.BLACK);

			l_nombre.setForeground(Color.BLACK);
			l_correo.setForeground(Color.BLACK);
			l_nom_usu.setForeground(Color.BLACK);
			l_contra.setForeground(Color.BLACK);
		}
	}

	private void ActivarBarraEspaciadora() {
		if (t_barra.isSelected()) {
			b_pausar_can.setMnemonic(KeyEvent.VK_ENTER);
		}else {
			b_pausar_can.setMnemonic(0);
		}
	}
	
		public static void main(String[] args) {
			File fichero = new File("BD_Usuarios");
			File fichero2 = new File("BD_Canc");
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					try {
						BD_Usuarios.cargarUsuarios(fichero);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error al cargar los usuarios", "Usuarios Con Conflictos", JOptionPane.INFORMATION_MESSAGE);
					}
					try {
						cancbd.cargarCanciones(fichero2);
					} catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error al cargar las canciones", "Canciones Con Conflictos", JOptionPane.INFORMATION_MESSAGE);
					}
					new Ventana_principal();
					BD_Usuarios.guardarUsuarios(fichero);
					cancbd.guardarCanciones(fichero2);
				}
			});
		}
	}