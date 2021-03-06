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

	/**
	 * Comprobación del método obtenerMimeType() <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente la clase a probar
	 * y se comprueba que el valor estico que tiene que devolver es el correcto.
	 * <br/>
	 */
	@Property
	public void TestMymeTypeAudio(@From(AudioGenerator.class) Audio audio) {
		assertEquals(AUDIO_MIME_TYPE, audio.obtenerMimeType());
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
		Audio audio = new Audio(name, content);
		assertEquals(name, audio.obtenerNombre());
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
		Audio audio = new Audio(name, content);
		assertEquals(content, audio.obtenerContenido());
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
		Audio audio = new Audio(name, content);
		assertEquals(content.length(), audio.obtenerTamaño());
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
		Audio audio = new Audio(name, content);
		String audioTest = name + "(" + content.length() + " bytes, " + AUDIO_MIME_TYPE + ")";
		assertEquals(audioTest, audio.obtenerPreVisualizacion());
	}
}
