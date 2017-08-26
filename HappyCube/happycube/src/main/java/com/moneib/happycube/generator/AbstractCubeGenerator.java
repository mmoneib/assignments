package com.moneib.happycube.generator;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.progressor.AbstractProgressor;
import com.moneib.happycube.rule.AbstractRule;

/**
 * The Class AbstractCubeGenerator sets the example to be followed by all
 * extending generators in order to generate a specific {@link Cube} out of an
 * input one. It uses both a {@link AbstractProgressor} and a {@link AbstractRule} to achieve
 * this goal.
 */
public abstract class AbstractCubeGenerator {

	/** The progressor which defines the cube's next state. */
	protected AbstractProgressor progressor;

	/**
	 * The rule which checks if the current state of the cube is satisfactory in
	 * accordance to the rule specified.
	 */
	protected AbstractRule rule;

	/**
	 * An abstract constructor to be calThe simplest mechanism of
	 * {@link AbstractProgressor} and {@link AbstractRule} interactionled by the ancestry in order
	 * to initialize the progressor and ule to be using in the generation.
	 *
	 * @param progressor
	 *            the progressor used to define the next state of the cube.
	 * @param rule
	 *            the rule used to check if the current state of the cube is
	 *            satisfactory as a solution.
	 */
	public AbstractCubeGenerator(AbstractProgressor progressor, AbstractRule rule) {
		this.progressor = progressor;
		this.rule = rule;
	}

	/**
	 * Any overriding ancestry should use this method to extend the mechanism of
	 * cube generation.
	 * 
	 * The simplest mechanism of {@link Progress} and {@link AbstractRule} interaction
	 * is as defined in {@link SimpleGenerator#generateSimply(Cube)
	 * generateSimply(Cube)} method of {@link SimpleGenerator}: <br>
	 * <br>
	 * {@code while (!rule.check(cube)) { progressor.nextState(cube); } return
	 * cube;}
	 *
	 * @param cube
	 *            the representation of a cube as 6 pieces. Such a cube is not
	 *            guaranteed to produce a satisfactory solution.
	 * @return the solution, as defined by the rule, out of the cube generation
	 *         mechanism, as defined by the progressor.
	 */
	public abstract Cube generateCube(Cube cube);
}
