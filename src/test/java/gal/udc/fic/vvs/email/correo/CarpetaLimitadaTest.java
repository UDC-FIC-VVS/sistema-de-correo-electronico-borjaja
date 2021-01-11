package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaLimitadaTest {

	@Test
	public void TestCarpetaLimitadaAddCorreo() throws OperacionInvalida {
		Vector<Mensaje> vector = new Vector<Mensaje>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);
		vector.add(msg2);
		vector.add(msg3);

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(msg1, folder.obtenerHijo(0));
		assertEquals(msg2, folder.obtenerHijo(1));
		assertEquals(msg3, folder.obtenerHijo(2));

		assertEquals(vector, folder.explorar());

	}

	@Test
	public void TestCarpetaLimitadaAddCorreoInOtherFolder() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));

		CarpetaLimitada folder1 = new CarpetaLimitada(new Carpeta("Folder name 1"), 100);
		CarpetaLimitada folder2 = new CarpetaLimitada(new Carpeta("Folder name 2"), 100);
		;
		folder1.añadir(msg1);
		folder2.añadir(msg1);

		assertEquals(msg1, folder2.obtenerHijo(0));
		assertEquals(0, folder1.explorar().size());

	}

	@Test
	public void TestCarpetaLimitadaEliminar() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		folder.eliminar(msg2);

		for (Object obj : folder.explorar()) {
			assertNotEquals(obj, msg2);
		}

	}

	@Test
	public void TestCarpetaLimitadaEliminarNotExisting() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 1", "Content text 1"));

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg2);
		folder.eliminar(msg1);

		assertEquals(1, folder.explorar().size());

	}

	@Test
	public void TestCarpetaLimitadaGetIcon() {
		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		assertEquals(Correo.ICONO_CARPETA, folder.obtenerIcono());

	}

	@Test
	public void TestCarpetaLimitadaVisualization() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		String name = "Folder name";
		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta(name), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);
		assertEquals(name + " (3)", folder.obtenerVisualizacion());

	}

	@Test
	public void TestCarpetaLimitadaVisualizationEmpty() throws OperacionInvalida {
		String name = "Folder name";
		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);

		assertEquals(name, folder.obtenerPreVisualizacion());

	}

	@Test
	public void TestCarpetaLimitadaSize() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);
		int result = msg1.obtenerTamaño() + msg2.obtenerTamaño() + msg3.obtenerTamaño();
		assertEquals(result, folder.obtenerTamaño());

	}

	@Test
	public void TestCarpetaLimitadaSetReaded() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);
		folder.establecerLeido(true);

		assertEquals(0, folder.obtenerNoLeidos());

	}

	@Test
	public void TestCarpetaMostrarRuta() throws OperacionInvalida {
		Vector<MensajeAbstracto> vector = new Vector<MensajeAbstracto>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Adjunto adjunto = new Adjunto(msg2, new Texto("name adj", "content adj"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);
		vector.add(adjunto);
		vector.add(msg3);

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		CarpetaLimitada root = new CarpetaLimitada(new Carpeta("Root Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(adjunto);
		folder.añadir(msg3);
		folder.establecerPadre(root);

		String result = folder.obtenerPadre().obtenerPreVisualizacion() + " > " + folder.obtenerPreVisualizacion();

		assertEquals(result, folder.obtenerRuta());
	}

	@Test
	public void TestCarpetaBuscar() throws OperacionInvalida {
		Vector<Mensaje> vector = new Vector<Mensaje>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);
		vector.add(msg2);
		vector.add(msg3);

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 100);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(vector, folder.buscar("text"));

	}

	@Test
	public void TestCarpetaLimitadaBuscarAll() throws OperacionInvalida {
		Vector<Mensaje> vector = new Vector<Mensaje>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);
		vector.add(msg2);
		vector.add(msg3);

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 3);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(folder.buscar("Content"), vector);

	}

	@Test
	public void TestCarpetaLimitadaBuscarTwo() throws OperacionInvalida {
		Vector<Mensaje> vector = new Vector<Mensaje>();
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));
		vector.add(msg1);

		CarpetaLimitada folder = new CarpetaLimitada(new Carpeta("Folder name"), 1);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(folder.buscar("Content"), vector);

	}

}
