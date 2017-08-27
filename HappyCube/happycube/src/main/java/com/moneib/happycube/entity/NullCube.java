package com.moneib.happycube.entity;

import java.io.PrintWriter;

import com.moneib.happycube.generator.AbstractCubeGenerator;
import com.moneib.happycube.utility.Nullified;
import com.moneib.happycube.utility.Printable;

/**
 * The Class NullCube is used to indicate an unsuccessful attempt to find a
 * solution. It is propagated to the caller by the fall back strategy as defined
 * in the {@link AbstractCubeGenerator generator}.
 */
public class NullCube extends Cube implements Printable, Nullified {

	/**
	 * The error message indicating the reason of the failure to find a
	 * solution.
	 */
	private String error;

	/**
	 * Instantiates a new null cube. Here, the parameterless constructor of
	 * {@link Cube} is called implicitly, which insures that the instantiated
	 * null cube has no structure (faces).
	 * 
	 * @param error
	 *            the error message indicating the reason of the failure to find
	 *            a solution.
	 */
	public NullCube(String error) {
		this.error = error;
	}

	/**
	 * Prints the error message that led to the failure of finding a solution.
	 */
	@Override
	public void print(PrintWriter writer) {
		writer.println(error);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moneib.happycube.utility.Nullified#getError()
	 */
	@Override
	public String getError() {
		return error;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.moneib.happycube.utility.Nullified#setError(java.lang.String)
	 */
	@Override
	public void setError(String error) {
		this.error = error;

	}
}
