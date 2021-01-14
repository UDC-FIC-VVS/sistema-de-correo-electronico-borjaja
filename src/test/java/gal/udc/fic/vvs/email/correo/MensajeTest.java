package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class MensajeTest {

	@Test
	public void TestMensajeLeidoStateIsEditableTrue() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		adjunto.establecerLeido(true);
		assertEquals(0, adjunto.obtenerNoLeidos());

	}

	@Test
	public void TestMensajeLeidoStateIsEditableFalse() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		adjunto.establecerLeido(false);
		assertEquals(1, adjunto.obtenerNoLeidos());

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
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		adjunto.establecerLeido(false);
		assertEquals(Correo.ICONO_NUEVO_MENSAJE, adjunto.obtenerIcono());
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
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		String preview = content.substring(0, Math.min(content.length(), 32)) + "...";
		assertEquals(preview, adjunto.obtenerPreVisualizacion());
	}

	@Test
	public void TestMensajeSearchFound() {
		String content = "Text content";
		Texto text = new Texto("Text name", content);
		Mensaje msg = new Mensaje(text);
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		Vector<Correo> resultado = new Vector<Correo>();
		resultado.add(adjunto);
		assertEquals(resultado, adjunto.buscar(content));
	}

	@Test
	public void TestMensajeSearchNotFound() {
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto adjunto = new Adjunto(msg, new Texto("name adj", "content adj"));
		Vector<Correo> resultado = new Vector<Correo>();
		assertEquals(resultado, adjunto.buscar("another content"));
	}

}
