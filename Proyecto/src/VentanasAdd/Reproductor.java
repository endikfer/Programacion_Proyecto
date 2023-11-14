package VentanasAdd;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Reproductor {
	public void reproducir(File rutacancion) {
		try {
			// Ruta del archivo .wav
			String archivoWav = "rutacancion";

			// Crea un objeto File con la ruta del archivo
			File archivo = new File(archivoWav);

			// Crea un objeto AudioInputStream utilizando el archivo
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);

			// Obtiene el clip de audio
			Clip clip = AudioSystem.getClip();

			// Abre el clip de audio con el AudioInputStream
			clip.open(audioInputStream);

			// Reproduce el clip de audio
			clip.start();

			// Espera hasta que termine de reproducirse
			while (!clip.isRunning()) {
				Thread.sleep(10);
			}
			while (clip.isRunning()) {
				Thread.sleep(10);
			}

			// Cierra el AudioInputStream y el Clip
			clip.close();
			audioInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
