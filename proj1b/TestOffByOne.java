import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('d', 'c'));
        assertTrue(offByOne.equalChars('x', 'y'));

        assertFalse(offByOne.equalChars('x', 'x'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('c', 'e'));
    }

    @Test
    public void testCornerCases() {
        // From the spec clarification: non-alphabetical chars follow numeric
        // difference, the alphabet does not wrap around, and case matters.
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'B'));
    }
}
