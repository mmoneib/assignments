package com.moneib.happycube.generator.progressor;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;

/**
 * The Class RandomProgressor provides the mechanism of modifying the state of a
 * {@link Cube} in a random manner. The manner of modification itself depends on
 * the physics of the cube as defined in the {@code Cube} class, and in this
 * implementation, it is assumed that the cube can have its faces shuffled,
 * rotated, or flipped, such as in a Happy Cube.
 */
public class RandomProgressor extends AbstractProgressor {

	/** The random generator used to modify the cube randomly. */
	private Random random = new Random();

	/**
	 * Modifies the state of the specified {@code Cube} by randomly shuffling
	 * the cube's faces, rotating them, and/or flipping them. This ensures that
	 * the next state of the cube will be one of all the possible states in the
	 * probability space as permitted by the cube's physics.
	 */
	@Override
	public void nextState(Cube cube) {
		shuffleFaces(cube);
		modifyFaces(cube.getFaces());
	}

	/**
	 * Shuffle the faces of the cubes randomly..
	 *
	 * @param cube
	 *            the cube
	 */
	private void shuffleFaces(Cube cube) {
		Collections.shuffle(cube.getFaces());
	}

	/**
	 * Modify the faces of the cube by flipping and/or rotating each one of
	 * them.
	 *
	 * @param faces
	 *            the pieces that comprise the cube.
	 */
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
