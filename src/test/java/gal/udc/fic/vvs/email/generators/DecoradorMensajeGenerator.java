package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.DecoradorMensaje;

public class DecoradorMensajeGenerator extends Generator<DecoradorMensaje> {

	AdjuntoGenerator adjuntoGenerator = new AdjuntoGenerator();
	CabeceraGenerator mensajeGenerator = new CabeceraGenerator();
	ReenvioGenerator reenvioGenerator = new ReenvioGenerator();

	public DecoradorMensajeGenerator() {
		super(DecoradorMensaje.class);
	}

	@Override
	public DecoradorMensaje generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {

		switch (sourceOfRandomness.nextInt() % 3) {
		case 0:
			return adjuntoGenerator.generate(sourceOfRandomness, generationStatus);

		case 1:
			return mensajeGenerator.generate(sourceOfRandomness, generationStatus);

		case 2:
			return reenvioGenerator.generate(sourceOfRandomness, generationStatus);

		default:
			return mensajeGenerator.generate(sourceOfRandomness, generationStatus);

		}
	}
}