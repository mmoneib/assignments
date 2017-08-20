package com.moneib.happycube.entity;

import java.util.ArrayList;
import java.util.List;

public class Cube {
	private Piece face1;
	private Piece face2;
	private Piece face3;
	private Piece face4;
	private Piece face5;
	private Piece face6;

	public Cube(Piece face1, Piece face2, Piece face3, Piece face4, Piece face5, Piece face6) {
		this.face1 = face1;
		this.face2 = face2;
		this.face3 = face3;
		this.face4 = face4;
		this.face5 = face5;
		this.face6 = face6;
	}

	public Cube(List<Piece> pieces) {
		face1 = pieces.get(0);
		face2 = pieces.get(1);
		face3 = pieces.get(2);
		face4 = pieces.get(3);
		face5 = pieces.get(4);
		face6 = pieces.get(5);
	}

	public Piece getFace1() {
		return face1;
	}

	public void setFace1(Piece face1) {
		this.face1 = face1;
	}

	public Piece getFace2() {
		return face2;
	}

	public void setFace2(Piece face2) {
		this.face2 = face2;
	}

	public Piece getFace3() {
		return face3;
	}

	public void setFace3(Piece face3) {
		this.face3 = face3;
	}

	public Piece getFace4() {
		return face4;
	}

	public void setFace4(Piece face4) {
		this.face4 = face4;
	}

	public Piece getFace5() {
		return face5;
	}

	public void setFace5(Piece face5) {
		this.face5 = face5;
	}

	public Piece getFace6() {
		return face6;
	}

	public void setFace6(Piece face6) {
		this.face6 = face6;
	}

	public List<Piece> getFaces() {
		ArrayList<Piece> pieces = new ArrayList<>();

		pieces.add(face1);
		pieces.add(face2);
		pieces.add(face3);
		pieces.add(face4);
		pieces.add(face5);
		pieces.add(face6);

		return pieces;
	}

	public void switchFaces(Piece firstPiece, Piece secondPiece) {
		Piece temp = new Piece(firstPiece);
		firstPiece = secondPiece;
		secondPiece = temp;
	}

}
