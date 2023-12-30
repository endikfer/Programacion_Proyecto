package ventanas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import bd.BDExcepcion;
import bd.BDManejoUsu;
import ventanasadd.Listeners;
import ventanasadd.Renderer;
import canciones.ContenedorUsuarios;
import canciones.Usuario;
import canciones.Cancion;
import canciones.ContenedorCanciones;
import ventanasadd.CambiarFondo;
import ventanasadd.CambioSegundoMinuto;
import ventanasadd.CargarCanciones;
import ventanasadd.Reproductor;
import ventanasadd.Deslizador;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;


public class VentanaPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean activador = false;

	public CambiarFondo cambiarfondo;
	public Deslizador deslizador;
	public Listeners listener;
	public CambioSegundoMinuto cambiosecmin;
	public CargarCanciones cargacancion;
	public Renderer renderer;

	public BDManejoUsu bdUsu;
	public Properties properties;
	public VentanaUsuario vusu;

	public int tiempo;


	//componentes de la ventana
	public JPanel izquierda;
	public JPanel abajo;
	public JPanel abajo_arriba;
	public JPanel abajo_abajo;

	public JPanel centro;

	public JPanel p_perfil;
	public JPanel p_contra;

	public JPanel p_canciones;
	public JPanel centro_arriba;
	public JPanel boton_medio;
	public JPanel centro_canciones;
	public JPanel p_combo;

	public JPanel p_cola;

	public JPanel p_ajustes;
	public JPanel p_fondo;
	public JPanel p_bucle;
	public JPanel p_barra;
	public JPanel p_flecha;

	public JButton b_perfil;
	public JButton b_canciones;
	public JButton b_cola;
	public JButton b_ajustes;

	public ImageIcon i_cancion;
	public ImageIcon i_ajuste;
	public ImageIcon i_perfil;
	public ImageIcon i_cola;

	public JLabel l_perfil;
	public JLabel l_ajuste;
	public JLabel l_cancion;
	public JLabel l_cola;

	public JLabel l_nombre;
	public JLabel l_correo;
	public JLabel l_nom_usu;
	public JLabel l_contra;


	public JLabel relleno1;
	public JLabel relleno2;
	public JLabel relleno3;
	public JLabel relleno4;

	public JPasswordField p_contra_f;

	public JRadioButton b_contra;

	public JTextField t_nombre;
	public JTextField t_correo;
	public JTextField t_nom_usu;
	public JTextField t_contra;

	public JTextField busqueda;

	public ImageIcon i_lupa;

	public JButton b_cancion_nueva;
	public JButton lupa;

	public DefaultTableModel modelo_tabla_canciones;

	public JTable tabla_canciones;

	public JScrollPane Scroll_tabla;

	public JLabel l_fondo;
	public JLabel l_bucle;
	public JLabel l_atajos;
	public JLabel l_barra;
	public JLabel l_flecha;
	public JLabel l_exp1;
	public JLabel l_exp2;
	public JLabel l_exp3;

	public Font font;
	public Font font1;
	public Font font2;
	public Font font3;
	public Font font4;
	public Font font5;
	public Font font6;
	public Font font7;

	public JToggleButton t_bucle;
	public JToggleButton t_barra;
	public JToggleButton t_flecha;

	public ImageIcon i_atrasar;
	public ImageIcon i_pausar;
	public ImageIcon i_adelantar;
	public ImageIcon i_play;

	public JButton b_atras_can;
	public JButton b_pausar_can;
	public JButton b_adelantar_can;

	public JSlider duracion_can;
	public JToggleButton t_fondo;
	public Color colorFondo;
	public JLabel t_final;
	public JLabel t_duracion;
	public JLabel foto_can;
	public JLabel nom_can;

	public JComboBox<String> orden;

	public JList<Cancion> listaCancionesCola;
	public ArrayList<Cancion> canciones;

	public Cancion cancion;
	
	

	@SuppressWarnings("static-access")
	public VentanaPrincipal(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH); //ventana maximizada
		setTitle("Ventana Principal");
		setLocationRelativeTo(null);
		colorFondo = this.getContentPane().getBackground();
		cambiarfondo = new CambiarFondo();

		deslizador = new Deslizador(this);

		listener = new Listeners(this);

		cambiosecmin = new CambioSegundoMinuto();

		cargacancion = new CargarCanciones();

		bdUsu = new BDManejoUsu();

		properties = new Properties();

		listener.PararCancionesAlCerrar();

		renderer = new Renderer();
		


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




		try (FileReader reader = new FileReader("configuracion.properties")) {
			properties.load(reader);

			//Elementos del panel de la izquierda
			//creacion de los botones
			b_perfil = new JButton();
			b_canciones = new JButton();
			b_cola = new JButton();
			b_ajustes = new JButton();

			//imagenes de los botones
			i_cancion = new ImageIcon(properties.getProperty("dirImg") + "cancion.jpg");
			i_ajuste = new ImageIcon(properties.getProperty("dirImg") + "ajustes.jpg");
			i_perfil = new ImageIcon(properties.getProperty("dirImg") + "perfil.jpg");
			i_cola = new ImageIcon(properties.getProperty("dirImg") + "cola.jpg");

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

			//Añadir los escuchadores de los botones
			b_perfil.addActionListener(listener.BotonPerfilListener());
			b_canciones.addActionListener(listener.BotonCancionListener());
			b_cola.addActionListener(listener.BotonColaListener());
			b_ajustes.addActionListener(listener.BotonAjustesListener());





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

			//Añadir el escuchador al radio buton		
			b_contra.addActionListener(listener.BotonVisuContraListener());



			//Canciones
			//Panel
			p_combo = new JPanel(new GridLayout(1,6));

			//Label
			relleno1 = new JLabel();
			relleno2 = new JLabel();
			relleno3 = new JLabel();
			relleno4 = new JLabel();


			//texto
			busqueda = new JTextField(50);

			//imagenes de los botones
			i_lupa = new ImageIcon(properties.getProperty("dirImg") + "lupa.jpg");


			//Botones
			b_cancion_nueva = new JButton("Añadir canción");
			lupa = new JButton(i_lupa);

			lupa.addActionListener(listener.BarraBusq());

			//ComboBox
			String [] ordenes = {"A --> Z", "Z --> A", "Menos duracion", "Mas duracion"}; 
			orden = new JComboBox<>(ordenes);

			orden.addActionListener(listener.OrdenarCombo());


			//JTable
			DefaultTableModel modelo_tabla_canciones = new DefaultTableModel();
			modelo_tabla_canciones = new DefaultTableModel();
			cargacancion.cargar_modelo_tabla_canciones(modelo_tabla_canciones);
			tabla_canciones= new JTable(modelo_tabla_canciones) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			tabla_canciones.setDefaultRenderer(Object.class, renderer);


			//tamaños del JTable
			tabla_canciones.getColumnModel().getColumn(0).setPreferredWidth(300);
			tabla_canciones.getColumnModel().getColumn(1).setPreferredWidth(300);
			tabla_canciones.getColumnModel().getColumn(2).setPreferredWidth(300);
			tabla_canciones.getColumnModel().getColumn(3).setPreferredWidth(300);
			tabla_canciones.getColumnModel().setColumnMargin(10);
			tabla_canciones.setRowMargin(10);
			tabla_canciones.setRowHeight(40);


			//componente para el estilo de la JTable
			//		Estilotabla estilo = new Estilotabla();

			//Estilo del Jtable
			tabla_canciones.setFont(new Font(tabla_canciones.getFont().getName(), tabla_canciones.getFont().getStyle(), 20));
			//		tabla_canciones.setDefaultRenderer(Object.class, estilo);

			//No poder selecionar las columnas
			tabla_canciones.setColumnSelectionAllowed(false);

			// Obtener el encabezado de la tabla
			JTableHeader tableHeader = tabla_canciones.getTableHeader();
			tableHeader.setFont(new Font("Arial", Font.ITALIC, 30));

			//No poder moever las colunas
			tableHeader.setReorderingAllowed(false);


			//El scorll para la tabla
			Scroll_tabla = new JScrollPane(tabla_canciones);
			Scroll_tabla.setPreferredSize(new Dimension(1200, 500));
			Scroll_tabla.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


			//Ajustes
			p_ajustes.setBorder(new EmptyBorder(0, 20, 20, 20));
			//Text Field
			l_fondo = new JLabel("Modo oscuro");
			l_bucle = new JLabel("Autoplay");
			l_atajos = new JLabel("Atajos de teclado");
			l_barra = new JLabel("Uso del enter para pausar y reanudar la cancion");
			l_flecha = new JLabel("Uso de las flechas adelante/atras para retroceder/avanzar una cancion");
			l_exp1 = new JLabel("Al clickar alt + enter se activara la cancion si estaba parada, o al reves, si estaba activada se pausara.");
			l_exp2 = new JLabel("Al clickar alt + la flecha de la izquierda empezara de cero la cancion, y al clickar alt + la de la derecha avanzara una cancion.");
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

			//Añadir el escuchador a los togle butons
			t_fondo.addActionListener(listener.ToggleFondoOscuroListener());
			t_barra.addActionListener(listener.ToggleBarraEspaciadoraListener());
			t_flecha.addActionListener(listener.ToggleFlechaIzqListener());
			t_flecha.addActionListener(listener.ToggleFlechaDereListener());




			//Elementos del panel de abajo
			//Label
			nom_can = new JLabel();
			foto_can = new JLabel("Foto canción");
			t_duracion = new JLabel();
			t_final = new JLabel();

			//imagenes de los botones
			i_atrasar = new ImageIcon(properties.getProperty("dirImg") + "atrasar.jpg");
			i_pausar = new ImageIcon(properties.getProperty("dirImg") + "pausar.jpg");
			i_adelantar = new ImageIcon(properties.getProperty("dirImg") + "adelantar.jpg");
			i_play = new ImageIcon(properties.getProperty("dirImg") + "play.jpg");

			//Botones
			b_atras_can = new JButton(i_atrasar);
			b_pausar_can = new JButton(i_play);
			b_adelantar_can = new JButton(i_adelantar);


			//activamos ya que pueda reproducir
			File a = new File(properties.getProperty("dirCan") + "duki.wav");
			Reproductor.reproduce(a);

			//		this.addWindowListener(new WindowAdapter() {
			//		    @Override
			//		    public void windowClosing(WindowEvent e) {
			//		        super.windowClosing(e);
			//		        // Aquí detienes el reproductor
			//		        reproductor.pause();
			//		    }
			//		});


			//Añadir los escuchadores de los botones
			b_pausar_can.addActionListener(listener.BotonPausarActivarBarra());

			b_atras_can.addActionListener(listener.BotonPausarFlechaIzqListener());
			b_adelantar_can.addActionListener(listener.BotonPausarFlechaDereListener());




			//Cola
			canciones = new ArrayList<Cancion>();
			canciones.add(new Cancion("Duki","Goteo" ,160 , "Todo"));
			canciones.add(new Cancion("Duki","Givenchy" ,223 , "Temporada de Reggaetón 2"));
			//		listaCancionesCola = new JList<Cancion>(new ModeloListaCola(canciones));
			//		p_cola.add(listaCancionesCola);


			tiempo = canciones.get(1).getDuration();

			nom_can.setText("Cancion: " + canciones.get(1).getName_can());
			t_final.setText(cambiosecmin.cambioSec(tiempo));
			t_duracion.setText(String.format("%02d:%02d", 0,0));

			//deslizador
			duracion_can = new JSlider(0, tiempo, 0);





			//conectando a la  base de datos
			try {
				bdUsu.connect("Usuario.db");
				Usuario user =  bdUsu.getUser(vusu.NomUsu);
				t_nombre.setText(user.getName_real());
				t_correo.setText(user.getGmail());
				t_nom_usu.setText(user.getName_us());
				p_contra_f.setText(user.getPassword());

			} catch (BDExcepcion e1) {
				e1.printStackTrace();
			}


			//Anaydir elementos a los paneles
			//Anaydir elementos al panel de la izquierda
			izquierda.add(b_perfil);
			izquierda.add(b_canciones);
			izquierda.add(b_cola);
			izquierda.add(b_ajustes);

			//Anaydir elementos al panel de abajo
			abajo_arriba.add(nom_can);
			abajo_abajo.add(foto_can);
			abajo_abajo.add(t_duracion);
			abajo_abajo.add(duracion_can);
			abajo_abajo.add(t_final);
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
			centro_canciones.add(Scroll_tabla);
			p_combo.add(orden);
			p_combo.add(relleno1);
			p_combo.add(relleno2);
			p_combo.add(relleno3);
			p_combo.add(boton_medio);
			p_combo.add(relleno4);
			p_canciones.add(p_combo, BorderLayout.SOUTH);
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
		} catch (IOException e) {
			System.out.println("Error abriendo el fichero de propiedades.");
		}
	}


	public static void main(String[] args) {	
		File fichero = new File("Usuarios");
		File fichero2 = new File("Canciones");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				//				try {
				//					ContenedorUsuarios.cargarUsuarios(fichero);
				//				} catch (IOException e) {
				//					JOptionPane.showMessageDialog(null, "Error al cargar los usuarios", "Usuarios Con Conflictos", JOptionPane.INFORMATION_MESSAGE);
				//					Loggers.logger.warning("Error al cargar los usuarios desde la base de datos");
				//				}
				//				try {
				//					ContenedorCanciones.cargarCanciones(fichero2);
				//				} catch (IOException e) {
				//					JOptionPane.showMessageDialog(null, "Error al cargar las canciones", "Canciones Con Conflictos", JOptionPane.INFORMATION_MESSAGE);
				//					Loggers.logger.warning("Error al cargar las canciones desde la base de datos");
				//				}
				new VentanaPrincipal();
				ContenedorUsuarios.guardarUsuarios(fichero);
				ContenedorCanciones.guardarCanciones(fichero2);
			}
		});
	}
}