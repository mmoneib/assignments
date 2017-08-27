package com.moneib.happycube.entity;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.moneib.happycube.rule.AbstractRule;
import com.moneib.happycube.utility.Printable;

/**
 * The Class Cube is a hypothetical representation of a cube which is composed
 * of 6 pieces represented by the type {@link Piece} and whose pieces can be
 * fitted together like a puzzle. <br>
 * <br>
 * <b>This class, per se, does not provide a mechanism of validating that the
 * pieces fit together</b>, hence it can be used to represent a collection of
 * pieces arranged as a cube, but which would not produce a physical one. Such
 * validation can be done using a {@link AbstractRule rule}. <br>
 * <br>
 * The representation follows the following pieces (indicated by their numbers)
 * placement, taking into consideration that each piece has northern, southern,
 * eastern, and western edges as perceived by the viewer of the diagram of the
 * unfolded cube: <br>
 * 
 * <pre>
 *    [1]
 * [5][2][6]
 *    [3]
 *    [4]
 * </pre>
 */
public class Cube extends AbstractEntity implements Printable {

	/** The pieces which compries the cube. */
	private List<Piece> pieces = new ArrayList<>();

	/**
	 * Instantiates a new, empty cube. This is meant only to be used by
	 * extending classes.
	 */
	protected Cube() {
	}

	/**
	 * Instantiates a new cube from 6 pieces, each individually available.
	 *
	 * @param face1
	 *            the first piece.
	 * @param face2
	 *            the second piece.
	 * @param face3
	 *            the third piece.
	 * @param face4
	 *            the fourth piece.
	 * @param face5
	 *            the fifth piece.
	 * @param face6
	 *            the sixth piece.
	 */
	public Cube(Piece face1, Piece face2, Piece face3, Piece face4, Piece face5, Piece face6) {
		pieces.add(face1);
		pieces.add(face2);
		pieces.add(face3);
		pieces.add(face4);
		pieces.add(face5);
		pieces.add(face6);
	}

	/**
	 * Instantiates a new cube from a list of 6 pieces. Each piece is designated
	 * the number of it index + 1.
	 * 
	 * @param pieces
	 *            the list of pieces comprising the cube.
	 */
	public Cube(List<Piece> pieces) {
		if (pieces.size() != 6) {
			throw new IllegalArgumentException("Illegal number of pieces for a cube.");
		}
		this.pieces = pieces;
	}

	/**
	 * Gets piece 1 as specified in the cube diagram.
	 *
	 * @return the first piece.
	 */
	public Piece getFace1() {
		return pieces.get(0);
	}

	/**
	 * Sets piece 1 as specified in the cube diagram.
	 *
	 * @param face1
	 *            the new first peice.
	 */
	public void setFace1(Piece face1) {
		pieces.set(0, face1);
	}

	/**
	 * Gets piece 2 as specified in the cube diagram.
	 *
	 * @return the second piece.
	 */
	public Piece getFace2() {
		return pieces.get(1);
	}

	/**
	 * Sets piece 2 as specified in the cube diagram.
	 *
	 * @param face2
	 *            the new second piece.
	 */
	public void setFace2(Piece face2) {
		pieces.set(1, face2);
	}

	/**
	 * Gets piece 3 as specified in the cube diagram.
	 *
	 * @return the third piece.
	 */
	public Piece getFace3() {
		return pieces.get(2);
	}

	/**
	 * Sets piece 3 as specified in the cube diagram.
	 *
	 * @param face3
	 *            the new third piece.
	 */
	public void setFace3(Piece face3) {
		pieces.set(2, face3);
	}

	/**
	 * Gets piece 4 as specified in the cube diagram.
	 *
	 * @return the fourth piece.
	 */
	public Piece getFace4() {
		return pieces.get(3);
	}

	/**
	 * Sets piece 4 as specified in the cube diagram.
	 *
	 * @param face4
	 *            the new fourth piece.
	 */
	public void setFace4(Piece face4) {
		pieces.set(3, face4);
	}

	/**
	 * Gets piece 5 as specified in the cube diagram.
	 *
	 * @return the fifth piece.
	 */
	public Piece getFace5() {
		return pieces.get(4);
	}

	/**
	 * Sets piece 5 as specified in the cube diagram.
	 *
	 * @param face5
	 *            the new fifth piece.
	 */
	public void setFace5(Piece face5) {
		pieces.set(4, face5);
	}

	/**
	 * Gets piece 6 as specified in the cube diagram.
	 *
	 * @return the sixth piece.
	 */
	public Piece getFace6() {
		return pieces.get(5);
	}

	/**
	 * Sets piece 6 as specified in the cube diagram.
	 *
	 * @param face6
	 *            the new sixth piece.
	 */
	public void setFace6(Piece face6) {
		pieces.set(5, face6);
	}

	/**
	 * Gets the pieces of the cube in a list with the positions specifying the
	 * designated number of the piece -1.
	 *
	 * @return the pieces in ordered list.
	 */
	public List<Piece> getFaces() {

		return pieces;
	}

	/**
	 * Prints the cube unfolded in a T-shape with the pieces ordered as
	 * specified in the following diagram:<br>
	 * 
	 * <pre>
	 * [5][2][6]
	 *    [3]
	 *    [4]
	 *    [1]
	 * </pre>
	 */
	@Override
	public void print(PrintWriter writer) {

		writer.print(getFace5().getStructure()[0]);
		writer.print(getFace2().getStructure()[0]);
		writer.println(getFace6().getStructure()[0]);
		writer.print(getFace5().getStructure()[1]);
		writer.print(getFace2().getStructure()[1]);
		writer.println(getFace6().getStructure()[1]);
		writer.print(getFace5().getStructure()[2]);
		writer.print(getFace2().getStructure()[2]);
		writer.println(getFace6().getStructure()[2]);
		writer.print(getFace5().getStructure()[3]);
		writer.print(getFace2().getStructure()[3]);
		writer.println(getFace6().getStructure()[3]);
		writer.print(getFace5().getStructure()[4]);
		writer.print(getFace2().getStructure()[4]);
		writer.println(getFace6().getStructure()[4]);

		writer.print("     ");
		writer.println(getFace3().getStructure()[0]);
		writer.print("     ");
		writer.println(getFace3().getStructure()[1]);
		writer.print("     ");
		writer.println(getFace3().getStructure()[2]);
		writer.print("     ");
		writer.println(getFace3().getStructure()[3]);
		writer.print("     ");
		writer.println(getFace3().getStructure()[4]);

		writer.print("     ");
		writer.println(getFace4().getStructure()[0]);
		writer.print("     ");
		writer.println(getFace4().getStructure()[1]);
		writer.print("     ");
		writer.println(getFace4().getStructure()[2]);
		writer.print("     ");
		writer.println(getFace4().getStructure()[3]);
		writer.print("     ");
		writer.println(getFace4().getStructure()[4]);

		writer.print("     ");
		writer.println(getFace1().getStructure()[0]);
		writer.print("     ");
		writer.println(getFace1().getStructure()[1]);
		writer.print("     ");
		writer.println(getFace1().getStructure()[2]);
		writer.print("     ");
		writer.println(getFace1().getStructure()[3]);
		writer.print("     ");
		writer.println(getFace1().getStructure()[4]);
		writer.flush();
	}

	/**
	 * Equates 2 cubes based on the pieces comprising them, their order, and
	 * their orientation. If all is equal, then they are equal.
	 */
	@Override
	public boolean equals(Object cube) {
		if (this.pieces.equals(((Cube) cube).getFace6()))
			return true;
		else
			return false;
	}

}
