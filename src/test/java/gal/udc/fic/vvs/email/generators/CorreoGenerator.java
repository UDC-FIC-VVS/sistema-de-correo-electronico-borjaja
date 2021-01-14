package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.Correo;

public class CorreoGenerator extends Generator<Correo> {

	CorreoAbstractoGenerator correoAbstractoGenerator = new CorreoAbstractoGenerator();

	public CorreoGenerator() {
		super(Correo.class);
	}

	@Override
	public Correo generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {

		return correoAbstractoGenerator.generate(sourceOfRandomness, generationStatus);
	}
}