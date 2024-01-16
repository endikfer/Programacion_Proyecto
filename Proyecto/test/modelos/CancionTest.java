package modelos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import domain.Cancion;

public class CancionTest {
	
	private Cancion can1;
	private Cancion can2;
	
	@Before
	public void setup() {
		can1 = new Cancion("a",20,"c","cd");
		can2 = new Cancion("a",20,"c","cd");
	}
	
	@Test
	public void getDurationTest() {
		assertEquals(20, can1.getDuration());
	}
	
	@Test
	public void setDurationTest() {
		can1.setDuration(30);
		assertEquals(30, can1.getDuration());
	}
	
	@Test
	public void getName_canTest() {
		assertEquals("c", can1.getName_can());
	}
	
	@Test
	public void setName_canTest() {
		can1.setName_can("b");
		assertEquals("b", can1.getName_can());
	}
	
	@Test
	public void getAlbumTest() {
		assertEquals("cd", can1.getAlbum());
	}
	
	@Test
	public void setAlbumTest() {
		can1.setAlbum("aa");
		assertEquals("aa", can1.getAlbum());
	}
	
	@Test
	public void toStringTest() {
		String a ="nombre: c, artista: a, duracion: 20, album: cd";
		assertEquals(a,can1.toString());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(can1.equals(can2));
	}
	
	@Test
	public void compareToTest() {
		assertEquals(0, can1.getName_can().compareTo(can2.getName_can()));
	}
}
