package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ImagenTest {

	private static final String IMAGE_MIME_TYPE = "image/png";

	@Test
	public void TestMymeTypeImagen() {
		Imagen image = new Imagen("Image name", "Image content");
		assertEquals(IMAGE_MIME_TYPE, image.obtenerMimeType());
	}

	@Test
	public void TestGetName() {
		String imageName = "image_test_get_name";

		Imagen image = new Imagen(imageName, "Image content");

		assertEquals(imageName, image.obtenerNombre());
	}

	@Test
	public void TestGetContent() {

		String imageContent = "image_test_get_content";

		Imagen image = new Imagen("Image content", imageContent);

		assertEquals(imageContent, image.obtenerContenido());
	}

	@Test
	public void TestGetSize() {
		String imageContent = "image_test_get_content";

		Imagen image = new Imagen("Image content", imageContent);

		assertEquals(imageContent.length(), image.obtenerTamaño());
	}

	@Test
	public void TestPreview() {
		String imageName = "image_test_get_name";
		String imageContent = "image_test_get_content";

		Imagen image = new Imagen(imageName, imageContent);
		String imageTest = imageName + "(" + imageContent.length() + " bytes, " + IMAGE_MIME_TYPE + ")";

		assertEquals(imageTest, image.obtenerPreVisualizacion());

	}
}
