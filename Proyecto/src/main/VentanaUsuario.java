package main;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import db.BDExcepcion;
import db.BDManejoUsu;
import domain.Usuario;
import gui.Loggers;
import gui.VentanaPrincipal;
import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Font;

public class VentanaUsuario extends JFrame{

	private static final long serialVersionUID = 1L;
	protected static final int MIN_LONGITUD_CONTRASENA = 8;
	private static JPanel pCent, pIs, pR, pNomIs, pConIs, pNomR, pConR, pMailR, pBtnIs, pBtnR, pNomRealR, pMensaje;
	private static JLabel lblIs, lblR, lblNomIs, lblConIs, lblNomR, lblConR, lblMailR, lblNomRealR, lError;
	private static JButton btnIs, btnR;
	private static JTextField txtNomIs, txtNomR, txtMailR, txtNomRealR;
	private static JPasswordField passConR, passConIs;
	private static ArrayList<Usuario> usuarios;
	public String nomUsu;
	public BDManejoUsu bd;

	public VentanaUsuario() throws HeadlessException {
		super();
		setTitle("YOUPLAY");
		setBounds(200,200,800,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		//Inicialización de los componentes
		usuarios = new ArrayList<Usuario>();
		bd = new BDManejoUsu();
		try {
			bd.connect("resources/db/Usuario.db");
			usuarios = (ArrayList<Usuario>) bd.getTodosUsu();
			bd.disconnect();
		} catch (BDExcepcion e) {
			Loggers.logger.warning("Error al conectar con la BD");
		}

		// Paneles
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
		pMensaje = new JPanel();

		// Labels
		lblIs = new JLabel("INICIO DE SESIÓN");
		lblIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblR = new JLabel("REGISTRO");
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomR = new JLabel("Nombre usuario:");
		lblNomIs = new JLabel("Nombre usuario:");
		lblConIs = new JLabel("Contraseña:");
		lblConR = new JLabel("Contraseña:");
		lblMailR = new JLabel("E-mail:");
		lblNomRealR = new JLabel("Nombre:");
		lError = new JLabel();
		lError.setForeground(Color.RED);
		lError.setVerticalAlignment(JLabel.TOP); // Alinea el texto en la parte superior del JLabel

		// Botones
		btnIs = new JButton("INICIAR SESIÓN");
		btnR = new JButton("REGISTRARSE");

		// JTextFields
		txtNomIs = new JTextField(15);
		txtNomR = new JTextField(15);
		txtNomRealR = new JTextField(15);
		txtMailR = new JTextField(15);
		passConR = new JPasswordField(15);
		passConIs = new JPasswordField(15);

		//Diseño de los paneles
		pCent.setLayout(new GridLayout(1,2));
		pIs.setLayout(new GridLayout(7,1));
		pIs.add(lblIs);
		pIs.add(new JLabel());
		pNomIs.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pNomIs.add(lblNomIs, "cell 0 0,alignx left,aligny center");
		pNomIs.add(txtNomIs, "cell 1 0,alignx left,aligny top");
		pIs.add(pNomIs);
		pConIs.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pConIs.add(lblConIs, "cell 0 0,alignx left,aligny center");
		pConIs.add(passConIs, "cell 1 0,alignx left,aligny top");
		pIs.add(pConIs);
		pBtnIs.add(btnIs);
		pIs.add(new JLabel());
		pIs.add(new JLabel());
		pIs.add(pBtnIs);
		pCent.add(pIs);

		pR.setLayout(new GridLayout(7,1));
		pR.add(lblR);
		pMensaje.add(lError);
		pNomR.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pNomR.add(lblNomR, "cell 0 0,alignx left,aligny center");
		pNomR.add(txtNomR, "cell 1 0,alignx left,aligny top");

		pR.add(pMensaje);
		pR.add(pNomR);
		pNomRealR.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pNomRealR.add(lblNomRealR, "cell 0 0,alignx left,aligny center");
		pNomRealR.add(txtNomRealR, "cell 1 0,alignx left,aligny top");
		pR.add(pNomRealR);
		pConR.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pConR.add(lblConR, "cell 0 0,alignx left,aligny center");
		pConR.add(passConR, "cell 1 0,alignx left,aligny top");
		pR.add(pConR);
		pMailR.setLayout(new MigLayout("", "[95px][180px]", "[20px]"));
		pMailR.add(lblMailR, "cell 0 0,alignx left,aligny center");
		pMailR.add(txtMailR, "cell 1 0,alignx left,aligny top");
		pR.add(pMailR);
		pBtnR.add(btnR);
		pR.add(pBtnR);
		pCent.add(pR);

		getContentPane().add(pCent,BorderLayout.CENTER);

		//Eventos		
		btnR.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Obtener los valores de los campos de texto y contraseña
				String email = txtMailR.getText();
				String nomUsuario = txtNomR.getText();
				String nomReal = txtNomRealR.getText();
				char[] contrasenaArray = passConR.getPassword();
				String contrasena = new String(contrasenaArray);

				// Variable para verificar si todas las validaciones son exitosas
				boolean todasLasValidacionesPasaron = true;
				
				// Variable para verificar si todas las validaciones son exitosas
				boolean falloContraseña = false;

				// StringBuilder para acumular los mensajes de error
				StringBuilder mensajesError = new StringBuilder();

				// Validar si alguno de los campos está vacío
				if (email.isEmpty() || nomUsuario.isEmpty() || nomReal.isEmpty() || contrasena.isEmpty()) {
					// Acumular mensaje de error si algún campo está vacío
					mensajesError.append("Alguno de los campos está vacío\n");
					todasLasValidacionesPasaron = false;
				} else {
					// Si ninguno de los campos está vacío, realizar todas las validaciones

					// Validar la dirección de correo electrónico
					if (!validarEmail(email)) {
						// Acumular mensaje de error si el email no es válido
						mensajesError.append("Por favor, escribe una dirección de e-mail válida\n");
						todasLasValidacionesPasaron = false;
					}

					// Validar la contraseña
					if (!cumpleCriteriosContrasena(contrasena)) {
						// Acumular mensaje de error si la contraseña no cumple con los criterios
						mensajesError.append("La contraseña debe tener al menos 8 caracteres, una mayúscula, una minúscula y un número\n");
						Arrays.fill(contrasenaArray, ' '); // Limpiar el array de la contraseña
						falloContraseña = true;
						todasLasValidacionesPasaron = false;
					}

					// Validar el nombre de usuario solo si no está vacío
					if (!nomReal.isEmpty() && !cumpleCriteriosUsuario(nomReal)) {
						// Acumular mensaje de error si el nombre de usuario no cumple con los criterios
						mensajesError.append("El nombre solo puede contener letras\n");
						Arrays.fill(contrasenaArray, ' '); // Limpiar el array de la contraseña
						todasLasValidacionesPasaron = false;
					}
				}

				// Si alguna validación falló, mostrar todos los mensajes acumulados
				if (!todasLasValidacionesPasaron) {
					lError.setText("<html>" + mensajesError.toString().replaceAll("\n", "<br>") + "</html>");

					if(falloContraseña) {
						 lError.setFont(new Font("Tahoma", Font.PLAIN, 9));
					}else {
						 lError.setFont(new Font("Tahoma", Font.PLAIN, 12));
					}		       
					return; // No continuar con el registro si hay errores
				}else {
					// Crear el objeto Usuario
					Usuario us = new Usuario(nomReal, nomUsuario, contrasena, email);

					// Verificar si el usuario ya está registrado
					if (!usuarios.contains(us)) {
						usuarios.add(us);

						// Guardar en la base de datos
						try {
							bd.connect("resources/db/Usuario.db");
							bd.guardar(us);
							bd.disconnect();
							JOptionPane.showMessageDialog(pCent, "Registro exitoso");
						} catch (BDExcepcion e1) {
							JOptionPane.showMessageDialog(pCent, "Error al guardar en la base de datos: " + e1.getMessage());
						}
					} else {
						JOptionPane.showMessageDialog(pCent, "ESTE USUARIO YA ESTÁ REGISTRADO");
					}

					// Restablecer los campos
					txtMailR.setText("");
					txtNomR.setText("");
					txtNomRealR.setText("");
					passConR.setText("");
					Arrays.fill(contrasenaArray, ' '); // Limpiar el array de la contraseña
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
					bd.connect("resources/db/Usuario.db");
					usuarios = (ArrayList<Usuario>) bd.getTodosUsu();
					bd.disconnect();
				} catch (BDExcepcion e1) {
					Loggers.logger.warning("Error al conectar con la BD");
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
					JOptionPane.showMessageDialog(pCent, "Usuario o Contraseña incorrecta");

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

	public static boolean validarEmail(String email) {
		// Patrón de expresión regular para validar un email
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$";

		// Compilar la expresión regular en un patrón
		Pattern pattern = Pattern.compile(regex);

		// Crear un matcher que buscará el patrón en el email
		Matcher matcher = pattern.matcher(email);

		// Devolver true si el email coincide con el patrón, de lo contrario, false
		return matcher.matches();
	}

	// Método para verificar si la contraseña cumple con ciertos criterios
	public static boolean cumpleCriteriosContrasena(String contrasena) {
		// Ajusta estos criterios según tus necesidades
		return contrasena.length() >= MIN_LONGITUD_CONTRASENA && // Mínimo 8 caracteres
				contieneMayuscula(contrasena) && // Al menos una letra mayúscula
				contieneMinuscula(contrasena) && // Al menos una letra minúscula
				contieneNumero(contrasena); // Al menos un número
	}

	// Método para verificar si el nombre de usuario cumple con ciertos criterios
	private static boolean contieneSoloLetras(String str) {
		return str.chars().allMatch(Character::isLetter);
	}

	private static boolean cumpleCriteriosUsuario(String nomUsuario) {
		// Ajusta estos criterios según tus necesidades
		return contieneSoloLetras(nomUsuario); // Solo letras permitidas
	}

	// Métodos de ayuda para verificar ciertos criterios específicos

	private static boolean contieneMayuscula(String str) {
		return str.chars().anyMatch(Character::isUpperCase);
	}

	private static boolean contieneMinuscula(String str) {
		return str.chars().anyMatch(Character::isLowerCase);
	}

	private static boolean contieneNumero(String str) {
		return str.chars().anyMatch(Character::isDigit);
	}
}