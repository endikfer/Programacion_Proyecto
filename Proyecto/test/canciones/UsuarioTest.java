package canciones;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {
	
	private Usuario usu;
	
	@Before
	public void setup() {
		usu = new Usuario("a","b","cd","as");
	}

	@Test
	public void getName_usTest() {
		assertEquals("b", usu.getName_us());
	}
	
	@Test
	public void setName_usTest() {
		usu.setName_us("c");
		assertEquals("c", usu.getName_us());
	}
	
	@Test
	public void getPasswordTest() {
		assertEquals("cd", usu.getPassword());
	}
	
	@Test
	public void setPasswordTest() {
		usu.setPassword("fd");
		assertEquals("fd", usu.getPassword());
	}
	
	@Test
	public void getName_realTest() {
		assertEquals("a", usu.getName_real());
	}
	
	@Test
	public void setName_realTest() {
		usu.setName_real("q");
		assertEquals("q", usu.getName_real());
	}
	
	@Test
	public void getGmailTest() {
		assertEquals("as", usu.getGmail());
	}
	
	@Test
	public void setGmailTest() {
		usu.setGmail("az");
		assertEquals("az", usu.getGmail());
	}
	
	@Test
	public void toStringTest() {
		String a ="Usuario [name_real=a, name_us=b, password=cd, gmail=as]";
		assertEquals(a,usu.toString());
	}

}
