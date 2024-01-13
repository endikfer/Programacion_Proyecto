package canciones;

public class Usuario {
	String name_real;
	String name_us;
	String password;
	String gmail;
	
	public Usuario(String name_real, String name_us, String password, String gmail) {
		super();
		this.name_real = name_real;
		this.name_us = name_us;
		this.password = password;
		this.gmail = gmail;
	}	

	public Usuario() {
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

	@Override
	public String toString() {
		return "Usuario [name_real=" + name_real + ", name_us=" + name_us + ", password=" + password + ", gmail="
				+ gmail + "]";
	}
}
