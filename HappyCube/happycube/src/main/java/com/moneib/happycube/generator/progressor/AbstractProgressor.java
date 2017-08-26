package com.moneib.happycube.generator.progressor;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.generator.AbstractCubeGenerator;

/**
 * The Interface Progressor sets the contract for all children progressors to
 * follow in order to modify the state of a {@link Cube}. This allows any
 * progressor to be used as a plugin in an extensions of the
 * {@link AbstractCubeGenerator}.
 */
public abstract class AbstractProgressor {

	/**
	 * Any ancestor class should implement this method to modify the state of the
	 * specified {@link Cube}.
	 *
	 * @param cube
	 *            the cube to be modified
	 */
	public abstract void nextState(Cube cube);
}
