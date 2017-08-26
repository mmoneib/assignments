package com.moneib.happycube.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;

public class SimpleGeneratorTest {
	private SimpleGenerator gen;
	protected Cube cube1;
	protected Cube cube2;
	protected Cube cube3;
	protected Cube cube4;
	protected Cube cubeSingleSolution;

	@Before
	public void setUp() {
		gen = new SimpleGenerator(new RandomProgressor(), FitRule.getInstance());
		setupCubes();
	}

	protected void setupCubes() {
		setupCube1();
		setupCube2();
		setupCube3();
		setupCube4();
		setupCubeWithSingleSolution();
	}

	private void setupCube1() {
		char[][] structure1 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } };
		char[][] structure2 = new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } };
		char[][] structure3 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { ' ', ' ', 'o', ' ', ' ' } };
		char[][] structure4 = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } };
		char[][] structure5 = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', ' ' } };
		char[][] structure6 = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', ' ', 'o', 'o' } };

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));

		cube1 = new Cube(pieces);
	}

	private void setupCube2() {
		char[][] structure1 = new char[][] { { ' ', ' ', ' ', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', 'o' } };
		char[][] structure2 = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', ' ', ' ' } };
		char[][] structure3 = new char[][] { { ' ', 'o', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', ' ', 'o', 'o' } };
		char[][] structure4 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } };
		char[][] structure5 = new char[][] { { ' ', ' ', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', ' ' } };
		char[][] structure6 = new char[][] { { ' ', 'o', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', 'o' } };

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));

		cube2 = new Cube(pieces);
	}

	private void setupCube3() {
		char[][] structure1 = new char[][] { { 'o', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { ' ', ' ', 'o', ' ', ' ' } };
		char[][] structure2 = new char[][] { { ' ', ' ', ' ', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', ' ' } };
		char[][] structure3 = new char[][] { { ' ', 'o', ' ', ' ', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } };
		char[][] structure4 = new char[][] { { 'o', 'o', ' ', 'o', 'o' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', ' ' } };
		char[][] structure5 = new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', ' ', 'o', 'o', ' ' } };
		char[][] structure6 = new char[][] { { ' ', 'o', ' ', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } };

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));

		cube3 = new Cube(pieces);
	}

	private void setupCube4() {
		char[][] structure1 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', ' ' } };
		char[][] structure2 = new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', ' ' } };
		char[][] structure3 = new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', ' ' } };
		char[][] structure4 = new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', ' ' } };
		char[][] structure5 = new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', ' ', 'o', ' ' } };
		char[][] structure6 = new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', ' ', 'o', 'o' } };

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));

		cube4 = new Cube(pieces);
	}

	private void setupCubeWithSingleSolution() {
		char[][] structure1 = new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' } };
		char[][] structure2 = new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', ' ', 'o' } };
		char[][] structure3 = new char[][] { { ' ', ' ', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', 'o' }, { ' ', ' ', ' ', ' ', ' ' } };
		char[][] structure4 = new char[][] { { ' ', 'o', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', ' ', ' ', ' ', ' ' } };
		char[][] structure5 = new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', 'o' }, { ' ', ' ', ' ', ' ', ' ' } };
		char[][] structure6 = new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } };

		ArrayList<Piece> pieces = new ArrayList<>();
		pieces.add(new Piece(structure1));
		pieces.add(new Piece(structure2));
		pieces.add(new Piece(structure3));
		pieces.add(new Piece(structure4));
		pieces.add(new Piece(structure5));
		pieces.add(new Piece(structure6));

		cubeSingleSolution = new Cube(pieces);
	}

	@Test
	public void testGenerateCubeWithFittingCornersOfCube1() {
		testGenerateCubeWithFittingCornersOf(gen.generateCube(cube1));
	}

	@Test
	public void testGenerateCubeWithFittingCornersOfCube2() {
		testGenerateCubeWithFittingCornersOf(gen.generateCube(cube2));
	}

	@Test
	public void testGenerateCubeWithFittingCornersOfCube3() {
		testGenerateCubeWithFittingCornersOf(gen.generateCube(cube3));
	}

	@Test
	public void testGenerateCubeWithFittingCornersOfCube4() {
		testGenerateCubeWithFittingCornersOf(gen.generateCube(cube4));
	}

	@Test
	public void testGenerateCubeWithFittingCornersOfCubeWithSingleSolution() {
		testGenerateCubeWithFittingCornersOf(gen.generateCube(cubeSingleSolution));
	}

	@Test
	public void testGenerateCubeWithFittingEdgeOfCube1() {
		testGenerateCubeWithFittingEdgesOf(gen.generateCube(cube1));
	}

	@Test
	public void testGenerateCubeWithFittingEdgeOfCube2() {
		testGenerateCubeWithFittingEdgesOf(gen.generateCube(cube2));
	}

	@Test
	public void testGenerateCubeWithFittingEdgeOfCube3() {
		testGenerateCubeWithFittingEdgesOf(gen.generateCube(cube3));
	}

	@Test
	public void testGenerateCubeWithFittingEdgeOfCube4() {
		testGenerateCubeWithFittingEdgesOf(gen.generateCube(cube4));
	}

	@Test
	public void testGenerateCubeWithFittingEdgeOfCubeSingleSolution() {
		testGenerateCubeWithFittingEdgesOf(gen.generateCube(cubeSingleSolution));
	}

	protected void testGenerateCubeWithFittingCornersOf(Cube newCube) {

		assertEquals(1,
				newCube.getFace2().getStructure()[4][0] == 'o' ? 1
						: 0 + newCube.getFace5().getStructure()[4][4] == 'o' ? 1
								: 0 + newCube.getFace3().getStructure()[0][0] == 'o' ? 1 : 0);

		assertEquals(1,
				newCube.getFace2().getStructure()[4][4] == 'o' ? 1
						: 0 + newCube.getFace6().getStructure()[4][0] == 'o' ? 1
								: 0 + newCube.getFace3().getStructure()[0][4] == 'o' ? 1 : 0);

		assertEquals(1,
				newCube.getFace2().getStructure()[0][0] == 'o' ? 1
						: 0 + newCube.getFace5().getStructure()[0][4] == 'o' ? 1
								: 0 + newCube.getFace1().getStructure()[4][0] == 'o' ? 1 : 0);

		assertEquals(1,
				newCube.getFace2().getStructure()[0][4] == 'o' ? 1
						: 0 + newCube.getFace6().getStructure()[0][0] == 'o' ? 1
								: 0 + newCube.getFace1().getStructure()[4][4] == 'o' ? 1 : 0);
	}

	protected void testGenerateCubeWithFittingEdgesOf(Cube cube) {
		Cube newCube = gen.generateCube(cube1);
		int maxToothPerEdge = newCube.getFace1().getStructure().length - 1;
		String testMessage = "Unfitting teeth encountered.";

		for (int i = 1; i < maxToothPerEdge; i++) {
			assertTrue(testMessage, newCube.getFace1().getStructure()[4][i] != newCube.getFace2().getStructure()[0][i]);

			assertTrue(testMessage, newCube.getFace2().getStructure()[4][i] != newCube.getFace3().getStructure()[0][i]);

			assertTrue(testMessage, newCube.getFace3().getStructure()[4][i] != newCube.getFace4().getStructure()[0][i]);

			assertTrue(testMessage, newCube.getFace4().getStructure()[4][i] != newCube.getFace1().getStructure()[0][i]);

			assertTrue(testMessage, newCube.getFace2().getStructure()[i][0] != newCube.getFace5().getStructure()[i][4]);

			assertTrue(testMessage, newCube.getFace2().getStructure()[i][4] != newCube.getFace6().getStructure()[i][0]);

			assertTrue(testMessage, newCube.getFace5().getStructure()[i][0] != newCube.getFace4()
					.getStructure()[maxToothPerEdge - i][0]);

			assertTrue(testMessage, newCube.getFace4().getStructure()[i][4] != newCube.getFace6()
					.getStructure()[maxToothPerEdge - i][4]);

			assertTrue(testMessage, newCube.getFace5().getStructure()[0][i] != newCube.getFace1().getStructure()[i][0]);

			assertTrue(testMessage, newCube.getFace6().getStructure()[0][i] != newCube.getFace1()
					.getStructure()[maxToothPerEdge - i][4]);

			assertTrue(testMessage, newCube.getFace5().getStructure()[4][i] != newCube.getFace3()
					.getStructure()[maxToothPerEdge - i][0]);

			assertTrue(testMessage, newCube.getFace6().getStructure()[4][i] != newCube.getFace3().getStructure()[i][4]);

		}
	}

}
