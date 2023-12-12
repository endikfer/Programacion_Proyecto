package canciones;

public class Artista {
	
	static String nombre_Ar;

	public String getNombre_Ar() {
		return nombre_Ar;
	}

	@SuppressWarnings("static-access")
	public void setNombre_Ar(String nombre_Ar) {
		this.nombre_Ar = nombre_Ar;
	}

	@SuppressWarnings("static-access")
	public Artista(String nombre_Ar) {
		this.nombre_Ar = nombre_Ar;
	}


}
