package Canciones;

import java.awt.Image;

public class Cancion extends Artista{
	
	int duration;
	String name_can;
	protected Image foto;
	
	public Cancion(String nombre_Ar, String name_can, int duration, Image foto) {
		super(nombre_Ar);
		this.name_can = name_can;
		this.duration = duration;
		this.foto = foto;
	}	
	public Cancion(String nombre_Ar, String name_can) {
		super(nombre_Ar);
		this.name_can = name_can;
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

	
	

}