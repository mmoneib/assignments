package com.moneib.happycube.generator.progressor;

import static org.junit.Assert.*;

import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;

public class RandomProgressorTest {

	@Test
	public void testNextState() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(
				new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' },
						{ 'o', 'o', 'o', 'o', 'o' }, { /* Test criterion. */'o', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		RandomProgressor randomProgressor = new RandomProgressor();
		Cube newCube = new Cube(face1, face2, face3, face4, face5, face6);
		randomProgressor.nextState(newCube);

		assertNotEquals(new Cube(face1, face2, face3, face4, face5, face6), newCube);
	}

}
