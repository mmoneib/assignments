package com.moneib.happycube.entity;

import com.moneib.happycube.utility.DataModifier;

public class Piece {
	private char[][] structure;
	// private char[] north;
	// private char[] south;
	// private char[] east;
	// private char[] west;

	public Piece(char[][] structure) {
		this.structure = structure;

		// initializeSides();
	}

	public Piece(Piece piece) {
		/*
		 * north = piece.getNorth().clone(); south = piece.getSouth().clone();
		 * west = piece.getWest().clone(); east = piece.getEast().clone();
		 */

		structure = piece.structure.clone();
	}

	public char[] getNorth() {
		return structure[0];
	}

	public void setNorth(char[] north) {
		structure[0] = north;
	}

	public char[] getSouth() {
		return structure[4];
	}

	public void setSouth(char[] south) {
		structure[4] = south;
	}

	public char[] getEast() {
		char[] east = new char[5];

		for (int i = 0; i < east.length; i++) {
			east[i] = structure[i][4];
		}

		return east;
	}

	public void setEast(char[] east) {
		for (int i = 0; i < east.length; i++) {
			structure[i][4] = east[i];
		}
	}

	public char[] getWest() {
		char[] west = new char[5];

		for (int i = 0; i < west.length; i++) {
			west[i] = structure[0][i];
		}

		return west;
	}

	public void setWest(char[] west) {
		for (int i = 0; i < west.length; i++) {
			structure[0][i] = west[i];
		}
	}

	/*
	 * private void initializeSides() { north = structure[0]; south =
	 * structure[4]; east = new char[] { structure[0][4], structure[1][4],
	 * structure[2][4], structure[3][4], structure[4][4] }; west = new char[] {
	 * structure[0][0], structure[1][0], structure[2][0], structure[3][0],
	 * structure[4][0] }; }
	 */
	public void rotateClockWise() {
		char[] temp = getNorth().clone();
		setNorth(getWest());
		setWest(getSouth());
		setSouth(getEast());
		setEast(temp);
	}

	public void flip() {
		char[] temp = getNorth().clone();
		setNorth(getSouth());
		setSouth(temp);
		setEast(DataModifier.getInstance().reverseEdge(getEast()));
		setWest(DataModifier.getInstance().reverseEdge(getWest()));
	}

	public char[][] getStructure() {
		return structure;
	}

	public void setStructure(char[][] structure) {
		this.structure = structure;
	}
}
