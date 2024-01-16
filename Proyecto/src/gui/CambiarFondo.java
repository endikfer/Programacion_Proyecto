package gui;

import java.awt.Color;

public class CambiarFondo {
	@SuppressWarnings("unused")
	private VentanaPrincipal ventana;
	public void cambiarFondonegro(VentanaPrincipal ventana) {
		this.ventana = ventana;
		if (ventana.t_fondo.isSelected()) {
			ventana.p_perfil.setBackground(Color.BLACK);
			ventana.izquierda.setBackground(Color.BLACK);
			ventana.abajo.setBackground(Color.BLACK);
			ventana.abajo_arriba.setBackground(Color.BLACK);
			ventana.abajo_abajo.setBackground(Color.BLACK);
			ventana.p_ajustes.setBackground(Color.BLACK);
			ventana.p_ajustes.setBackground(Color.BLACK);
			ventana.p_fondo.setBackground(Color.BLACK);
			ventana.p_bucle.setBackground(Color.BLACK);
			ventana.p_barra.setBackground(Color.BLACK);
			ventana.p_flecha.setBackground(Color.BLACK);
			ventana.boton_medio.setBackground(Color.BLACK);
			ventana.centro_arriba.setBackground(Color.BLACK);
			ventana.centro_canciones.setBackground(Color.BLACK);
			ventana.centro_canciones.setBackground(Color.BLACK);
			ventana.p_cola.setBackground(Color.BLACK);
			ventana.p_combo.setBackground(Color.BLACK);
			ventana.p_cola.setBackground(Color.BLACK);
			ventana.p_lista.setBackground(Color.BLACK);
			ventana.pBotonesCola.setBackground(Color.BLACK);
			
			ventana.t_final.setForeground(Color.WHITE);
			ventana.t_duracion.setForeground(Color.WHITE);
			ventana.nom_can.setForeground(Color.WHITE);
			ventana.l_fondo.setForeground(Color.WHITE);
			ventana.l_bucle.setForeground(Color.WHITE);
			ventana.l_atajos.setForeground(Color.WHITE);
			ventana.l_barra.setForeground(Color.WHITE);
			ventana.l_flecha.setForeground(Color.WHITE);
			ventana.l_exp1.setForeground(Color.WHITE);
			ventana.l_exp2.setForeground(Color.WHITE);
			ventana.l_exp3.setForeground(Color.WHITE);
			ventana.l_nombre.setForeground(Color.WHITE);
			ventana.l_correo.setForeground(Color.WHITE);
			ventana.l_nom_usu.setForeground(Color.WHITE);
			ventana.l_contra.setForeground(Color.WHITE);
		} else {
			ventana.p_perfil.setBackground(ventana.colorFondo);
			ventana.izquierda.setBackground(ventana.colorFondo);
			ventana.abajo.setBackground(ventana.colorFondo);
			ventana.abajo_arriba.setBackground(ventana.colorFondo);
			ventana.abajo_abajo.setBackground(ventana.colorFondo);
			ventana.p_ajustes.setBackground(ventana.colorFondo);
			ventana.p_ajustes.setBackground(ventana.colorFondo);
			ventana.p_fondo.setBackground(ventana.colorFondo);
			ventana.p_bucle.setBackground(ventana.colorFondo);
			ventana.p_barra.setBackground(ventana.colorFondo);
			ventana.p_flecha.setBackground(ventana.colorFondo);
			ventana.boton_medio.setBackground(ventana.colorFondo);
			ventana.centro_arriba.setBackground(ventana.colorFondo);
			ventana.centro_canciones.setBackground(ventana.colorFondo);
			ventana.p_cola.setBackground(ventana.colorFondo);
			ventana.p_combo.setBackground(ventana.colorFondo);
			ventana.p_cola.setBackground(ventana.colorFondo);
			ventana.p_lista.setBackground(ventana.colorFondo);
			ventana.pBotonesCola.setBackground(ventana.colorFondo);

			ventana.t_final.setForeground(Color.BLACK);
			ventana.t_duracion.setForeground(Color.BLACK);
			ventana.nom_can.setForeground(Color.BLACK);
			ventana.l_fondo.setForeground(Color.BLACK);
			ventana.l_bucle.setForeground(Color.BLACK);
			ventana.l_atajos.setForeground(Color.BLACK);
			ventana.l_barra.setForeground(Color.BLACK);
			ventana.l_flecha.setForeground(Color.BLACK);
			ventana.l_exp1.setForeground(Color.BLACK);
			ventana.l_exp2.setForeground(Color.BLACK);
			ventana.l_exp3.setForeground(Color.BLACK);
			ventana.l_nombre.setForeground(Color.BLACK);
			ventana.l_correo.setForeground(Color.BLACK);
			ventana.l_nom_usu.setForeground(Color.BLACK);
			ventana.l_contra.setForeground(Color.BLACK);
		}
	}
}
