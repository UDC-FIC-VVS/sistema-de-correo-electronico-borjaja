package gal.udc.fic.vvs.email.archivador;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class ArchivadorSimpleTest {
	@Test
	public void TestArchivadorSimpleHasNoDelegado() {
		Archivador archivador = new ArchivadorSimple("gmail", 10);
		assertEquals(null, archivador.obtenerDelegado());
	}

	@Test
	public void TestArchivadorSimpleCorrectName() {
		String name = "gmail";
		Archivador archivador = new ArchivadorSimple(name, 10);
		assertEquals(name, archivador.obtenerNombre());
	}

	@Test
	public void TestArchivadorSimpleAddCorreo() {

		Texto texto = new Texto("name", "content");
		Correo mensaje = new Mensaje(texto);

		Archivador archivador = new ArchivadorSimple("gmail", mensaje.obtenerTamaño());
		boolean added = archivador.almacenarCorreo(mensaje);

		assertEquals(true, added);
	}

	@Test
	public void TestArchivadorSimpleAddCorreoFull() {

		Texto texto = new Texto("name", "content");
		Texto texto2 = new Texto("name2", "content2");
		Correo mensaje = new Mensaje(texto);
		Correo mensaje2 = new Mensaje(texto2);
		int size = mensaje.obtenerTamaño() + 1;
		Archivador archivador = new ArchivadorSimple("gmail", size);
		boolean added = archivador.almacenarCorreo(mensaje);
		boolean added2 = archivador.almacenarCorreo(mensaje2);

		assertEquals(true, added);
		assertEquals(false, added2);
		assertEquals(archivador.obtenerEspacioTotal() - size, archivador.obtenerEspacioDisponible());
	}

}
