package com.moneib.happycube.utility;

/**
 * The Interface Nullified is used to indicate a null object and provide it with
 * error propagation mechanism.
 */
public interface Nullified {

	/**
	 * Gets the error message that led to the failure of finding a solution.
	 * 
	 * @return the error message.
	 */
	public String getError();

	/**
	 * Sets the error message that led to the failure of finding a solution.
	 * 
	 * @param error
	 *            the new error message.
	 */
	public void setError(String error);
}
