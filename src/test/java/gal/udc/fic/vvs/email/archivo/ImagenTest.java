package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.generators.ImagenGenerator;

@RunWith(JUnitQuickcheck.class)
public class ImagenTest {

	private static final String IMAGE_MIME_TYPE = "image/png";

	/**
	 * Comprobación del método obtenerMimeType() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente la clase a probar
	 * y se comprueba que el valor estico que tiene que devolver es el correcto.
	 * <br/>
	 */
	@Property
	public void TestMymeTypeImagen(@From(ImagenGenerator.class) Imagen image) {
		assertEquals(IMAGE_MIME_TYPE, image.obtenerMimeType());
	}

	/**
	 * Comprobación del método obtenerNombre() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente Strings y se
	 * comprueba que devuleva el valor correcto. <br/>
	 */
	@Property
	public void TestGetName(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(name, image.obtenerNombre());
	}

	/**
	 * Comprobación del método obtenerContenido() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente Strings y se
	 * comprueba que devuleva el valor correcto. <br/>
	 */
	@Property
	public void TestGetContent(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(content, image.obtenerContenido());
	}

	/**
	 * Comprobación del método obtenerTamaño() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente Strings y se
	 * comprueba que devuleva el valor correcto. <br/>
	 */
	@Property
	public void TestGetSize(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(content.length(), image.obtenerTamaño());
	}

	/**
	 * Comprobación del método obtenerPreVisualizacion() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente Strings y se
	 * comprueba que devuleva el valor correcto. <br/>
	 */
	@Property
	public void TestPreview(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		String imageTest = name + "(" + content.length() + " bytes, " + IMAGE_MIME_TYPE + ")";
		assertEquals(imageTest, image.obtenerPreVisualizacion());

	}
}
