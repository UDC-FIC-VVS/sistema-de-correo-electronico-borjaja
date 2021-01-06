package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.archivo.Audio;
import gal.udc.fic.vvs.email.archivo.Imagen;
import gal.udc.fic.vvs.email.archivo.Texto;

public class AdjuntoTest {

	@Test
	public void TestAdjuntoGetVisualizationTexto() {
		Archivo file = new Texto("nameFileTexto", "ContentFileTexto");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		String response = msg.obtenerVisualizacion() + "\n\nAdxunto: " + file.obtenerPreVisualizacion();

		assertEquals(response, attached.obtenerVisualizacion());

	}

	@Test
	public void TestAdjuntoGetVisualizationAudio() {
		Archivo file = new Audio("nameFileAudio", "ContentFileAudio");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		String response = msg.obtenerVisualizacion() + "\n\nAdxunto: " + file.obtenerPreVisualizacion();

		assertEquals(response, attached.obtenerVisualizacion());

	}

	@Test
	public void TestAdjuntoGetVisualizationImagen() {
		Archivo file = new Imagen("nameFileImagen", "ContentFileImagen");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		String response = msg.obtenerVisualizacion() + "\n\nAdxunto: " + file.obtenerPreVisualizacion();

		assertEquals(response, attached.obtenerVisualizacion());

	}

	@Test
	public void TestAdjuntoGetSizeTexto() {
		Archivo file = new Texto("nameFileTexto", "ContentFileTexto");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		int response = file.obtenerTamaño() + msg.obtenerTamaño();

		assertEquals(response, attached.obtenerTamaño());

	}

	@Test
	public void TestAdjuntoGetSizeAudio() {
		Archivo file = new Audio("nameFileAudio", "ContentFileAudio");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		int response = file.obtenerTamaño() + msg.obtenerTamaño();

		assertEquals(response, attached.obtenerTamaño());

	}

	@Test
	public void TestAdjuntoGetSizeImagen() {
		Archivo file = new Imagen("nameFileImagen", "ContentFileImagen");
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Adjunto attached = new Adjunto(msg, file);

		int response = file.obtenerTamaño() + msg.obtenerTamaño();

		assertEquals(response, attached.obtenerTamaño());

	}

}
