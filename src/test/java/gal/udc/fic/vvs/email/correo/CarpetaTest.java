package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {

	@Test
	public void TestCarpetaAddCorreo() throws OperacionInvalida {
		Vector<Mensaje> vector = new Vector<Mensaje>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);
		vector.add(msg2);
		vector.add(msg3);

		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(msg1, folder.obtenerHijo(0));
		assertEquals(msg2, folder.obtenerHijo(1));
		assertEquals(msg3, folder.obtenerHijo(2));

		assertEquals(vector, folder.explorar());

	}

	@Test
	public void TestCarpetaAddCorreoInOtherFolder() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));

		Carpeta folder1 = new Carpeta("Folder name 1");
		Carpeta folder2 = new Carpeta("Folder name 2");
		folder1.añadir(msg1);
		folder2.añadir(msg1);

		assertEquals(msg1, folder2.obtenerHijo(0));
		assertEquals(0, folder1.explorar().size());

	}

	@Test
	public void TestCarpetaEliminar() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		folder.eliminar(msg2);

		for (Object obj : folder.explorar()) {
			assertNotEquals(obj, msg2);
		}

	}

	@Test
	public void TestCarpetaEliminarNotExisting() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 1", "Content text 1"));

		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg2);
		folder.eliminar(msg1);

		assertEquals(1, folder.explorar().size());

	}

	@Test
	public void TestCarpetaGetIcon() {
		assertEquals(Correo.ICONO_CARPETA, new Carpeta("Folder name").obtenerIcono());

	}

}
