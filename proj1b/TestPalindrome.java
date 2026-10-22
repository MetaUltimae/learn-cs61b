import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(palindrome.isPalindrome("is"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("aaadeaa"));
    }

    @Test
    public void testNullPalindrome() {
        assertFalse(palindrome.isPalindrome(null));
    }

    @Test
    public void testEmptyPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testIsPalindromeByOffByOne() {
        assertTrue(palindrome.isPalindrome("a", new OffByOne()));
        assertTrue(palindrome.isPalindrome("acb", new OffByOne()));
        assertTrue(palindrome.isPalindrome("AaB", new OffByOne()));

        assertFalse(palindrome.isPalindrome("is", new OffByOne()));
        assertFalse(palindrome.isPalindrome("accb", new OffByOne()));
        assertFalse(palindrome.isPalindrome("noon", new OffByOne()));
        assertFalse(palindrome.isPalindrome("aA", new OffByOne()));
        assertFalse(palindrome.isPalindrome("superhero", new OffByOne()));

    }
}
