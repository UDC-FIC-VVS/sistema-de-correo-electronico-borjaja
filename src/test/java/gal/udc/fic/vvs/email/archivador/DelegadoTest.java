package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class DelegadoTest {
	@Test
	public void TestDelegadoHasNoDelegado() {
		Archivador archivador = new Delegado(new ArchivadorSimple("gmail", 10));
		assertEquals(null, archivador.obtenerDelegado());
	}

	@Test
	public void TestDelegadoCorrectName() {
		String name = "gmail";
		Archivador archivador = new Delegado(new ArchivadorSimple(name, 10));
		assertEquals(name, archivador.obtenerNombre());
	}

	@Test
	public void TestDelegadoAddDelegado() {
		Archivador gmail = new Delegado(new ArchivadorSimple("gmail", 10));
		Archivador outlook = new ArchivadorSimple("outlook", 10);
		gmail.establecerDelegado(outlook);
		assertEquals(gmail.obtenerDelegado(), outlook);
	}

	@Test
	public void TestDelegadoAddCorreoFirst() {

		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);
		int size = mensaje.obtenerTamaño() + 1;
		Archivador gmail = new Delegado(new ArchivadorSimple("gmail", size));
		Archivador outlook = new ArchivadorSimple("outlook", mensaje.obtenerTamaño());
		gmail.establecerDelegado(outlook);
		boolean added = gmail.almacenarCorreo(mensaje);

		assertEquals(true, added);
		assertEquals(outlook.obtenerEspacioTotal(), outlook.obtenerEspacioDisponible());
	}

	@Test
	public void TestDelegadoAddCorreoSecond() {

		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);
		int size = mensaje.obtenerTamaño() + 1;
		Archivador gmail = new Delegado(new ArchivadorSimple("gmail", mensaje.obtenerTamaño()));
		Archivador outlook = new ArchivadorSimple("outlook", size);
		gmail.establecerDelegado(outlook);
		boolean added = gmail.almacenarCorreo(mensaje);

		assertEquals(true, added);
		assertEquals(gmail.obtenerEspacioTotal(), gmail.obtenerEspacioDisponible());
	}

	@Test
	public void TestDelegadoAddCorreoNotSpace() {

		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);
		int size = mensaje.obtenerTamaño() - 1;
		Archivador gmail = new Delegado(new ArchivadorSimple("gmail", size));
		Archivador outlook = new ArchivadorSimple("outlook", size);
		gmail.establecerDelegado(outlook);
		boolean added = gmail.almacenarCorreo(mensaje);

		assertEquals(false, added);
		assertEquals(gmail.obtenerEspacioTotal(), gmail.obtenerEspacioDisponible());
		assertEquals(outlook.obtenerEspacioTotal(), outlook.obtenerEspacioDisponible());
	}

	@Test
	public void testDelegadoLoop() {
		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);
		int size = mensaje.obtenerTamaño() - 1;

		Archivador gmail = new Delegado(new ArchivadorSimple("gmail", size));
		Archivador outlook = new Delegado(new ArchivadorSimple("outlook", size));
		gmail.establecerDelegado(outlook);
		outlook.establecerDelegado(gmail);

		boolean added = gmail.almacenarCorreo(mensaje);

		assertEquals(false, added);
	}

}
