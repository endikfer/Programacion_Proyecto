package ventanasadd;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class ModeloLista extends DefaultListCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public Component getListCellRendererComponent( JList list, Object value, int index,boolean isSelected, boolean cellHasFocus) {
		Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		
		c.setFont(new Font("Serif", Font.BOLD, 30));
		c.setForeground(Color.BLUE);
		return c;
	}
}