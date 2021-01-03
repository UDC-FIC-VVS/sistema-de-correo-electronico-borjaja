package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArchivoTest {
	private static final String AUDIO_MIME_TYPE = "audio/ogg";
	private static final String IMAGE_MIME_TYPE = "image/png";
	private static final String TEXT_MIME_TYPE = "text/plain";

	@Test
	public void TestMymeTypeAudio() {
		Audio audio = new Audio("Audio name", "Audio content");
		assertEquals(AUDIO_MIME_TYPE, audio.obtenerMimeType());
	}

	@Test
	public void TestMymeTypeImagen() {
		Imagen image = new Imagen("Image name", "Image content");
		assertEquals(IMAGE_MIME_TYPE, image.obtenerMimeType());
	}

	@Test
	public void TestMymeTypeTexto() {
		Texto texto = new Texto("Text name", "Text content");
		assertEquals(TEXT_MIME_TYPE, texto.obtenerMimeType());
	}

	@Test
	public void TestGetName() {
		String audioName = "audio_test_get_name";
		String imageName = "image_test_get_name";
		String textName = "text_test_get_name";

		Audio audio = new Audio(audioName, "Audio content");
		Imagen image = new Imagen(imageName, "Image content");
		Texto text = new Texto(textName, "Text content");

		assertEquals(audioName, audio.obtenerNombre());
		assertEquals(imageName, image.obtenerNombre());
		assertEquals(textName, text.obtenerNombre());
	}

	@Test
	public void TestGetContent() {
		String audioContent = "audio_test_get_content";
		String imageContent = "image_test_get_content";
		String textContent = "text_test_get_content";

		Audio audio = new Audio("Audio name", audioContent);
		Imagen image = new Imagen("Image content", imageContent);
		Texto text = new Texto("Text content", textContent);

		assertEquals(audioContent, audio.obtenerContenido());
		assertEquals(imageContent, image.obtenerContenido());
		assertEquals(textContent, text.obtenerContenido());
	}

	@Test
	public void TestGetSize() {
		String audioContent = "audio_test_get_content";
		String imageContent = "image_test_get_content";
		String textContent = "text_test_get_content";

		Audio audio = new Audio("Audio name", audioContent);
		Imagen image = new Imagen("Image content", imageContent);
		Texto text = new Texto("Text content", textContent);

		assertEquals(audioContent.length(), audio.obtenerTamaño());
		assertEquals(imageContent.length(), image.obtenerTamaño());
		assertEquals(textContent.length(), text.obtenerTamaño());
	}

	@Test
	public void TestPreview() {
		String audioName = "audio_test_get_name";
		String imageName = "image_test_get_name";
		String textName = "text_test_get_name";

		String audioContent = "audio_test_get_content";
		String imageContent = "image_test_get_content";
		String textContent = "text_test_get_content";

		Audio audio = new Audio(audioName, audioContent);
		Imagen image = new Imagen(imageName, imageContent);
		Texto text = new Texto(textName, textContent);

		String audioTest = audioName + "(" + audioContent.length() + " bytes, " + AUDIO_MIME_TYPE + ")";
		String imageTest = imageName + "(" + audioContent.length() + " bytes, " + IMAGE_MIME_TYPE + ")";
		String textTest = textName + "(" + textContent.length() + " bytes, " + TEXT_MIME_TYPE + ")";

		assertEquals(audioTest, audio.obtenerPreVisualizacion());
		assertEquals(imageTest, image.obtenerPreVisualizacion());
		assertEquals(textTest, text.obtenerPreVisualizacion());
	}
}
