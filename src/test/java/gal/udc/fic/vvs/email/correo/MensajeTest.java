package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	@Test
	public void TestContentInMensasjeIsText() {

		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		// assertEquals(msg.)

	}

	@Test
	public void TestMensajeLeidoStateIsEditable() {

		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		msg.establecerLeido(true);
		assertEquals(0, msg.obtenerNoLeidos());
		msg.establecerLeido(false);
		assertEquals(1, msg.obtenerNoLeidos());

	}
}
