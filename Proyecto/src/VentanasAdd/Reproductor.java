package VentanasAdd;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Reproductor {
	public static void reproducir(Boolean pararcancion,File archivo) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            while (!pararcancion) {
                if (System.in.available() > 0) {
                    char input = (char) System.in.read();
                    if (input == 'P' || input == 'p') {
                    	pararcancion = true;
                    }
                }
            }

            clip.stop();
            clip.close();
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }
		
}
