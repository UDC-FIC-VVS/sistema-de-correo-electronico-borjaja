package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Audio;

public class AudioGenerator extends Generator<Audio> {

	StringGenerator stringGenerator = new StringGenerator();

	public AudioGenerator() {
		super(Audio.class);
	}

	@Override
	public Audio generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		String s1 = stringGenerator.generate(sourceOfRandomness, generationStatus);
		String s2 = stringGenerator.generate(sourceOfRandomness, generationStatus);

		return new Audio(s1, s2);
	}
}