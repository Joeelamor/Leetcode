import org.junit.Test;

import static org.junit.Assert.*;

public class LC89_GrayCodeTest {
    @Test
    public void grayCode() throws Exception {
        int test = 2;
        LC89_GrayCode solution = new LC89_GrayCode();

        assertEquals(new int []{0, 1, 3, 2}, solution.grayCode(test));
    }

}