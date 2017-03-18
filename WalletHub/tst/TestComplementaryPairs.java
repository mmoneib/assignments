import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Test;

public class TestComplementaryPairs {

	@Test
	public void testEmptyArray() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] {}, 11);
		assertEquals(0, pairs.size());
	}

	@Test
	public void testSingleElementArray() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 5 }, 10);
		assertEquals(0, pairs.size());
		pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 6 }, 10);
		assertEquals(0, pairs.size());
	}

	@Test
	public void DoubleElementArrayWithMatch() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 5, 5 }, 10);
		assertEquals(2, pairs.size());
		ArrayList<Integer> tmpPair = new ArrayList<>();
		tmpPair.add(0);
		tmpPair.add(1);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(1);
		tmpPair.add(0);
		assertTrue(pairs.contains(tmpPair));
	}

	@Test
	public void DoubleElementArrayWithoutMatch() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 5, 6 }, 10);
		assertEquals(0, pairs.size());
		pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 6, 3 }, 10);
		assertEquals(0, pairs.size());
	}

	@Test
	public void multipleElementsArrayWithSinglePairMatch() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 1, 3, -1, -4, 3 }, -3);
		assertEquals(2, pairs.size());
		ArrayList<Integer> tmpPair = new ArrayList<>();
		tmpPair.add(0);
		tmpPair.add(3);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(3);
		tmpPair.add(0);
		assertTrue(pairs.contains(tmpPair));
	}

	@Test
	public void multipleElementsArrayWithMultiplePairMatch() {
		HashSet<ArrayList<Integer>> pairs = ComplementaryPairs.getComplementaryPairs(new int[] { 3, -1, 8, -6, 3 }, 2);
		assertEquals(6, pairs.size());
		ArrayList<Integer> tmpPair = new ArrayList<>();
		tmpPair.add(0);
		tmpPair.add(1);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(1);
		tmpPair.add(0);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(2);
		tmpPair.add(3);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(3);
		tmpPair.add(2);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(1);
		tmpPair.add(4);
		assertTrue(pairs.contains(tmpPair));
		tmpPair = new ArrayList<>();
		tmpPair.add(4);
		tmpPair.add(1);
		assertTrue(pairs.contains(tmpPair));
	}

}
