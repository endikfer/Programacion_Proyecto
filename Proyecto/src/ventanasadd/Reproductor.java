package ventanasadd;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Reproductor {
	
	SiguienteCancion sigc;

	public static Clip clip;

	public static void play() {
		clip.start();
	}

	
	public static void pause() {
		clip.stop();
	}
	
	public static void restart() {
		clip.setFramePosition(0);
	}
	
	public static void close() {
		clip.close();
	}

	public static void reproduce(File file) {
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			Loggers.logger.warning("Error al reproducir la cancion");
		}
	}

}
