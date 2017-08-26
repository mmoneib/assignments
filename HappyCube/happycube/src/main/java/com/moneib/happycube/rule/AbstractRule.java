package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Cube;

/**
 * The Class AbstractRule seths the contract for all the children rules to check
 * the validity of a cube and return such result.
 */
public abstract class AbstractRule {

	/**
	 * Check the validity of the specified {@link Cube} through the rule
	 * implemented.
	 *
	 * @param cube
	 *            the cube to be checked against the rule
	 * @return true, if the cube is valid.
	 */
	public abstract boolean check(Cube cube);
}
