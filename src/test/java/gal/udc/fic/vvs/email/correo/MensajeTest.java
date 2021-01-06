package gal.udc.fic.vvs.email.correo;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	@Test
	public void TestContentInMensasjeIsText() {

		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		// assertEquals(msg.)

	}

}
