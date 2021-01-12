package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class LogTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));

	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);

	}

	@Test
	public void out() {
		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);
		int size = mensaje.obtenerTamaño() + 1;
		Archivador gmail = new Log(new Delegado(new ArchivadorSimple("gmail", size)));
		Archivador outlook = new ArchivadorSimple("outlook", mensaje.obtenerTamaño());
		gmail.establecerDelegado(outlook);
		gmail.almacenarCorreo(mensaje);

		assertEquals("Mensaxe de log".trim(), outContent.toString().trim());

	}

}
