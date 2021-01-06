package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

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

	@Test
	public void TestMensajeGetSize() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		assertEquals(text.obtenerTamaño(), msg.obtenerTamaño());
	}

	@Test
	public void TestMensajeIconNotReaded() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		msg.establecerLeido(false);
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, msg.obtenerIcono());
	}

	@Test
	public void TestMensajeIconReaded() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		msg.establecerLeido(true);
		assertEquals(Correo.ICONO_MENSAJE, msg.obtenerIcono());
	}

	@Test
	public void TestMensajeGetPreview() {
		String content = "Text content";
		Texto text = new Texto("Text name", content);
		Mensaje msg = new Mensaje(text);
		String preview = content.substring(0, Math.min(content.length(), 32)) + "...";
		assertEquals(preview, msg.obtenerPreVisualizacion());
	}

	@Test
	public void TestMensajeSearchFound() {
		String content = "Text content";
		Texto text = new Texto("Text name", content);
		Mensaje msg = new Mensaje(text);
		Vector<Correo> resultado = new Vector<Correo>();
		resultado.add(msg);
		assertEquals(resultado, msg.buscar(content));
	}

	@Test
	public void TestMensajeSearchNotFound() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Vector<Correo> resultado = new Vector<Correo>();
		assertEquals(resultado, msg.buscar("another content"));
	}

}
