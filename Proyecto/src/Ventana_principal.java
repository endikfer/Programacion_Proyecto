import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.AbstractTableModel;



public class Ventana_principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Estructura de la tabla
	class Tabla extends AbstractTableModel{
		
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		//Array con los nombre de las columnas
		private String[] headers = { "Cancion", "Autor", "Duración" };
		
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
			return headers.length;
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
        JPanel centro = new JPanel(new BorderLayout());
        JPanel boton_medio = new JPanel();
        JPanel abajo = new JPanel(new GridLayout(2, 1));
        JPanel abajo_arriba = new JPanel();
        JPanel abajo_abajo = new JPanel();
        
        //Elementos del panel de la izquierda
        //imagenes de los botones
        ImageIcon i_cancion = new ImageIcon(getClass().getResource("cancion3.jpg"));
        ImageIcon i_ajuste = new ImageIcon(getClass().getResource("ajustes1.jpg"));
        ImageIcon i_perfil = new ImageIcon(getClass().getResource("perfil1.jpg"));
        ImageIcon i_cola = new ImageIcon(getClass().getResource("cola1.jpg"));
        //Botones
        JButton b_perfil = new JButton(i_perfil);
        JButton b_canciones = new JButton(i_cancion);
        JButton b_cola = new JButton(i_cola);
        JButton b_ajustes = new JButton(i_ajuste);
        
        //Elementos del panel del centro
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
        //imagenes de los botones
        ImageIcon i_atrasar = new ImageIcon( getClass().getResource("atrasar1.jpg"));
        ImageIcon i_pausar = new ImageIcon(getClass().getResource("pausar1.jpg"));
        ImageIcon i_adelantar = new ImageIcon(getClass().getResource("adelantar2.jpg"));
        //Botones
        JButton b_atras_can = new JButton(i_atrasar);
        JButton b_pausar_can = new JButton(i_pausar);
        JButton b_adelantar_can = new JButton(i_adelantar);
        //deslizador
        JSlider duracion_can = new JSlider();
        

        
        
        
        //Anaydir elementos a los paneles
        //Anaydir elementos al panel de la izquierda
        izquierda.add(b_perfil);
        izquierda.add(b_canciones);
        izquierda.add(b_cola);
        izquierda.add(b_ajustes);
        
        //Anaydir elementos al panel de abajo
        abajo_arriba.add(nom_can);
        abajo_abajo.add(foto_can);
        abajo_abajo.add(duracion_can);
        abajo_abajo.add(b_atras_can);
        abajo_abajo.add(b_pausar_can);
        abajo_abajo.add(b_adelantar_can);
        
        
        abajo.add(abajo_arriba);
        abajo.add(abajo_abajo);
        
        
        //Anaydir elementos al panel del centro
        boton_medio.add(b_cancion_nueva);
        centro.add(tabla_prin,BorderLayout.CENTER);
        centro.add(boton_medio, BorderLayout.SOUTH);

        
        //Anaydir elementos al panel principal
        this.add(izquierda, BorderLayout.WEST);
        this.add(centro, BorderLayout.CENTER);
        this.add(abajo, BorderLayout.SOUTH);

        
        setVisible(true);
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Ventana_principal();
                         
                try {
					BD_Usuaruis.cargarUsuarios("BD_Usuarios");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                System.out.println(BD_Usuaruis.Usuarios.keySet());
                
                
                BD_Usuaruis.guardarUsuarios("BD_Usuarios");
                                
            }

        });
    }

}
