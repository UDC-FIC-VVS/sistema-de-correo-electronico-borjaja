package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.archivo.Archivo;
import gal.udc.fic.vvs.email.correo.Adjunto;
import gal.udc.fic.vvs.email.correo.MensajeAbstracto;

public class AdjuntoGenerator extends Generator<Adjunto> {

	MensajeGenerator mensajeAbstractoGenerator = new MensajeGenerator();
	ArchivoGenerator archivoGenerator = new ArchivoGenerator();

	public AdjuntoGenerator() {
		super(Adjunto.class);
	}

	@Override
	public Adjunto generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		MensajeAbstracto ma = mensajeAbstractoGenerator.generate(sourceOfRandomness, generationStatus);
		Archivo a = archivoGenerator.generate(sourceOfRandomness, generationStatus);
		return new Adjunto(ma, a);
	}
}