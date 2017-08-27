package com.moneib.happycube.utility;

import java.io.PrintWriter;

/**
 * The Interface Printable adds the print functionality to any implementing
 * class. It is intended to be use for printing the state of such class
 */
public interface Printable {

	/**
	 * Any implementing class should use this method to print its state.
	 *
	 * @param writer
	 *            the writer provided to which the state will be output.
	 */
	public void print(PrintWriter writer);
}
