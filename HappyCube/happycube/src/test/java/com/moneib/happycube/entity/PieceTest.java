package com.moneib.happycube.entity;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.moneib.happycube.entity.Piece;

public class PieceTest {
	private char[][] structure;
	private Piece piece;

	@Before
	public void setUpPiece() {
		structure = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', ' ', 'o' } };

		char[][] structureClone = new char[][] { Arrays.copyOf(structure[0], structure[0].length),
				Arrays.copyOf(structure[1], structure[1].length), Arrays.copyOf(structure[2], structure[2].length),
				Arrays.copyOf(structure[3], structure[3].length), Arrays.copyOf(structure[4], structure[4].length) };

		piece = new Piece(structureClone);
	}

	@Test
	public void testPieceConstructByMultiCharArr() {
		Piece piece = new Piece(new char[][] { Arrays.copyOf(structure[0], structure[0].length),
				Arrays.copyOf(structure[1], structure[1].length), Arrays.copyOf(structure[2], structure[2].length),
				Arrays.copyOf(structure[3], structure[3].length), Arrays.copyOf(structure[4], structure[4].length) });

		assertArrayEquals(structure, piece.getStructure());
		assertArrayEquals(structure[0], piece.getNorth());
		assertArrayEquals(structure[4], piece.getSouth());
		assertArrayEquals(
				new char[] { structure[0][4], structure[1][4], structure[2][4], structure[3][4], structure[4][4] },
				piece.getEast());
		assertArrayEquals(
				new char[] { structure[0][0], structure[1][0], structure[2][0], structure[3][0], structure[4][0] },
				piece.getWest());

		piece.setEast(new char[] { ' ', ' ', 'o', ' ', ' ' });
		piece.setWest(new char[] { ' ', 'o', ' ', ' ', ' ' });
		piece.setNorth(new char[] { ' ', ' ', ' ', 'o', ' ' });
		piece.setSouth(new char[] { ' ', ' ', 'o', ' ', ' ' });

		assertArrayEquals(new char[][] { { ' ', ' ', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } },
				piece.getStructure());
	}

	@Test
	public void testRotateClockWise() {
		piece.rotateClockWise();

		assertArrayEquals(
				new char[][] { { structure[4][0], structure[3][0], structure[2][0], structure[1][0], structure[0][0] },
						{ structure[4][1], 'o', 'o', 'o', structure[0][1] },
						{ structure[4][2], 'o', 'o', 'o', structure[0][2] },
						{ structure[4][3], 'o', 'o', 'o', structure[0][3] },
						{ structure[4][4], structure[3][4], structure[2][4], structure[1][4], structure[0][4] } },
				piece.getStructure());
	}

	@Test
	public void testFlip() {
		piece.flip();

		assertArrayEquals(
				new char[][] { { structure[4][0], structure[4][1], structure[4][2], structure[4][3], structure[4][4] },
						{ structure[3][0], 'o', 'o', 'o', structure[3][4] },
						{ structure[2][0], 'o', 'o', 'o', structure[2][4] },
						{ structure[1][0], 'o', 'o', 'o', structure[1][4] },
						{ structure[0][0], structure[0][1], structure[0][2], structure[0][3], structure[0][4] } },
				piece.getStructure());
	}

}
