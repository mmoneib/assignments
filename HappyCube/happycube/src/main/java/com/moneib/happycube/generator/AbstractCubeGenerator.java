package com.moneib.happycube.generator;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.progressor.Progressor;
import com.moneib.happycube.rule.Rule;

public abstract class AbstractCubeGenerator {
	protected Progressor progressor;
	protected Rule rule;

	public AbstractCubeGenerator(Progressor progressor, Rule rule) {
		this.progressor = progressor;
		this.rule = rule;
	}

	public abstract Cube generateCube(Cube cube);
}
