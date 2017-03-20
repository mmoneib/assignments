import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestTopPhrases {

	@Test
	public void testSigleLineFile() {
		TopPhrases topPhrases = new TopPhrases("/home/mmoneib/git/assignments/WalletHub/tst/SingleLine");
		ArrayList<String> results = topPhrases.getTopPhrases(2);
		assertEquals(2, results.size());
		assertEquals("Apple", results.get(0));
		assertEquals("Blue", results.get(1));
	}

	@Test
	public void testEmptyFile() {
		TopPhrases topPhrases = new TopPhrases("/home/mmoneib/git/assignments/WalletHub/tst/Empty");
		ArrayList<String> results = topPhrases.getTopPhrases(2);
		assertEquals(0, results.size());
	}

	@Test
	public void testMultipleLinesFile() {
		TopPhrases topPhrases = new TopPhrases("/home/mmoneib/git/assignments/WalletHub/tst/MultipleLines");
		ArrayList<String> results = topPhrases.getTopPhrases(3);
		assertEquals(3, results.size());
		assertEquals("Dog", results.get(0));
		assertEquals("Cat", results.get(1));
		assertEquals("Apple", results.get(2));
	}

}
