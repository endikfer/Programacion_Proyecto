package canciones;

import java.awt.Image;
import java.util.Objects;

public class Cancion extends Artista implements Comparable<Cancion>{
	
	protected int duration;
	protected String name_can;
	protected Image foto;
	protected String album;
	
	
	public Cancion(String nombre_Ar, int duration, String name_can, Image foto, String album) {
		super(nombre_Ar);
		this.name_can = name_can;
		this.duration = duration;
		this.album = album;
		this.foto = foto;
	}
	
	

	public Cancion(String nombre_Ar, String name_can, int duration, String album) {
		super(nombre_Ar);
		this.name_can = name_can;
		this.duration = duration;
		this.album = album;
	}
	
	public Cancion() {
		super("");
	}




	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public String getName_can() {
		return name_can;
	}


	public void setName_can(String name_can) {
		this.name_can = name_can;
	}


	public Image getFoto() {
		return foto;
	}


	public void setFoto(Image foto) {
		this.foto = foto;
	}


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}
	
	@Override
	public String toString() {
		return "nombre: " + name_can + ", artista: " +  nombre_Ar + ", duracion: " + duration + ", album: " + album;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    Cancion otraCancion = (Cancion) obj;
	    return name_can.equals(otraCancion.name_can);
	}

	@Override
	public int hashCode() {
	    return Objects.hash(name_can);
	}
	
	@Override
	public int compareTo(Cancion o) {
		return this.name_can.compareTo(o.getName_can());
	}
}