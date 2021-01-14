package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.CorreoAbstracto;

public class CorreoAbstractoGenerator extends Generator<CorreoAbstracto> {

	MensajeAbstractoGenerator mensajeAbstractoGenerator = new MensajeAbstractoGenerator();
	CarpetaLimitadaGenerator carpetaLimitadaGenerator = new CarpetaLimitadaGenerator();
	CarpetaGenerator carpetaGenerator = new CarpetaGenerator();

	public CorreoAbstractoGenerator() {
		super(CorreoAbstracto.class);
	}

	@Override
	public CorreoAbstracto generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {

		switch (sourceOfRandomness.nextInt() % 3) {
		case 0:
			return mensajeAbstractoGenerator.generate(sourceOfRandomness, generationStatus);

		case 1:
			return carpetaLimitadaGenerator.generate(sourceOfRandomness, generationStatus);

		case 2:
			return carpetaGenerator.generate(sourceOfRandomness, generationStatus);

		default:
			return mensajeAbstractoGenerator.generate(sourceOfRandomness, generationStatus);

		}
	}
}