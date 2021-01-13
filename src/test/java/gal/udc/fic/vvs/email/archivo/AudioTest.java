package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AudioTest {
	private static final String AUDIO_MIME_TYPE = "audio/ogg";

	@Test
	public void TestMymeTypeAudio() {
		Audio audio = new Audio("Audio name", "Audio content");
		assertEquals(AUDIO_MIME_TYPE, audio.obtenerMimeType());
	}

	@Test
	public void TestGetName() {
		String audioName = "audio_test_get_name";

		Audio audio = new Audio(audioName, "Audio content");

		assertEquals(audioName, audio.obtenerNombre());
	}

	@Test
	public void TestGetContent() {
		String audioContent = "audio_test_get_content";

		Audio audio = new Audio("Audio name", audioContent);

		assertEquals(audioContent, audio.obtenerContenido());
	}

	@Test
	public void TestGetSize() {
		String audioContent = "audio_test_get_content";

		Audio audio = new Audio("Audio name", audioContent);

		assertEquals(audioContent.length(), audio.obtenerTamaño());
	}

	@Test
	public void TestPreview() {
		String audioName = "audio_test_get_name";

		String audioContent = "audio_test_get_content";

		Audio audio = new Audio(audioName, audioContent);
		String audioTest = audioName + "(" + audioContent.length() + " bytes, " + AUDIO_MIME_TYPE + ")";

		assertEquals(audioTest, audio.obtenerPreVisualizacion());
	}
}
