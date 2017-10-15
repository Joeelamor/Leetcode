import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class LC_697Test {
    @Test
    public void findShortestSubArray() throws Exception {
        int []test = {1,2,2,3,1,4,2};
        LC_697 lc_697 = new LC_697();
        assertEquals(6, lc_697.findShortestSubArray(test));
    }

}