package Canciones;

import java.awt.Image;

public class Cancion extends Artista{
	
	@Override
	public String toString() {
		return name_can +", duracion: " + duration + ", album: " + album;
	}


	protected int duration;
	protected String name_can;
	protected Image foto;
	protected String album;
	
	
	public Cancion(String nombre_Ar, int duration, String name_can, Image foto, String album) {
		super(nombre_Ar);
		this.duration = duration;
		this.name_can = name_can;
		this.foto = foto;
		this.album = album;
	}
	
	
	public Cancion(String nombre_Ar, String name_can, int duration, String album) {
		super(nombre_Ar);
		this.name_can = name_can;
		this.duration = duration;
		this.album = album;
	}


	//Prueba luego se quita
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


	public String getAlbum() {
		return album;
	}


	public void setAlbum(String album) {
		this.album = album;
	}
}