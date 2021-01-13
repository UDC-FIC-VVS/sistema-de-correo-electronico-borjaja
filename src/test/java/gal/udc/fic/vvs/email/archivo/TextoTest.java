package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.generators.TextoGenerator;

@RunWith(JUnitQuickcheck.class)
public class TextoTest {

	private static final String TEXT_MIME_TYPE = "text/plain";

	@Property
	public void TestMymeTypeTexto(@From(TextoGenerator.class) Texto text) {
		assertEquals(TEXT_MIME_TYPE, text.obtenerMimeType());
	}

	@Property
	public void TestGetName(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Texto text = new Texto(name, content);
		assertEquals(name, text.obtenerNombre());
	}

	@Property
	public void TestGetContent(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Texto text = new Texto(name, content);
		assertEquals(content, text.obtenerContenido());
	}

	@Property
	public void TestGetSize(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Texto text = new Texto(name, content);
		assertEquals(content.length(), text.obtenerTamaño());
	}

	@Property
	public void TestPreview(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Texto text = new Texto(name, content);
		String textTest = name + "(" + content.length() + " bytes, " + TEXT_MIME_TYPE + ")";
		assertEquals(textTest, text.obtenerPreVisualizacion());
	}
}
