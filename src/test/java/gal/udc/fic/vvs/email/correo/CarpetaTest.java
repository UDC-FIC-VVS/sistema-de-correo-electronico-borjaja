package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Test;

import gal.udc.fic.vvs.email.archivo.Texto;

public class CarpetaTest {

	@Test
	public void TestCarpetaAddCorreoOne() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg1);

		assertEquals(msg1, folder.obtenerHijo(0));
	}

	@Test
	public void TestCarpetaAddCorreoThree() throws OperacionInvalida {
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

		assertEquals(false, folder.explorar().contains(msg2));
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
		Carpeta folder = new Carpeta("Folder name");
		assertEquals(Correo.ICONO_CARPETA, folder.obtenerIcono());
	}

	@Test
	public void TestCarpetaVisualization() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		String name = "Folder name";
		Carpeta folder = new Carpeta(name);
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);
		assertEquals(name + " (3)", folder.obtenerVisualizacion());
	}

	@Test
	public void TestCarpetaVisualizationEmpty() throws OperacionInvalida {
		String name = "Folder name";
		Carpeta folder = new Carpeta("Folder name");

		assertEquals(name, folder.obtenerPreVisualizacion());
	}

	@Test
	public void TestCarpetaSize() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);
		int result = msg1.obtenerTamaño() + msg2.obtenerTamaño() + msg3.obtenerTamaño();
		assertEquals(result, folder.obtenerTamaño());
	}

	@Test
	public void TestCarpetaSetReaded() throws OperacionInvalida {
		Mensaje msg1 = new Mensaje(new Texto("Name text 1", "Content text 1"));
		Mensaje msg2 = new Mensaje(new Texto("Name text 2", "Content text 2"));
		Mensaje msg3 = new Mensaje(new Texto("Name text 3", "Content text 3"));

		Carpeta folder = new Carpeta("Folder name");
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

		Carpeta folder = new Carpeta("Folder name");
		Carpeta root = new Carpeta("Root Folder name");
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

		Carpeta folder = new Carpeta("Folder name");
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

		Carpeta folder = new Carpeta("Folder name");
		folder.añadir(msg1);
		folder.añadir(msg2);
		folder.añadir(msg3);

		assertEquals(folder.buscar("Content"), vector);
	}

}
