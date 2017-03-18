import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalindrome {

	@Test
	public void testEmptyString() {
		assertTrue(Palindrome.isPalindrome(""));
	}
	
	@Test
	public void testSingleCharacterPalindrome() {
		assertTrue(Palindrome.isPalindrome("A"));
	}
	
	@Test
	public void testDoubleCharacterPalindrome() {
		assertTrue(Palindrome.isPalindrome("AA"));
	}
	
	@Test
	public void testTripleCharacterPalindrome() {
		assertTrue(Palindrome.isPalindrome("aBa"));
	}
	
	@Test
	public void testQuadrableCharacterPalindrome() {
		assertTrue(Palindrome.isPalindrome("aBBa"));
	}
	
	@Test
	public void testLongOddPalindrome() {
		assertTrue(Palindrome.isPalindrome("aBx10x01xBa"));
	}
	
	@Test
	public void testLongEvenPalindrome() {
		assertTrue(Palindrome.isPalindrome("aBx10xx01xBa"));
	}
	
	@Test
	public void testNotAPalindrome() {
		assertFalse(Palindrome.isPalindrome("aBx10ax01xBa"));
	}

}
