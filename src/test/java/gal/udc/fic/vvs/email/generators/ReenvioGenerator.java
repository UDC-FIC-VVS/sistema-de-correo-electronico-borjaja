package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.Correo;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;
import gal.udc.fic.vvs.email.correo.Reenvio;

public class ReenvioGenerator extends Generator<Reenvio> {

	MensajeAbstractoGenerator mensajeAbstractoGenerator = new MensajeAbstractoGenerator();
	CorreoGenerator correoGenerator = new CorreoGenerator();

	public ReenvioGenerator() {
		super(Reenvio.class);
	}

	@Override
	public Reenvio generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		MensajeAbstracto ma = mensajeAbstractoGenerator.generate(sourceOfRandomness, generationStatus);
		Correo c = correoGenerator.generate(sourceOfRandomness, generationStatus);
		return new Reenvio(ma, c);
	}
}