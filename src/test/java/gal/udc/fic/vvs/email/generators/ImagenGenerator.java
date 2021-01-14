package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Imagen;

public class ImagenGenerator extends Generator<Imagen> {

	StringGenerator stringGenerator = new StringGenerator();

	public ImagenGenerator() {
		super(Imagen.class);
	}

	@Override
	public Imagen generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		String s1 = stringGenerator.generate(sourceOfRandomness, generationStatus);
		String s2 = stringGenerator.generate(sourceOfRandomness, generationStatus);

		return new Imagen(s1, s2);
	}
}