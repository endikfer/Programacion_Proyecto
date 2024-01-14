package ventanasadd;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import ventanas.VentanaPrincipal;


public class Reproductor {

	SiguienteCancion sigc;
	public static VentanaPrincipal ventana;


	@SuppressWarnings("static-access")
	public Reproductor(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public static Clip clip;

	public static void play() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.start();
		}
	}


	public static void pause() {
		if(clip!=null) {
			clip.stop();
		}
	}

	public static void restart() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.setFramePosition(0);
		}
	}

	public static void close() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.close();
		}
	}

	public static void reproduce(File file) {
		try {
			if(file==null) {
				JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			Loggers.logger.warning("Error al reproducir la cancion");
		}
	}

}
