package ventanas;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaFichero extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel_prin, panel_sec;
	private JLabel label, relleno1, relleno2, relleno3;
	private JButton boton;
	private JTextField texto;
	
	public VentanaFichero() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("YOUPLAY");
		setSize(500, 300);
		setLocationRelativeTo(null);
		
		panel_prin = new JPanel(new BorderLayout());
		panel_sec = new JPanel(new GridLayout(5,1));
		label = new JLabel("Introduzca el nombre del archivo, por favor");
		boton = new JButton("Confirmar");
		texto = new JTextField(30);
		relleno1 = new JLabel();
		relleno2 = new JLabel();
		relleno3 = new JLabel();
		
		panel_sec.add(relleno1);
		panel_sec.add(label);
		panel_sec.add(relleno2);
		panel_sec.add(texto);
		panel_sec.add(relleno3);
		panel_prin.add(boton, BorderLayout.SOUTH);
		panel_prin.add(panel_sec, BorderLayout.CENTER);
		
		panel_prin.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(panel_prin, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
}
