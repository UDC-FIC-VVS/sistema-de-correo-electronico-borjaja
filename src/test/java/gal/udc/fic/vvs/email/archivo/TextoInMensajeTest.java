package gal.udc.fic.vvs.email.archivo;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Field;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.correo.Mensaje;
import gal.udc.fic.vvs.email.generators.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class TextoInMensajeTest {
	private static final String TEXT_MIME_TYPE = "text/plain";

	/**
	 * Comprobación del método de que el contenido del mensaje es un texto usando
	 * introspección <br/>
	 * Nivel de prueba: Unidad <br/>
	 * Categoría de prueba: Prueba funcional dinámica de caja negra positiva. <br/>
	 * Mecanismo de selección de datos: Se genera automaticamente Mensajes y se
	 * cambia el acceso a su varible para determinar si su mimetype es correcto
	 * <br/>
	 */
	@Property
	public void TestContentInMensasjeIsText(@From(MensajeGenerator.class) Mensaje msg)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = Mensaje.class.getDeclaredField("_contenido");
		field.setAccessible(true);
		Texto archivo = (Texto) field.get(msg);
		assertEquals("text/plain", archivo.obtenerMimeType());
	}
}
