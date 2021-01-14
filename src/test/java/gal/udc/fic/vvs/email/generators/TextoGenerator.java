package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;

public class TextoGenerator extends Generator<Texto> {

	StringGenerator stringGenerator = new StringGenerator();

	public TextoGenerator() {
		super(Texto.class);
	}

	@Override
	public Texto generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		String s1 = stringGenerator.generate(sourceOfRandomness, generationStatus);
		String s2 = stringGenerator.generate(sourceOfRandomness, generationStatus);

		return new Texto(s1, s2);
	}
}