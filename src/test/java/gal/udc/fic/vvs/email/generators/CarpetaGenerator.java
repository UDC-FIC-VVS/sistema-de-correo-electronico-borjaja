package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.Carpeta;

public class CarpetaGenerator extends Generator<Carpeta> {

	StringGenerator stringGenerator = new StringGenerator();

	public CarpetaGenerator() {
		super(Carpeta.class);
	}

	@Override
	public Carpeta generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		String s1 = stringGenerator.generate(sourceOfRandomness, generationStatus);

		return new Carpeta(s1);
	}
}