package com.moneib.happycube.rule;

import com.moneib.happycube.entity.Cube;
import com.moneib.happycube.entity.Piece;
import com.moneib.happycube.utility.DataModifier;

/**
 * The Class FitRule implements the rule of fitting of the pieces of the
 * {@code Cube} under modification. This ensures that the physics of fitting are
 * respected in the construction of the cube out of the pieces, such as in a
 * Happy Cube.
 */
public class FitRule extends AbstractRule {

	/** The singleton instance of FitRule. */
	private static final FitRule FIT_RULE = new FitRule();

	/**
	 * Private constructor to enforce the singleton pattern.
	 */
	private FitRule() {
	}

	/**
	 * Gets the singleton of FitRule.
	 *
	 * @return single instance of FitRule
	 */
	public static FitRule getInstance() {
		return FIT_RULE;
	}

	/**
	 * Check the validity of the specified {@link Cube} through the rules of
	 * fitting as it disallows the overlapping of teeth of a {@code Piece} in a
	 * specific position on the sides of the cube.
	 * 
	 * This method calls 2 more methods: {@link #checkCorner(char, char, char)}
	 * to make sure no collission occurs in any of the cube's 6 corners, and
	 * {@code #checkEdges(Cube) to make sure no collision happens in any of the 12 edges.}
	 */
	@Override
	public boolean check(Cube cube) {
		return checkCorners(cube) && checkEdges(cube);
	}

	/**
	 * Check corners of the cube for any collision of teeth of the pieces.
	 *
	 * @param cube
	 *            the cube being validated.
	 * @return true, if no collision occurs in any of the corners.
	 */
	private boolean checkCorners(Cube cube) {

		return checkCorner(cube.getFace1().getSouth()[0], cube.getFace2().getNorth()[0], cube.getFace5().getEast()[0])
				&& checkCorner(cube.getFace1().getSouth()[4], cube.getFace2().getNorth()[4],
						cube.getFace6().getWest()[0])
				&& checkCorner(cube.getFace2().getSouth()[0], cube.getFace3().getNorth()[0],
						cube.getFace5().getEast()[4])
				&& checkCorner(cube.getFace2().getSouth()[4], cube.getFace3().getNorth()[4],
						cube.getFace6().getWest()[4])
				&& checkCorner(cube.getFace3().getSouth()[0], cube.getFace4().getNorth()[0],
						cube.getFace5().getWest()[4])
				&& checkCorner(cube.getFace3().getSouth()[4], cube.getFace4().getNorth()[4],
						cube.getFace6().getEast()[4])
				&& checkCorner(cube.getFace4().getSouth()[0], cube.getFace1().getNorth()[0],
						cube.getFace5().getWest()[0])
				&& checkCorner(cube.getFace4().getSouth()[4], cube.getFace1().getNorth()[4],
						cube.getFace6().getEast()[0]);
	}

	/**
	 * Check edges of the cube for any collision of teeth of the pieces.
	 *
	 * @param cube
	 *            the cube being validated.
	 * @return true, if no collision occurs in any of the edges.
	 */
	private boolean checkEdges(Cube cube) {

		return checkEdge(cube.getFace1().getSouth(), cube.getFace2().getNorth())
				&& checkEdge(cube.getFace2().getSouth(), cube.getFace3().getNorth())
				&& checkEdge(cube.getFace3().getSouth(), cube.getFace4().getNorth())
				&& checkEdge(cube.getFace4().getSouth(), cube.getFace1().getNorth())
				&& checkEdge(cube.getFace1().getWest(), cube.getFace5().getNorth())
				&& checkEdge(cube.getFace1().getEast(),
						DataModifier.reverseEdge(cube.getFace6().getNorth()))
				&& checkEdge(cube.getFace2().getWest(), cube.getFace5().getEast())
				&& checkEdge(cube.getFace2().getEast(), cube.getFace6().getWest())
				&& checkEdge(cube.getFace3().getWest(),
						DataModifier.reverseEdge(cube.getFace5().getSouth()))
				&& checkEdge(cube.getFace3().getEast(), cube.getFace6().getSouth())
				&& checkEdge(cube.getFace4().getWest(),
						DataModifier.reverseEdge(cube.getFace5().getWest()))
				&& checkEdge(cube.getFace4().getEast(),
						DataModifier.reverseEdge(cube.getFace6().getEast()));
	}

	/**
	 * Check if there's more than, or less than, one tooth in the specified
	 * corner. The corner is specified by the positions of the 3 input character
	 * with respect to the structure of the {@link Piece}.
	 *
	 * @param c1
	 *            the first character in the corner.
	 * @param c2
	 *            the second character in the corner.
	 * @param c3
	 *            the thrid character in the corner.
	 * @return true, if no collision is found.
	 */
	private boolean checkCorner(char c1, char c2, char c3) {
		int count = 0;

		if (c1 == 'o')
			count++;
		if (c2 == 'o')
			count++;
		if (c3 == 'o')
			count++;

		return count == 1 ? true : false;
	}

	/**
	 * Check the edge for any collision of the teeth of the sides involved of
	 * the 2 pieces comprising the edge as specified in the structure of each
	 * {@link Piece}.
	 *
	 * @param e1
	 *            the representation of the first edge (from one piece).
	 * @param e2
	 *            the representation of the second edge (from another piece).
	 * @return true, if no collision is found.
	 */
	private boolean checkEdge(char[] e1, char[] e2) {

		for (int i = 1; i < e1.length - 1; i++)
			if (e1[i] == e2[i])
				return false;

		return true;
	}
}
