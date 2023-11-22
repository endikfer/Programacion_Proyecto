package ventanasadd;

public class CambioSegundoMinuto {
	public static int minutos = 0;
	public static int secrestante = 0;


	public static String cambioSec(int sec) {
		minutos = sec / 60;
		secrestante = sec % 60;
		if (sec>=60) {
			return String.format("%02d:%02d", minutos, secrestante);
		}else if(sec<60 && minutos == 0) {
			return String.format("%02d:%02d", minutos, sec);
		}else {
			return String.format("%02d:%02d", minutos, secrestante);
		}
	}
}
