package com.moneib.happycube.generator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.NullCube;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;

public class SimpleGeneratorWithTimeoutTest extends SimpleGeneratorTest {
	private SimpleGeneratorWithTimeout gen;

	@Before
	public void setUp() {
		gen = new SimpleGeneratorWithTimeout(new RandomProgressor(), FitRule.getInstance(), 5, TimeUnit.SECONDS);
		super.setUp();
	}

	@Test
	public void testTimeout() {
		gen.setTimeout(0);
		assertTrue("Returned cube is not nullified despite timeout.",
				gen.generateCube(cubeSingleSolution) instanceof NullCube);
	}

	@Test
	public void testNoTimeout() {
		gen.setTimeout(120);
		Cube newCube = gen.generateCube(cubeSingleSolution);
		assertFalse("Returned cube is a nullified cube despite no timeout.", newCube instanceof NullCube);

		testGenerateCubeWithFittingEdgesOf(newCube);
		testGenerateCubeWithFittingCornersOf(newCube);
	}

}
