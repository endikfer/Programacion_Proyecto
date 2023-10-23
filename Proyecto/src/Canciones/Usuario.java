package Canciones;

public class Usuario {
	String name_us;
	String password;
	
	public Usuario(String name_us, String password) {
		this.name_us = name_us;
		this.password = password;
	}
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}


	public String getName_us() {
		return name_us;
	}
	public void setName_us(String name_us) {
		this.name_us = name_us;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
	
	
	
}
