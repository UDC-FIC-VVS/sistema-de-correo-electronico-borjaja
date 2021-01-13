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

	@Property
	public void TestMymeTypeImagen(@From(ImagenGenerator.class) Imagen image) {
		assertEquals(IMAGE_MIME_TYPE, image.obtenerMimeType());
	}

	@Property
	public void TestGetName(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(name, image.obtenerNombre());
	}

	@Property
	public void TestGetContent(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(content, image.obtenerContenido());
	}

	@Property
	public void TestGetSize(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		assertEquals(content.length(), image.obtenerTamaño());
	}

	@Property
	public void TestPreview(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Imagen image = new Imagen(name, content);
		String imageTest = name + "(" + content.length() + " bytes, " + IMAGE_MIME_TYPE + ")";
		assertEquals(imageTest, image.obtenerPreVisualizacion());

	}
}
