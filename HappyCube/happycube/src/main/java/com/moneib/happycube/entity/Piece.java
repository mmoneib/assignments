package com.moneib.happycube.entity;

import com.moneib.happycube.utility.DataModifier;

public class Piece extends AbstractEntity {
	private char[][] structure;

	public Piece(char[][] structure) {
		this.structure = structure;
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
			west[i] = structure[i][0];
		}

		return west;
	}

	public void setWest(char[] west) {
		for (int i = 0; i < west.length; i++) {
			structure[i][0] = west[i];
		}
	}

	public void rotateClockWise() {
		char[] temp = getNorth().clone();

		setNorth(DataModifier.getInstance().reverseEdge(getWest()));
		setWest(getSouth());
		setSouth(DataModifier.getInstance().reverseEdge(getEast()));
		setEast(temp);
	}

	public void flip() {
		char[] tempNorth = getNorth().clone();
		char[] tempSouth = getSouth().clone();

		setEast(DataModifier.getInstance().reverseEdge(getEast()));
		setWest(DataModifier.getInstance().reverseEdge(getWest()));
		setNorth(tempSouth);
		setSouth(tempNorth);
	}

	public char[][] getStructure() {
		return structure;
	}

	public void setStructure(char[][] structure) {
		this.structure = structure;
	}

	@Override
	public boolean equals(Object piece) {
		if (this.getStructure().equals(((Piece) piece).getStructure()))
			return true;
		else
			return false;
	}
}
