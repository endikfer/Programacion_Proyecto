package funcionalidades;

import static org.junit.Assert.*;

import org.junit.Test;

import funcionalidades.CambioSegundoMinuto;

public class CambioSegundoMinutoTest {

	@Test
	public void cambioSectest() {
		assertEquals("01:00", CambioSegundoMinuto.cambioSec(60));
	}

}
