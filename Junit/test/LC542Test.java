import org.junit.Test;

import static org.junit.Assert.*;

public class LC542Test {

    @Test
    public void updateMatrix() {
        int[][] input = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] result = {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}};
        LC542 lc542 = new LC542();
        assertArrayEquals(result, lc542.updateMatrix(input));
    }
}