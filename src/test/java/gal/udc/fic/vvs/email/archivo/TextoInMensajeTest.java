package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.Test;

import gal.udc.fic.vvs.email.correo.Mensaje;

public class TextoInMensajeTest {
	@Test
	public void TestContentInMensasjeIsText()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		String content = "Text content";
		Texto text = new Texto("Text name", content);
		Mensaje msg = new Mensaje(text);

		Field field = Mensaje.class.getDeclaredField("_contenido");
		field.setAccessible(true);
		Texto archivo = (Texto) field.get(msg);
		assertEquals("text/plain", archivo.obtenerMimeType());
	}
}
