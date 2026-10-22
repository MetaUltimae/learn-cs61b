/**
 *
 * @author 33465
 * @created 2026/10/22 21:57
 * @desciption off-by-1 comparators
 *
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == 1 || x - y == -1;
    }
}
   