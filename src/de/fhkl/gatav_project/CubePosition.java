package de.fhkl.gatav_project;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

// wird wohl eher das Spielfeld

public class CubePosition {
	// 2 Komponenten pro Ecke, variable legt dies fest
	private static final int POSITION_KOMPONENTEN_COUNTER = 2;
	//
	private static final int BYTES_PER_FLOAT = 4;
	private final FloatBuffer vertexData;

	public CubePosition() {
		// Spielfeld
		float[] feldEckpunkte = {
				// Rechteck1
				0f, 0f, // unten links
				9f, 9f, // oben rechts
				0f, 9f, // oben links

				// Dreieck2
				0f, 0f, // unten links
				9f, 0f, // unten rechts
				9f, 9f, // oben rechts

				// Mittelpunkt für die Würfel auf dem Feld
				// Obere Reihe
				7.5f, 1.5f, // links
				7.5f, 4.5f, // mitte
				7.5f, 7.5f, // rechts

				// mittlere Reihe
				4.5f, 1.5f, // l
				4.5f, 4.5f, // m
				4.5f, 7.5f, // r

				// untere Reihe
				1.5f, 1.5f, // l
				1.5f, 4.5f, // m
				1.5f, 7.5f // r

		};
		//OpenGL ES 2.0 Seite 28
		vertexData = ByteBuffer
				.allocateDirect(feldEckpunkte.length * BYTES_PER_FLOAT)
				.order(ByteOrder.nativeOrder()).asFloatBuffer();
		
		vertexData.put(feldEckpunkte);
	}
}
