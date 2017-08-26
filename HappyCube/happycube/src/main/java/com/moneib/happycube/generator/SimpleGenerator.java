package com.moneib.happycube.generator;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.progressor.AbstractProgressor;
import com.moneib.happycube.rule.AbstractRule;

/**
 * The Class SimpleGenerator provides the simplest generation mechanism to
 * produce a specific cube out of a {@link Cube} representation.
 */
public class SimpleGenerator extends AbstractCubeGenerator {

	/**
	 * Instantiates a new simple generator of a {@link Cube} in accordance with
	 * a specific {@link AbstractRule} and through a specific {@link AbstractProgressor}.
	 *
	 * @param progressor
	 *            the progressor which defines the cube's next state.
	 * @param rule
	 *            the rule which checks if the current state of the cube is
	 *            satisfactory in accordance to the rule specified.
	 */
	public SimpleGenerator(AbstractProgressor progressor, AbstractRule rule) {
		super(progressor, rule);
	}

	/**
	 * Generates a specific cube out of an input cube representation, if possible,
	 * using the {@link AbstractProgressor} to change the state of the cube, and the
	 * {@link AbstractRule} to check if the current states is satifactory as a solution.
	 * <br>
	 * <br>
	 * Note that this is a wrapping method callig {@link #generateSimply(Cube)}.
	 */
	@Override
	public Cube generateCube(Cube cube) {
		return generateSimply(cube);
	}

	/**
	 * The simplest mechanism of {@link Progress} and {@link AbstractRule} interaction
	 * to generate a specific Cube using {@link AbstractRule} and {@link AbstractProgressor}.
	 * <br>
	 * <br>
	 * Note that this simple implementation does not provide a fall back
	 * strategy in case a solution is not found, which will lead to infinite
	 * looping. Hence, <b>it should only be used when the input cube is
	 * guaranteed to produce a solution.</b> An alternative approach with a
	 * timeout fall back strategy could be done using
	 * {@link SimpleGeneratorWithTimeout}.
	 *
	 * @param cube
	 *            the representation of a cube as 6 pieces. Such a cube is not
	 *            guaranteed to produce a cube in accordance with the specified
	 *            rule.
	 * @return the solution out of the specific cube generation mechanism as
	 *         defined by the progressor.
	 */
	protected Cube generateSimply(Cube cube) {
		while (!rule.check(cube)) {
			progressor.nextState(cube);
		}
		return cube;
	}

}
