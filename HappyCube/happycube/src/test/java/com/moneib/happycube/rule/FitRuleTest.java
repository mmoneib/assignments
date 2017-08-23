package com.moneib.happycube.rule;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;

public class FitRuleTest {
	public static FitRule fitRule;

	@BeforeClass
	public static void setUpRule() {
		fitRule = FitRule.getFitRule();
	}

	@Test
	public void testChecIncorrectDueToCornerOverlap() {
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

		assertFalse(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testChecIncorrectDueToCornerEmpty() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(
				new char[][] { { /* Test criterion. */ ' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
						{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		assertFalse(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testChecIncorrectDueToEdgeOverlap() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', /* Test criterion. */'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		assertFalse(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testCheckCorrectNormal() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		assertTrue(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testCheckCorrectFromIncorrectEdgeOverlap() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(
				new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' },
						{ 'o', 'o', 'o', 'o', /* Test criterion. */' ' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', /* Test criterion. */'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		assertTrue(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testCheckCorrectFromIncorrectCornerOverlap() {
		Piece face1 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', ' ' }, { 'o', 'o', ' ', 'o', ' ' } });
		Piece face2 = new Piece(
				new char[][] { { ' ', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' },
						{ 'o', 'o', 'o', 'o', 'o' }, { /* Test criterion. */'o', 'o', ' ', 'o', 'o' } });
		Piece face3 = new Piece(
				new char[][] { { /* Test criterion. */' ', ' ', 'o', ' ', ' ' }, { 'o', 'o', 'o', 'o', 'o' },
						{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', ' ', 'o', ' ' } });
		Piece face4 = new Piece(new char[][] { { 'o', ' ', 'o', ' ', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', ' ' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', ' ', 'o', ' ', 'o' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', 'o', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', 'o', ' ', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', 'o' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', 'o', ' ', ' ' } });

		assertTrue(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));
	}

	@Test
	public void testCheckIncorrectToothfulCube() {
		Piece face1 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });
		Piece face2 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });
		Piece face3 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });
		Piece face4 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o','o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });
		Piece face5 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });
		Piece face6 = new Piece(new char[][] { { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' }, { 'o', 'o', 'o', 'o', 'o' } });

		assertFalse(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));

	}
	
	@Test
	public void testCheckIncorrectToothlessCube() {
		Piece face1 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });
		Piece face2 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });
		Piece face3 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });
		Piece face4 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o','o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });
		Piece face5 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });
		Piece face6 = new Piece(new char[][] { { ' ', ' ', ' ', ' ', ' ' }, { ' ', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ' }, { ' ', 'o', 'o', 'o', ' ' }, { ' ', ' ', ' ', ' ', ' ' } });

		assertFalse(fitRule.check(new Cube(face1, face2, face3, face4, face5, face6)));

	}
}
