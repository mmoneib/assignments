
public class Palindrome {

	public static boolean isPalindrome(String text) {
		for (int i = 0, j = text.length() - 1; i <= j; i++, j--) {
			if (text.charAt(i) != text.charAt(j)) {
				return false;
			}
		}
		return true;
	}
}
