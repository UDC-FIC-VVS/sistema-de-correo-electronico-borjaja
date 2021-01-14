package gal.udc.fic.vvs.email.correo;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;

import gal.udc.fic.vvs.email.generators.MensajeGenerator;

@RunWith(JUnitQuickcheck.class)
public class ReenvioTest {

	@Property
	public void TestReenvioGetVisualization(@From(MensajeGenerator.class) MensajeAbstracto msg1,
			@From(MensajeGenerator.class) Correo msg2) {
		Reenvio header = new Reenvio(msg1, msg2);

		String response = msg1.obtenerVisualizacion() + "\n\n---- Correo reenviado ----\n\n"
				+ msg2.obtenerVisualizacion() + "\n---- Fin correo reenviado ----";

		assertEquals(response, header.obtenerVisualizacion());

	}

	@Property
	public void TestCabeceraGetSize(@From(MensajeGenerator.class) MensajeAbstracto msg1,
			@From(MensajeGenerator.class) Correo msg2) {
		Reenvio header = new Reenvio(msg1, msg2);

		int response = msg1.obtenerTamaño() + msg2.obtenerTamaño();

		assertEquals(response, header.obtenerTamaño());
	}

}
