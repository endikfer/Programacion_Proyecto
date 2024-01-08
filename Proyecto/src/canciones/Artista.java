package canciones;

import java.util.Objects;

public class Artista {
	
	protected String nombre_Ar;

	public String getNombre_Ar() {
		return nombre_Ar;
	}

	public void setNombre_Ar(String nombre_Ar) {
		this.nombre_Ar = nombre_Ar;
	}

	public Artista(String nombre_Ar) {
		this.nombre_Ar = nombre_Ar;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Artista otroArtista = (Artista) obj;
	    return nombre_Ar.equals(otroArtista.nombre_Ar);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(nombre_Ar);
	}

}
