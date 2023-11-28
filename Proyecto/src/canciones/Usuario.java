package canciones;

public class Usuario {
	String name_real;
	String name_us;
	String password;
	String gmail;
	int id;
	
	
	
	public Usuario(String name_real, String name_us, String password, String gmail, int id) {
		super();
		this.name_real = name_real;
		this.name_us = name_us;
		this.password = password;
		this.gmail = gmail;
		this.id = id;
	}


	//prueba
	public Usuario(String name_us, String password) {
		this.name_us = name_us;
		this.password = password;
	}
	

	public Usuario() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public String getName_real() {
		return name_real;
	}


	public void setName_real(String name_real) {
		this.name_real = name_real;
	}


	public String getGmail() {
		return gmail;
	}


	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	
	
	
	
}
