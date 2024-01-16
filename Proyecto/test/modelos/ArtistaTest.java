package modelos;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ArtistaTest {

	private Artista art1;
	private Artista art2;
		
		@Before
		public void setup() {
			art1 = new Artista("a");
			art2 = new Artista("a");
		}
		
		@Test
		public void getNombre_ArTest() {
			assertEquals("a", art1.getNombre_Ar());
		}
		
		@Test
		public void setNombre_ArTest() {
			art1.setNombre_Ar("c");
			assertEquals("c", art1.getNombre_Ar());
		}
		
		@Test
		public void toStringTest() {
			String a ="Artista [nombre_Ar=a]";
			assertEquals(a,art1.toString());
		}
		
		@Test
		public void equalsTest() {
			assertTrue(art1.equals(art2));
		}

}
