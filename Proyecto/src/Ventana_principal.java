import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Ventana_principal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ventana_principal(){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(this.MAXIMIZED_BOTH); //ventana maximizada
		//setSize(1380, 730);  ventana a tamaño pequeño
        setTitle("Ventana Principal");
        setVisible(true);
	}
	
	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Ventana_principal();
            }

        });
    }

}
