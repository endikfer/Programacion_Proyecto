package Canciones;

import java.awt.Image;

public class Cancion {
	protected String nombre;
	protected int duracion;
	protected Image foto;
	public Cancion(String nombre, int duracion, Image foto) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.foto = foto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}	

}
