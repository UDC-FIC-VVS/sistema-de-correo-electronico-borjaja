package gal.udc.fic.vvs.email.generators;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

import gal.udc.fic.vvs.email.correo.Carpeta;
import gal.udc.fic.vvs.email.correo.CarpetaLimitada;

public class CarpetaLimitadaGenerator extends Generator<CarpetaLimitada> {

	CarpetaGenerator carpetaGenerator = new CarpetaGenerator();

	public CarpetaLimitadaGenerator() {
		super(CarpetaLimitada.class);
	}

	@Override
	public CarpetaLimitada generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
		Carpeta carpeta = carpetaGenerator.generate(sourceOfRandomness, generationStatus);

		return new CarpetaLimitada(carpeta, sourceOfRandomness.nextInt());
	}
}