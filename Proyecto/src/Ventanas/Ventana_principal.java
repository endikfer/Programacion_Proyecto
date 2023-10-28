package Ventanas;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.table.AbstractTableModel;
import Canciones.BD_Usuaruis;
import Canciones.Usuario;
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

	//Estructura de la tabla
	class Tabla extends AbstractTableModel{


		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//Array con los nombre de las columnas
		private String[] columnNom = { "Cancion", "Autor", "Duración" };

		// Este constructor recibe una lista con los objetos Persona
		// que van a ser mostrados en la tabla
		/*public MyTableModel(List<Person> persons) {
            this.persons = persons;
        }
        // este método es usado por la tabla para obtener los nombres
        // de cada columna. En este caso se obtienen del array interno
        @Override
        public String getColumnName(int index) {
            return headers[index];
        }
        // este método devuelve la clase de cada columna
        // es utilizado por el JTable para elegir el componente visual
        // o el renderer/editor adecuado para cada tipo de datos
        @Override
        public Class<?> getColumnClass(int column) {
            // en este caso, las dos primeras columnas es String
            // String, mientras que el dato de la última es LocalDate
            if (column == 2) {
                return LocalDate.class;
            } else {
                return String.class;
            }
        }
		 */
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public int getColumnCount() {
			return columnNom.length;
		}
		@Override
		public Object getValueAt(int row, int column) {
			// TODO Auto-generated method stub
			return null;
		}

		// el JTable utiliza este método para determinar si una
		// celda concreta de la tabla es editable
		@Override
		public boolean isCellEditable(int row, int column) {
			// para este ejemplo, son editables todas menos
			// la primera columna
			return column >= 4;
		}

		//ns si es necesario
		/*
		 * // este método es utilizado por el JTable para actualizar
        // el modelo de datos asociado. 
        // Recibe un Object por lo que, sabiendo el dato interno
        // es necesario hacer un cast
        @Override
        public void setValueAt(Object value, int row, int column) {
            // Obtenemos el objeto del modelo interno (lista) que
            // que se debe actualizar en función del valor de fila recibido
            Person p = persons.get(row);
            // teniendo en cuenta el valor de la columna recibida
            // actualizamos la propiedad correspondiente de la Persona
            // teniendo en cuenta el tipo concreto de dato
            switch (column) {
                case 0:
                    p.setName((String) value);
                    break;
                case 1:
                    p.setSurname((String) value);
                    break;
                case 2:
                    p.setBirthdate((LocalDate) value);
                    break;
            }
            // este método se utiliza para notificar que el modelo de datos
            // se ha actualizado y se debe repintar la celda visual
            fireTableCellUpdated(row, column);
        }*/

	}



	public Ventana_principal(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH); //ventana maximizada
		setTitle("Ventana Principal");

		//Elementos creados
		//Paneles principales
		JPanel izquierda = new JPanel(new GridLayout(6, 1));
		JPanel boton_medio = new JPanel();
		JPanel abajo = new JPanel(new GridLayout(2, 1));
		JPanel abajo_arriba = new JPanel();
		JPanel abajo_abajo = new JPanel();
		JPanel arriba = new JPanel(new GridLayout(3, 1));
		JPanel arriba_arriba = new JPanel();
		JPanel arriba_abajo = new JPanel();
		JPanel arriba_medio = new JPanel();
		
		//paneles centro
		JPanel centro = new JPanel(new BorderLayout());
		JPanel p_perfil = new JPanel(new GridLayout(4, 2));
		JPanel p_canciones = new JPanel(new BorderLayout());
		
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
		ActionListener cambiar_perfil = new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				centro.removeAll();
				centro.add(p_perfil);
				centro.revalidate();
				centro.repaint();
			}
		};
		
		//Añadir los escuchadores de los botones
		b_perfil.addActionListener(cambiar_perfil);


		//Elementos del panel del centro
		//Perfil
		//Labels
		JLabel l_nombre = new JLabel("Nombre");
		JLabel l_correo = new JLabel("Correo");
		JLabel l_nom_usu = new JLabel("Nombre de usuario");
		JLabel l_contra = new JLabel("Contraseña");
		
		//TextField
		JTextField t_nombre = new JTextField();
		JTextField t_correo = new JTextField();
		JTextField t_nom_usu = new JTextField();
		JTextField t_contra = new JTextField();		
		
		//Canciones
		//Botones
		JButton b_cancion_nueva = new JButton("Añadir canción");

		//Tabla

		//MyTableModel modelo_tabla = new MyTableModel(Arrays.asList(persons));

		//JTable tabla_prin = new JTable(modelo_tabla);
		JTable tabla_prin = new JTable();

		//Elementos del JTable

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

		//Elementos del panel de abajo
		//texto
		JTextField busqueda = new JTextField(50);

		//imagenes de los botones
		ImageIcon i_lupa = new ImageIcon("src/Imagenes/lupa.jpg");

		//Boton
		JButton lupa = new JButton(i_lupa);



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
		//Añadir elementos al panel de perfil
		p_perfil.add(l_nombre);
		p_perfil.add(l_nom_usu);
		p_perfil.add(t_nombre);
		p_perfil.add(t_nom_usu);
		p_perfil.add(l_correo);
		p_perfil.add(l_contra);
		p_perfil.add(t_correo);
		p_perfil.add(t_contra);
		
		//Anaydir elementos al panel de canciones
		boton_medio.add(b_cancion_nueva);
		p_canciones.add(tabla_prin,BorderLayout.CENTER);
		p_canciones.add(boton_medio, BorderLayout.SOUTH);
		
		//añadir el panel a centro
		centro.add(p_canciones);

		
		//Anaydir elementos al panel de arriba
		arriba_medio.add(busqueda);
		arriba_medio.add(lupa);

		arriba.add(arriba_arriba);
		arriba.add(arriba_medio);
		arriba.add(arriba_abajo);


		//Anaydir elementos al panel principal
		this.add(izquierda, BorderLayout.WEST);
		this.add(centro, BorderLayout.CENTER);
		this.add(abajo, BorderLayout.SOUTH);
		this.add(arriba, BorderLayout.NORTH);

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

	public static void main(String[] args) {
		File fichero = new File("BD_Usuarios");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					BD_Usuaruis.cargarUsuarios(fichero);
				} catch (IOException e) {
					e.printStackTrace();
				}
				new Ventana_principal();
				System.out.println(BD_Usuaruis.Usuarios);
				BD_Usuaruis.guardarUsuarios(fichero);
			}
		});
	}
}