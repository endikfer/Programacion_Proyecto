package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import bd.BDExcepcion;
import bd.BDManejoUsu;
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
	public String nomUsu;
	public BDManejoUsu bd;
	
	

	
	public VentanaUsuario() throws HeadlessException {
		super();
		
		setTitle("YOUPLAY");
		setBounds(200,200,600,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Inicialización de los componentes
		usuarios = new ArrayList<Usuario>();
		bd = new BDManejoUsu();
		try {
			bd.connect("Usuario.db");
			usuarios = (ArrayList<Usuario>) bd.getTodosUsu();
			bd.disconnect();
		} catch (BDExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		
		btnR.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("deprecation")
				Usuario us = new Usuario(txtNomRealR.getText(), txtNomR.getText(), passConR.getText(), txtMailR.getText());
				
				if(!usuarios.contains(us)) {
					usuarios.add(us);
					System.out.println("Registrado");
				}else JOptionPane.showMessageDialog(pCent, "ESTE USUARIO YA ESTÁ REGISTRADO");
				
				txtMailR.setText("");
				txtNomR.setText("");
				txtNomRealR.setText("");
				passConR.setText("");
				
				try {
					bd.connect("Usuario.db");
					bd.guardar(us);
					bd.disconnect();
				} catch (BDExcepcion e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnIs.addActionListener(new ActionListener() {
			/**
			 * Este botón comprueba que los datos del usuario estén guardados en una array,
			 * si está, le permite acceder a la aplicación, y si no, le salta un error.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean finish = false;
				String nombre = txtNomIs.getText();
				@SuppressWarnings("deprecation")
				String con = passConIs.getText();
				
				nomUsu = txtNomIs.getText();
				
				try {
					bd.connect("Usuario.db");
					usuarios = (ArrayList<Usuario>) bd.getTodosUsu();
					bd.disconnect();
				} catch (BDExcepcion e1) {
					e1.printStackTrace();
				}
				
				
				for(Usuario u : usuarios) {
					if(u.getName_us().equals(nombre) && u.getPassword().equals(con)) {
						@SuppressWarnings("unused")
						VentanaPrincipal vp = new VentanaPrincipal();
						dispose();
						finish = false;
						break;
					}else {
						finish = true;
					}
				}
				if (finish == true) {
					JOptionPane.showMessageDialog(pCent, "Este usuario NO EXISTE.");
					
					txtNomIs.setText("");
					passConIs.setText("");
				}
			}
		});		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		VentanaUsuario v = new VentanaUsuario();
	}
	
	public static String getNomUsu() {
		return txtNomIs.getText();
	}
}
