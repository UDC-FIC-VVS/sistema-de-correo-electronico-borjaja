package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.MensajeAbstracto;

public class MensajeAbstractoGenerator extends Generator<MensajeAbstracto> {

	MensajeGenerator mensajeGenerator = new MensajeGenerator();
	DecoradorMensajeGenerator decoradorMensajeGenerator = new DecoradorMensajeGenerator();

	public MensajeAbstractoGenerator() {
		super(MensajeAbstracto.class);
	}

	@Override
	public MensajeAbstracto generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		switch (sourceOfRandomness.nextInt() % 2) {
		case 0:
			return mensajeGenerator.generate(sourceOfRandomness, generationStatus);

		case 1:
			return decoradorMensajeGenerator.generate(sourceOfRandomness, generationStatus);

		default:
			return mensajeGenerator.generate(sourceOfRandomness, generationStatus);

		}
	}
}