package canciones;

public class Artista {
	
	static String nombre_Ar;

	public static String getNombre_Ar() {
		return nombre_Ar;
	}

	public static void setNombre_Ar(String nombre_Ar) {
		Artista.nombre_Ar = nombre_Ar;
	}

	@SuppressWarnings("static-access")
	public Artista(String nombre_Ar) {
		this.nombre_Ar = nombre_Ar;
	}


}
