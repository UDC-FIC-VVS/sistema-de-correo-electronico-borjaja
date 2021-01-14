package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CabeceraTest {

	@Test
	public void TestCabeceraGetVisualization() {
		String key = "Subget";
		String value = "Hi";
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Cabecera header = new Cabecera(msg, key, value);

		String response = key + ": " + value + "\n" + msg.obtenerVisualizacion();

		assertEquals(response, header.obtenerVisualizacion());

	}

	@Test
	public void TestCabeceraGetSize() {
		String key = "Subget";
		String value = "Hi";
		Texto text = new Texto("Text name", "Text content");
		Mensaje msg = new Mensaje(text);
		Cabecera header = new Cabecera(msg, key, value);

		int response = key.length() + value.length() + msg.obtenerTamaño();

		assertEquals(response, header.obtenerTamaño());
	}

}
