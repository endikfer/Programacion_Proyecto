package VentanasAdd;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Reproductor {
//	public static Clip clip;
//	public static void reproducir(File archivo) {
//        try {
//            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
//            clip = AudioSystem.getClip();
//            clip.open(audioInputStream);
//            clip.start();
//        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//	public static void pararcancion(Boolean pararcancion) {
//		if(clip != null && clip.isRunning()) {
//			clip.stop();
//			clip.close();
//		}
//		
//	}
	
	
	public static void reproducir(Boolean activador, File archivo) {
      try {
          AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(archivo);
          Clip clip = AudioSystem.getClip();
          clip.open(audioInputStream);
          clip.start();
          while (activador == false) {
        	  clip.stop();
//        	  if(activador == false) {
//        		  clip.stop();;
//        	  }
          }
          
      } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
          e.printStackTrace();
      }
  }
		
}
