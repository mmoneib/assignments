package com.moneib.happycube.generator.progressor;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;

public class RandomProgressor implements Progressor {
	Random random = new Random();

	@Override
	public void nextState(Cube cube) {
		shuffleFaces(cube);
		modifyFaces(cube.getFaces());
	}

	private void shuffleFaces(Cube cube) {
		Collections.shuffle(cube.getFaces());
	}

	private void modifyFaces(List<Piece> faces) {
		for (Piece face : faces) {
			int count = random.nextInt(2);

			for (int i = 0; i < count; i++) {
				face.flip();
			}

			count = random.nextInt(4);

			for (int i = 0; i < count; i++) {
				face.rotateClockWise();
			}
		}
	}

}
