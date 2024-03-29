package funcionalidades;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import domain.Cancion;
import gui.ComparadorDura;

public class ComparadorDuraTest {
	
	private ComparadorDura com = new ComparadorDura();
	private Cancion can1;
	private Cancion can2;
	
	@Before
	public void setup() {
		can1 = new Cancion("a",20,"c","cd");
		can2 = new Cancion("a",20,"c","cd");
	}

	@Test
	public void test() {
		assertEquals(0, com.compare(can1, can2));
	}

}
