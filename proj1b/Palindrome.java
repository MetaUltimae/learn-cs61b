/**
 *
 * @author 33465
 * @created 2026/10/22 21:56
 * @desciption palindrome operations
 *
 */
public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            d.addLast(c);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        // 0.check nullPoint
        if (word == null) {
            return false;
        }
        // 1.word to deque
        Deque<Character> charD = wordToDeque(word);
        // 2.deque to recursion
        return isPalindromeHelper(charD, (x, y) -> x == y);
    }

    private boolean isPalindromeHelper(Deque<Character> charD,CharacterComparator cc) {
        if (charD.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(charD.removeFirst(), charD.removeLast())) {
            return false;
        }
        return isPalindromeHelper(charD, cc);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        Deque<Character> charD = wordToDeque(word);
        return isPalindromeHelper(charD, cc);
    }

}
   