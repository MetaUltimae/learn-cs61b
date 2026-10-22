/**
 *
 * @author 33465
 * @created 2026/10/22 21:58
 * @desciption off-by-N comparators
 *
 */
public class OffByN implements CharacterComparator {
    private final int N;

    public OffByN(int N) {
        this.N = N;
    }
    @Override
    public boolean equalChars(char x, char y) {
        return x - y == N || x - y == -N;
    }
}
   