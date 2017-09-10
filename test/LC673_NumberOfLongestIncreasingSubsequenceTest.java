import org.junit.Test;

import static org.junit.Assert.*;

public class LC673_NumberOfLongestIncreasingSubsequenceTest {
    @Test
    public void findNumberOfLIS() throws Exception {
        int []input = new int[]{1, 2, 4, 3, 5, 4, 7, 2};
        LC673_NumberOfLongestIncreasingSubsequence solution = new LC673_NumberOfLongestIncreasingSubsequence();

        assertEquals(4, solution.findNumberOfLIS(input));
    }
}