package funcionalidades;

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
	public VentanaPrincipal ventana;
	public Clip clip;

	public Reproductor(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	public void play() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.start();
		}
	}

	public void pause() {
		if(clip!=null) {
			clip.stop();
		}
	}

	public void restart() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.setFramePosition(0);
		}
	}

	public void close() {
		if(clip==null) {
			JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
		}else {
			clip.close();
		}
	}

	public void reproduce(File file) {
		try {
			if(file==null) {
				JOptionPane.showMessageDialog(ventana, "No hay cancion seleccionada para reproducir.", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				clip = AudioSystem.getClip();
				clip.open(audioStream);
			}
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			Loggers.logger.warning("Error al reproducir la cancion");
		}
	}
}