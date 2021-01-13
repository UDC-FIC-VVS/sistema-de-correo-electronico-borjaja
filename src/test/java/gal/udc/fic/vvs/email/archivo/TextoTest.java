package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextoTest {

	private static final String TEXT_MIME_TYPE = "text/plain";

	@Test
	public void TestMymeTypeTexto() {
		Texto texto = new Texto("Text name", "Text content");
		assertEquals(TEXT_MIME_TYPE, texto.obtenerMimeType());
	}

	@Test
	public void TestGetName() {
		String textName = "text_test_get_name";

		Texto text = new Texto(textName, "Text content");

		assertEquals(textName, text.obtenerNombre());
	}

	@Test
	public void TestGetContent() {
		String textContent = "text_test_get_content";

		Texto text = new Texto("Text content", textContent);

		assertEquals(textContent, text.obtenerContenido());
	}

	@Test
	public void TestGetSize() {
		String textContent = "text_test_get_content";

		Texto text = new Texto("Text content", textContent);

		assertEquals(textContent.length(), text.obtenerTamaño());
	}

	@Test
	public void TestPreview() {
		String textName = "text_test_get_name";
		String textContent = "text_test_get_content";

		Texto text = new Texto(textName, textContent);
		String textTest = textName + "(" + textContent.length() + " bytes, " + TEXT_MIME_TYPE + ")";

		assertEquals(textTest, text.obtenerPreVisualizacion());
	}
}
