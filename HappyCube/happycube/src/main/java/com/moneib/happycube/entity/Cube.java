package com.moneib.happycube.entity;

import java.util.ArrayList;
import java.util.List;

import com.moneib.happycube.utility.Printable;

public class Cube implements Printable {
	private List<Piece> pieces = new ArrayList<>();

	public Cube(Piece face1, Piece face2, Piece face3, Piece face4, Piece face5, Piece face6) {
		pieces.add(face1);
		pieces.add(face2);
		pieces.add(face3);
		pieces.add(face4);
		pieces.add(face5);
		pieces.add(face6);
	}

	public Cube(List<Piece> pieces) {
		this.pieces = pieces;
	}

	public Piece getFace1() {
		return pieces.get(0);
	}

	public void setFace1(Piece face1) {
		pieces.set(0, face1);
	}

	public Piece getFace2() {
		return pieces.get(1);
	}

	public void setFace2(Piece face2) {
		pieces.set(1, face2);
	}

	public Piece getFace3() {
		return pieces.get(2);
	}

	public void setFace3(Piece face3) {
		pieces.set(2, face3);
	}

	public Piece getFace4() {
		return pieces.get(3);
	}

	public void setFace4(Piece face4) {
		pieces.set(3, face4);
	}

	public Piece getFace5() {
		return pieces.get(4);
	}

	public void setFace5(Piece face5) {
		pieces.set(4, face5);
	}

	public Piece getFace6() {
		return pieces.get(5);
	}

	public void setFace6(Piece face6) {
		pieces.set(5, face6);
	}

	public List<Piece> getFaces() {

		return pieces;
	}

	public void switchFaces(Piece firstPiece, Piece secondPiece) {
		Piece temp = new Piece(firstPiece);
		firstPiece = secondPiece;
		secondPiece = temp;
	}

	@Override
	public void print() {

		System.out.print(getFace5().getStructure()[0]);
		System.out.print(getFace2().getStructure()[0]);
		System.out.println(getFace6().getStructure()[0]);
		System.out.print(getFace5().getStructure()[1]);
		System.out.print(getFace2().getStructure()[1]);
		System.out.println(getFace6().getStructure()[1]);
		System.out.print(getFace5().getStructure()[2]);
		System.out.print(getFace2().getStructure()[2]);
		System.out.println(getFace6().getStructure()[2]);
		System.out.print(getFace5().getStructure()[3]);
		System.out.print(getFace2().getStructure()[3]);
		System.out.println(getFace6().getStructure()[3]);
		System.out.print(getFace5().getStructure()[4]);
		System.out.print(getFace2().getStructure()[4]);
		System.out.println(getFace6().getStructure()[4]);

		System.out.print("     ");
		System.out.println(getFace3().getStructure()[0]);
		System.out.print("     ");
		System.out.println(getFace3().getStructure()[1]);
		System.out.print("     ");
		System.out.println(getFace3().getStructure()[2]);
		System.out.print("     ");
		System.out.println(getFace3().getStructure()[3]);
		System.out.print("     ");
		System.out.println(getFace3().getStructure()[4]);

		System.out.print("     ");
		System.out.println(getFace4().getStructure()[0]);
		System.out.print("     ");
		System.out.println(getFace4().getStructure()[1]);
		System.out.print("     ");
		System.out.println(getFace4().getStructure()[2]);
		System.out.print("     ");
		System.out.println(getFace4().getStructure()[3]);
		System.out.print("     ");
		System.out.println(getFace4().getStructure()[4]);

		System.out.print("     ");
		System.out.println(getFace1().getStructure()[0]);
		System.out.print("     ");
		System.out.println(getFace1().getStructure()[1]);
		System.out.print("     ");
		System.out.println(getFace1().getStructure()[2]);
		System.out.print("     ");
		System.out.println(getFace1().getStructure()[3]);
		System.out.print("     ");
		System.out.println(getFace1().getStructure()[4]);
	}

}
