import org.junit.Test;

import static org.junit.Assert.*;

public class LC239_SlidingWindowMaximumTest {
    @Test
    public void maxSlidingWindow() throws Exception {
        int[] test = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        LC239_SlidingWindowMaximum solution = new LC239_SlidingWindowMaximum();
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, solution.maxSlidingWindow(test, k));
    }

}