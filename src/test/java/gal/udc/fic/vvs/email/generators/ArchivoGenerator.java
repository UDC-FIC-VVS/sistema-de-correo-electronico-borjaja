package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Archivo;

public class ArchivoGenerator extends Generator<Archivo> {

	ImagenGenerator imagenGenerator = new ImagenGenerator();
	TextoGenerator textoGenerator = new TextoGenerator();
	AudioGenerator audioGenerator = new AudioGenerator();

	public ArchivoGenerator() {
		super(Archivo.class);
	}

	@Override
	public Archivo generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {

		switch (sourceOfRandomness.nextInt() % 3) {
		case 0:
			return imagenGenerator.generate(sourceOfRandomness, generationStatus);

		case 1:
			return textoGenerator.generate(sourceOfRandomness, generationStatus);

		case 2:
			return audioGenerator.generate(sourceOfRandomness, generationStatus);

		default:
			return textoGenerator.generate(sourceOfRandomness, generationStatus);

		}
	}
}