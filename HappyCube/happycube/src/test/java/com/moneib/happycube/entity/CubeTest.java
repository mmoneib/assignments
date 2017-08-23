package com.moneib.happycube.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;

public class CubeTest {
	private static ArrayList<Piece> pieces = new ArrayList<>();
	private static char[][] structure1;
	private static char[][] structure2;
	private static char[][] structure3;
	private static char[][] structure4;
	private static char[][] structure5;
	private static char[][] structure6;
	private Cube cube;

	@BeforeClass
	public static void preparePieces() {
		structure1 = new char[][] { { 'o', ' ', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' } };
		structure2 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', 'o' } };
		structure3 = new char[][] { { 'o', ' ', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' } };
		structure4 = new char[][] { { 'o', ' ', ' ', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' } };
		structure5 = new char[][] { { 'o', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' } };
		structure6 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', 'o' } };

		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));
	}

	@Before
	public void setUpCube() {
		cube = new Cube(pieces);
	}

	@Test
	public void testCubeConstructPieceByPieces() {
		cube = new Cube(pieces.get(0), pieces.get(1), pieces.get(2), pieces.get(3), pieces.get(4), pieces.get(5));

		assertEquals(pieces.get(0), cube.getFace1());
		assertEquals(pieces.get(1), cube.getFace2());
		assertEquals(pieces.get(2), cube.getFace3());
		assertEquals(pieces.get(3), cube.getFace4());
		assertEquals(pieces.get(4), cube.getFace5());
		assertEquals(pieces.get(5), cube.getFace6());
	}

	@Test
	public void testCubeConstructByListOfPiece() {
		cube = new Cube(pieces);

		assertEquals(pieces.get(0), cube.getFace1());
		assertEquals(pieces.get(1), cube.getFace2());
		assertEquals(pieces.get(2), cube.getFace3());
		assertEquals(pieces.get(3), cube.getFace4());
		assertEquals(pieces.get(4), cube.getFace5());
		assertEquals(pieces.get(5), cube.getFace6());
	}

	@Test
	public void testGetFaces() {
		assertEquals(pieces, cube.getFaces());
	}

	@Test
	public void testPrint() {
		File file = new File("test");
		String[] lines = new String[20];

		try (PrintWriter writer = new PrintWriter("test");
				BufferedReader reader = new BufferedReader(new FileReader(file));) {
			cube.print(writer);
			int count = 0;
			Iterator<String> linesIt = reader.lines().iterator();
			while (linesIt.hasNext()) {
				lines[count] = linesIt.next();
				count++;
			}
		} catch (IOException e) {
			fail(e.getMessage());
		}

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(structure5[0]).append(structure2[0]).append(structure6[0]);
		assertEquals(stringBuilder.toString(), lines[0]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append(structure5[1]).append(structure2[1]).append(structure6[1]);
		assertEquals(stringBuilder.toString(), lines[1]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append(structure5[2]).append(structure2[2]).append(structure6[2]);
		assertEquals(stringBuilder.toString(), lines[2]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append(structure5[3]).append(structure2[3]).append(structure6[3]);
		assertEquals(stringBuilder.toString(), lines[3]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append(structure5[4]).append(structure2[4]).append(structure6[4]);
		assertEquals(stringBuilder.toString(), lines[4]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure3[0]);
		assertEquals(stringBuilder.toString(), lines[5]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure3[1]);
		assertEquals(stringBuilder.toString(), lines[6]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure3[2]);
		assertEquals(stringBuilder.toString(), lines[7]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure3[3]);
		assertEquals(stringBuilder.toString(), lines[8]);

		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.delete(0, stringBuilder.length());
		stringBuilder.append("     ").append(structure3[4]);
		assertEquals(stringBuilder.toString(), lines[9]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure4[0]);
		assertEquals(stringBuilder.toString(), lines[10]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure4[1]);
		assertEquals(stringBuilder.toString(), lines[11]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure4[2]);
		assertEquals(stringBuilder.toString(), lines[12]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure4[3]);
		assertEquals(stringBuilder.toString(), lines[13]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure4[4]);
		assertEquals(stringBuilder.toString(), lines[14]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure1[0]);
		assertEquals(stringBuilder.toString(), lines[15]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure1[1]);
		assertEquals(stringBuilder.toString(), lines[16]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure1[2]);
		assertEquals(stringBuilder.toString(), lines[17]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure1[3]);
		assertEquals(stringBuilder.toString(), lines[18]);

		stringBuilder.delete(0, stringBuilder.length());

		stringBuilder.append("     ").append(structure1[4]);
		assertEquals(stringBuilder.toString(), lines[19]);
	}

}
