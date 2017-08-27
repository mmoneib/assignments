package com.moneib.happycube.utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.moneib.happycube.entity.Piece;

/**
 * The Class DataModifier is a utility class providing methods to manipulate
 * data.
 */
public class DataModifier {

	/**
	 * Separate the input combined representation of pieces into 6 distinct
	 * structures.
	 *
	 * @param allPieces
	 *            combined representation of all the pieces.
	 * @return the list of 6 pieces.
	 */
	public static List<Piece> separateInput(char[][] allPieces) {
		ArrayList<Piece> pieces = new ArrayList<>();

		char[][] firstPiece = new char[5][5];
		char[][] secondPiece = new char[5][5];
		char[][] thirdPiece = new char[5][5];
		char[][] fourthPiece = new char[5][5];
		char[][] fifthPiece = new char[5][5];
		char[][] sixthPiece = new char[5][5];

		for (int i = 0; i < 5; i++) {
			firstPiece[i] = Arrays.copyOfRange(allPieces[i], 0, 5);
			secondPiece[i] = Arrays.copyOfRange(allPieces[i], 5, 10);
			thirdPiece[i] = Arrays.copyOfRange(allPieces[i], 10, 15);
		}

		for (int i = 5; i < 10; i++) {
			fourthPiece[i - 5] = Arrays.copyOfRange(allPieces[i], 0, 5);
			fifthPiece[i - 5] = Arrays.copyOfRange(allPieces[i], 5, 10);
			sixthPiece[i - 5] = Arrays.copyOfRange(allPieces[i], 10, 15);
		}

		pieces.add(new Piece(firstPiece));
		pieces.add(new Piece(secondPiece));
		pieces.add(new Piece(thirdPiece));
		pieces.add(new Piece(fourthPiece));
		pieces.add(new Piece(fifthPiece));
		pieces.add(new Piece(sixthPiece));

		return pieces;
	}

	/**
	 * Reverse a representation of an edge of a piece. This, in fact, is just a
	 * reverser of an array, since Java does not provide a ready-made reverser.
	 *
	 * @param edge
	 *            the original edge.
	 * @return the reversed edge.
	 */
	public static char[] reverseEdge(char[] edge) {
		char[] reversedEdge = new char[edge.length];

		for (int i = 0, j = edge.length - 1; i < edge.length && j >= 0; i++, j--) {
			reversedEdge[i] = edge[j];
		}

		return reversedEdge;
	}

}
