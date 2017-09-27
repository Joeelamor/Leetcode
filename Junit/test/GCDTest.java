import org.junit.Test;

import static org.junit.Assert.*;

public class GCDTest {
    @Test
    public void solution() throws Exception {
        int []test = {24, 16};
        GCD solution = new GCD();
        assertEquals(8, solution.Solution(test));
    }

}