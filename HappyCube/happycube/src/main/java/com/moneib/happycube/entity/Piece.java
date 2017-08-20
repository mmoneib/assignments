package com.moneib.happycube.entity;

import com.moneib.happycube.utility.DataModifier;

public class Piece {
	private char[][] structure;
	private char[] north;
	private char[] south;
	private char[] east;
	private char[] west;

	public Piece(char[][] structure) {
		this.structure = structure;

		initializeSides();
	}

	public Piece(Piece piece) {
		north = piece.getNorth().clone();
		south = piece.getSouth().clone();
		west = piece.getWest().clone();
		east = piece.getEast().clone();
	}

	public char[] getNorth() {
		return north;
	}

	public void setNorth(char[] north) {
		this.north = north;
	}

	public char[] getSouth() {
		return south;
	}

	public void setSouth(char[] south) {
		this.south = south;
	}

	public char[] getEast() {
		return east;
	}

	public void setEast(char[] east) {
		this.east = east;
	}

	public char[] getWest() {
		return west;
	}

	public void setWest(char[] west) {
		this.west = west;
	}

	private void initializeSides() {
		north = structure[0];
		south = structure[4];
		east = new char[] { structure[0][4], structure[1][4], structure[2][4], structure[3][4], structure[4][4] };
		west = new char[] { structure[0][0], structure[1][0], structure[2][0], structure[3][0], structure[4][0] };
	}

	public void rotateClockWise() {
		char[] temp = north.clone();
		north = west;
		west = south;
		south = east;
		east = temp;
	}

	public void rotateAntiClockwise() {
		char[] temp = north.clone();
		north = east;
		east = south;
		south = west;
		west = temp;
	}

	public void flip() {
		char[] temp = north.clone();
		north = south;
		south = temp;
		east = DataModifier.getInstance().reverseEdge(east);
		west = DataModifier.getInstance().reverseEdge(west);

	}
}
