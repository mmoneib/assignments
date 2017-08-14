package com.moneib.happycube.entity;

public class Piece {
	char[][] structure;
	char[] north;
	char[] south;
	char[] east;
	char[] west;

	public Piece(char[][] structure) {
		this.structure = structure;

		initializeSides();
	}

	private void initializeSides() {
		north = structure[0];
		south = structure[4];
		east = new char[] { structure[0][4], structure[1][4], structure[2][4], structure[3][4], structure[4][4] };
		west = new char[] { structure[0][0], structure[1][0], structure[2][0], structure[3][0], structure[4][0] };
	}

	public void rotateClockWise() {
		char[] temp = north;
		north = west;
		west = south;
		south = east;
		east = temp;
	}

	public void rotateAntiClockwise() {
		char[] temp = north;
		north = east;
		east = south;
		south = west;
		west = temp;
	}
}
