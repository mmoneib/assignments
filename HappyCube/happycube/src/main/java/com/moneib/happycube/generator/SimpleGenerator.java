package com.moneib.happycube.generator;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.progressor.Progressor;
import com.moneib.happycube.rule.Rule;

public class SimpleGenerator extends AbstractCubeGenerator {

	public SimpleGenerator(Progressor progressor, Rule rule) {
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
