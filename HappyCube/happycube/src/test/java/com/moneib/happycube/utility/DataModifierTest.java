package com.moneib.happycube.utility;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import com.moneib.happycube.entity.Piece;

public class DataModifierTest {

	@Test
	public void testSeparateInput() {
		char[][] input = new char[][] { { ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', ' ' },
				{ ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ', ' ', 'o', ' ', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ ' ', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', ' ' },
				{ 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o', 'o', ' ', 'o', 'o', 'o', 'o' },
				{ 'o', 'o', ' ', 'o', ' ', 'o', ' ', 'o', ' ', ' ', 'o', 'o', ' ', 'o', 'o' } };

		List<Piece> pieces = DataModifier.separateInput(input);

		assertEquals(6, pieces.size());

		assertArrayEquals(Arrays.copyOfRange(input[0], 0, 5), pieces.get(0).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[1], 0, 5), pieces.get(0).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[2], 0, 5), pieces.get(0).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[3], 0, 5), pieces.get(0).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[4], 0, 5), pieces.get(0).getStructure()[4]);

		assertArrayEquals(Arrays.copyOfRange(input[0], 5, 10), pieces.get(1).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[1], 5, 10), pieces.get(1).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[2], 5, 10), pieces.get(1).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[3], 5, 10), pieces.get(1).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[4], 5, 10), pieces.get(1).getStructure()[4]);

		assertArrayEquals(Arrays.copyOfRange(input[0], 10, 15), pieces.get(2).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[1], 10, 15), pieces.get(2).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[2], 10, 15), pieces.get(2).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[3], 10, 15), pieces.get(2).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[4], 10, 15), pieces.get(2).getStructure()[4]);

		assertArrayEquals(Arrays.copyOfRange(input[5], 0, 5), pieces.get(3).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[6], 0, 5), pieces.get(3).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[7], 0, 5), pieces.get(3).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[8], 0, 5), pieces.get(3).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[9], 0, 5), pieces.get(3).getStructure()[4]);

		assertArrayEquals(Arrays.copyOfRange(input[5], 5, 10), pieces.get(4).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[6], 5, 10), pieces.get(4).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[7], 5, 10), pieces.get(4).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[8], 5, 10), pieces.get(4).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[9], 5, 10), pieces.get(4).getStructure()[4]);

		assertArrayEquals(Arrays.copyOfRange(input[5], 10, 15), pieces.get(5).getStructure()[0]);
		assertArrayEquals(Arrays.copyOfRange(input[6], 10, 15), pieces.get(5).getStructure()[1]);
		assertArrayEquals(Arrays.copyOfRange(input[7], 10, 15), pieces.get(5).getStructure()[2]);
		assertArrayEquals(Arrays.copyOfRange(input[8], 10, 15), pieces.get(5).getStructure()[3]);
		assertArrayEquals(Arrays.copyOfRange(input[9], 10, 15), pieces.get(5).getStructure()[4]);
	}

	@Test
	public void tesReverseEdge() {
		assertArrayEquals(new char[] { 'o', 'o', ' ', ' ' },
				DataModifier.reverseEdge(new char[] { ' ', ' ', 'o', 'o' }));
	}

}
