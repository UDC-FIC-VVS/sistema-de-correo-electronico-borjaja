package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class ReenvioTest {
	@Test
	public void TestReenvioGetVisualization() {
		Texto text1 = new Texto("First name", "First content");
		Texto text2 = new Texto("Second name", "second content");
		Mensaje msg1 = new Mensaje(text1);
		Mensaje msg2 = new Mensaje(text2);
		Reenvio header = new Reenvio(msg2, msg1);

		String response = msg2.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ msg1.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";

		assertEquals(response, header.obtenerVisualizacion());

	}

	@Test
	public void TestCabeceraGetSize() {
		Texto text1 = new Texto("First name", "First content");
		Texto text2 = new Texto("Second name", "second content");
		Mensaje msg1 = new Mensaje(text1);
		Mensaje msg2 = new Mensaje(text2);
		Reenvio header = new Reenvio(msg2, msg1);

		int response = msg1.obtenerTamaño() + msg2.obtenerTamaño();

		assertEquals(response, header.obtenerTamaño());
	}

}
