package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Texto;
import gal.udc.fic.vvs.email.correo.Mensaje;

public class MensajeGenerator extends Generator<Mensaje> {

	TextoGenerator textoGenerator = new TextoGenerator();

	public MensajeGenerator() {
		super(Mensaje.class);
	}

	@Override
	public Mensaje generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		Texto text = textoGenerator.generate(sourceOfRandomness, generationStatus);

		return new Mensaje(text);
	}
}