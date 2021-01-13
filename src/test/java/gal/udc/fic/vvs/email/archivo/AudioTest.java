package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.generators.AudioGenerator;

@RunWith(JUnitQuickcheck.class)
public class AudioTest {
	private static final String AUDIO_MIME_TYPE = "audio/ogg";

	@Property
	public void TestMymeTypeAudio(@From(AudioGenerator.class) Audio audio) {
		assertEquals(AUDIO_MIME_TYPE, audio.obtenerMimeType());
	}

	@Property
	public void TestGetName(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Audio audio = new Audio(name, content);
		assertEquals(name, audio.obtenerNombre());
	}

	@Property
	public void TestGetContent(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Audio audio = new Audio(name, content);
		assertEquals(content, audio.obtenerContenido());
	}

	@Property
	public void TestGetSize(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Audio audio = new Audio(name, content);
		assertEquals(content.length(), audio.obtenerTamaño());
	}

	@Property
	public void TestPreview(@From(StringGenerator.class) String name, @From(StringGenerator.class) String content) {
		Audio audio = new Audio(name, content);
		String audioTest = name + "(" + content.length() + " bytes, " + AUDIO_MIME_TYPE + ")";
		assertEquals(audioTest, audio.obtenerPreVisualizacion());
	}
}
