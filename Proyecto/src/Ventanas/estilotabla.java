package Ventanas;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class estilotabla extends DefaultTableCellRenderer {
	    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        Component rendererComp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	        if (row == 0) {
	            rendererComp.setFont(new Font("Serif", Font.BOLD, 30));
	        }
	        return rendererComp;
	    }
	}

