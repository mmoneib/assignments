package com.moneib.happycube.generator;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.progressor.RandomProgressor;
import com.moneib.happycube.rule.FitRule;

public class RandomCubeGenerator extends AbstractCubeGenerator {

	public RandomCubeGenerator(RandomProgressor progressor, FitRule rule) {
		super(progressor, rule);
	}

	@Override
	public Cube generateCube(Cube cube) {
		while (!rule.check(cube)) {
			progressor.nextState(cube);
		}
		return cube;
	}

}
