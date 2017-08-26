package com.moneib.happycube.generator;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;

import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;

public class SimpleGeneratorWithTimerTest extends SimpleGeneratorTest {
	private SimpleGeneratorWithTimeout gen;

	@Before
	public void setUp() {
		gen = new SimpleGeneratorWithTimeout(new RandomProgressor(), FitRule.getInstance(), 5, TimeUnit.SECONDS);
		setupCubes();
	}

	@Test
	public void testTimeout() {
		gen.setTimeout(0);
		assertNull(gen.generateCube(cubeSingleSolution));
	}

}
