package com.moneib.happycube.entity;

import com.moneib.happycube.rule.AbstractRule;
import com.moneib.happycube.utility.DataModifier;

/**
 * The Class Piece represents one of the faces that constitute a {@link Cube}.
 * It is typically a 2D block with teeth on its 4 sides, but it can also be
 * either toothless or toothful. Such arrangement of teeth determines whether 2
 * pieces can lie adjacently in a cube according to the specified
 * {@link AbstractRule rule}.
 */
public class Piece extends AbstractEntity {

	/**
	 * The structure of the piece with 'o' indicating a tooth and ' ' indicating
	 * the lackthereof.
	 */
	private char[][] structure;

	/**
	 * Instantiates a new piece from a 2D structure (2D array of 'o' and ' '.
	 *
	 * @param structure
	 *            the structure of the piece.
	 */
	public Piece(char[][] structure) {
		this.structure = structure;
	}

	/**
	 * Gets the north side of the structure.
	 *
	 * @return the north side.
	 */
	public char[] getNorth() {
		return structure[0];
	}

	/**
	 * Sets the north side of the structure.
	 *
	 * @param north
	 *            the new north side.
	 */
	public void setNorth(char[] north) {
		structure[0] = north;
	}

	/**
	 * Gets the south side of the structure..
	 *
	 * @return the south side.
	 */
	public char[] getSouth() {
		return structure[4];
	}

	/**
	 * Sets the south side of the structure..
	 *
	 * @param south
	 *            the new south side.
	 */
	public void setSouth(char[] south) {
		structure[4] = south;
	}

	/**
	 * Gets the east side of the structure..
	 *
	 * @return the east side.
	 */
	public char[] getEast() {
		char[] east = new char[5];

		for (int i = 0; i < east.length; i++) {
			east[i] = structure[i][4];
		}

		return east;
	}

	/**
	 * Sets the east side of the structure..
	 *
	 * @param east
	 *            the new east side.
	 */
	public void setEast(char[] east) {
		for (int i = 0; i < east.length; i++) {
			structure[i][4] = east[i];
		}
	}

	/**
	 * Gets the west side of the structure..
	 *
	 * @return the west side.
	 */
	public char[] getWest() {
		char[] west = new char[5];

		for (int i = 0; i < west.length; i++) {
			west[i] = structure[i][0];
		}

		return west;
	}

	/**
	 * Sets the west side of the structure..
	 *
	 * @param west
	 *            the new west side.
	 */
	public void setWest(char[] west) {
		for (int i = 0; i < west.length; i++) {
			structure[i][0] = west[i];
		}
	}

	/**
	 * Rotate the piece clock-wise as indicated by its 4 sides.
	 */
	public void rotateClockWise() {
		char[] temp = getNorth().clone();

		setNorth(DataModifier.reverseEdge(getWest()));
		setWest(getSouth());
		setSouth(DataModifier.reverseEdge(getEast()));
		setEast(temp);
	}

	/**
	 * Flip the piece vertically (similar to 180 degrees rotation in the third
	 * dimension.
	 */
	public void flip() {
		char[] tempNorth = getNorth().clone();
		char[] tempSouth = getSouth().clone();

		setEast(DataModifier.reverseEdge(getEast()));
		setWest(DataModifier.reverseEdge(getWest()));
		setNorth(tempSouth);
		setSouth(tempNorth);
	}

	/**
	 * Gets the structure of the piece with 'o' indicating a tooth and ' '
	 * indicating the lackthereof.
	 *
	 * @return the structure of the piece.
	 */
	public char[][] getStructure() {
		return structure;
	}

	/**
	 * Sets the structure of the piece with 'o' indicating a tooth and ' '
	 * indicating the lackthereof.
	 *
	 * @param structure
	 *            the new structure of the piece.
	 */
	public void setStructure(char[][] structure) {
		this.structure = structure;
	}

	/**
	 * Checks the equality of 2 pieces through their structures.
	 */
	@Override
	public boolean equals(Object piece) {
		if (this.getStructure().equals(((Piece) piece).getStructure()))
			return true;
		else
			return false;
	}
}
