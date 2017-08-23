package com.moneib.happycube.generator;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;

public class SimpleGeneratorTest {
	private SimpleGenerator gen;
	private Cube cube;

	@Before
	public void setUpGenerator() {
		gen = new SimpleGenerator(new RandomProgressor(), FitRule.getFitRule());

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

		cube = new Cube(pieces);
	}

	@Test
	public void testGenerateCubeWithCorrectCorners() {
		Cube newCube = gen.generateCube(cube);

		assertEquals(1,
				newCube.getFace2().getStructure()[4][0] == 'o' ? 1
						: 0 + newCube.getFace5().getStructure()[4][4] == 'o' ? 1
								: 0 + newCube.getFace3().getStructure()[0][0] == 'o' ? 1 : 0);
	}

}
