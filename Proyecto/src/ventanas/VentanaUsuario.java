package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import canciones.Usuario;

public class VentanaUsuario extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static JPanel pCent, pIs, pR, pNomIs, pConIs, pNomR, pConR, pMailR, pBtnIs, pBtnR, pNomRealR;
	private static JLabel lblIs, lblR, lblNomIs, lblConIs, lblNomR, lblConR, lblMailR, lblNomRealR;
	private static JButton btnIs, btnR;
	private static JTextField txtNomIs, txtNomR, txtMailR, txtNomRealR;
	private static JPasswordField passConR, passConIs;
	private static ArrayList<Usuario> usuarios;
	public String NomUsu;
	
	

	
	public VentanaUsuario() throws HeadlessException {
		super();
		
		setTitle("YOUPLAY");
		setBounds(200,200,600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Inicialización de los componentes
		usuarios = new ArrayList<Usuario>();
		cargarUsuarios(usuarios, "Usuarios.db");
		
		
		pCent = new JPanel();
		pIs = new JPanel();
		pR = new JPanel();
		pNomIs = new JPanel();
		pConIs = new JPanel();
		pNomR = new JPanel();
		pConR = new JPanel();
		pMailR = new JPanel();
		pNomRealR = new JPanel();
		pBtnIs = new JPanel();
		pBtnR = new JPanel();
		
		lblIs = new JLabel("      INICIO DE SESIÓN");
		lblR = new JLabel("      REGISTRO");
		lblNomIs = new JLabel("Nombre usuario: ");
		lblNomR = new JLabel("Nombre usuario: " );
		lblConIs = new JLabel("Contraseña: ");
		lblConR = new JLabel("Contraseña: ");
		lblMailR = new JLabel("e-mail: ");
		lblNomRealR = new JLabel("Nombre: ");
		
		btnIs = new JButton("INICIAR SESIÓN");
		btnR = new JButton("REGISTRARSE");
		
		txtNomIs = new JTextField(15);
		txtNomR = new JTextField(15);
		txtNomRealR = new JTextField(20);
		txtMailR = new JTextField(20);
		
		passConIs = new JPasswordField(20);
		passConR = new JPasswordField(20);
		
		//Diseño de los paneles
		pCent.setLayout(new GridLayout(1,2));
		pIs.setLayout(new GridLayout(4,1));
		pIs.add(lblIs);
		pNomIs.add(lblNomIs);
		pNomIs.add(txtNomIs);
		pIs.add(pNomIs);
		pConIs.add(lblConIs);
		pConIs.add(passConIs);
		pIs.add(pConIs);
		pBtnIs.add(btnIs);
		pIs.add(pBtnIs);
		pCent.add(pIs);
		pR.setLayout(new GridLayout(6,1));
		pR.add(lblR);
		pNomR.add(lblNomR);
		pNomR.add(txtNomR);
		pR.add(pNomR);
		pNomRealR.add(lblNomRealR);
		pNomRealR.add(txtNomRealR);
		pR.add(pNomRealR);
		pConR.add(lblConR);
		pConR.add(passConR);
		pR.add(pConR);
		pMailR.add(lblMailR);
		pMailR.add(txtMailR);
		pR.add(pMailR);
		pBtnR.add(btnR);
		pR.add(pBtnR);
		pCent.add(pR);
		getContentPane().add(pCent,BorderLayout.CENTER);
		
		//Eventos
		
		btnIs.addActionListener(new ActionListener() {//TODO
			/**
			 * Este botón comprueba que los datos del usuario estén guardados en una array,
			 * si está, le permite acceder a la aplicación, y si no, le salta un error.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean finish = false;
				String nombre = txtNomIs.getText();
				String con = passConIs.getText();
				
				NomUsu = txtNomIs.getText();
				
				
				for(Usuario u : usuarios) {
					if(u.getName_us().equals(nombre) && u.getPassword().equals(con)) {
						VentanaPrincipal vp = new VentanaPrincipal();
						dispose();
						break;
					}
					finish = true;
				}
				if (finish == true) {
					JOptionPane.showMessageDialog(pCent, "Este usuario NO EXISTE.");
					
					txtNomIs.setText("");
					passConIs.setText("");
				}
			}
		});
		
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Usuario us = new Usuario(txtNomRealR.getText(), txtNomR.getText(), passConR.getText(), txtMailR.getText());
				
				if(!usuarios.contains(us)) usuarios.add(us);
				else JOptionPane.showMessageDialog(pCent, "ESTE USUARIO YA ESTÁ REGISTRADO");
				
				txtMailR.setText("");
				txtNomR.setText("");
				txtNomRealR.setText("");
				passConR.setText("");
				
				actualizarDB("Usuarios.db");
			}
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				actualizarDB("Usuarios.db");
			}
		});
		
				
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		VentanaUsuario v = new VentanaUsuario();
	}
	
	private static void cargarUsuarios(ArrayList<Usuario> usuarios, String dbPath){
		//TODO
		/**
		 * Este método lee de una base de datos, y carga los usuarios almacenados en ella en
		 * un arraylist que es con lo que trabaja luego la ventana.
		 */
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" +"lib/Usuarios.db");
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT nombre, gmail, nombre_usu, contraseña FROM usuario WHERE nombre_usu = ?");
			
			while(rs.next()) {
				String nombre = rs.getString("nombre_usu");
				String nombreReal = rs.getString("nombre");
				String mail = rs.getString("gamil");
				String password = rs.getString("contraseña");
				
				Usuario us = new Usuario(nombre, nombreReal, password, mail);
				usuarios.add(us);
			}
			
			rs.close();
			stm.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void actualizarDB(String str) {
		//TODO
		/**
		 * Este método cargará el arraylist de usuarios en la base de datos de usuarios
		 * para mantenerla actualizada.
		 */
		String sql = String.format("INSERT INTO usuarios VALUES ('%s', '%s', %s, '%s')", txtNomRealR.getText(), txtMailR.getText(), txtNomR.getText(), passConR.getText());
		
		try {
			Class.forName("org.sqlite.JDBC");
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" +"lib/Usuarios.db");
			
			Statement stm = conn.createStatement();
			int rows = stm.executeUpdate(sql);
			
			stm.close();
			conn.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	public static String getNomUsu() {
		return txtNomIs.getText();
	}
}
