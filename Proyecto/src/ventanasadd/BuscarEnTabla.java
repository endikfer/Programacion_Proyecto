package ventanasadd;

import javax.swing.JOptionPane;
import ventanas.VentanaPrincipal;

public class BuscarEnTabla {
	private VentanaPrincipal ventana;
	
	public BuscarEnTabla(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void Buscar() {
		String textoBuscado = ventana.busqueda.getText().toLowerCase();
		
        for (int i = 0; i < ventana.tabla_canciones.getRowCount(); i++) {
            for (int j = 0; j < ventana.tabla_canciones.getColumnCount(); j++) {
                Object valorCelda = ventana.tabla_canciones.getValueAt(i, j);
                if (valorCelda != null && valorCelda.toString().toLowerCase().equals(textoBuscado)) {
                	ventana.tabla_canciones.setRowSelectionInterval(i,i);
                    return;
                }
            } 
        }
        JOptionPane.showMessageDialog(ventana, "Texto no encontrado en la tabla", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
	}
}
