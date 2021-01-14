package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.generator.java.lang.StringGenerator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.Cabecera;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;

public class CabeceraGenerator extends Generator<Cabecera> {

	MensajeAbstractoGenerator mensajeAbstractoGenerator = new MensajeAbstractoGenerator();
	StringGenerator stringGenerator = new StringGenerator();

	public CabeceraGenerator() {
		super(Cabecera.class);
	}

	@Override
	public Cabecera generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		MensajeAbstracto ma = mensajeAbstractoGenerator.generate(sourceOfRandomness, generationStatus);
		String s1 = stringGenerator.generate(sourceOfRandomness, generationStatus);
		String s2 = stringGenerator.generate(sourceOfRandomness, generationStatus);
		return new Cabecera(null, s1, s2);
	}
}