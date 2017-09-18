import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LC78_SubsetsTest {
    @Test
    public void subsets() throws Exception {
        int [] nums = {1, 2, 3};
        LC78_Subsets solution = new LC78_Subsets();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>(Arrays.asList(1)));
        list.add(new ArrayList<>(Arrays.asList(1,2)));
        list.add(new ArrayList<>(Arrays.asList(1,2,3)));
        list.add(new ArrayList<>(Arrays.asList(1,3)));
        list.add(new ArrayList<>(Arrays.asList(2)));
        list.add(new ArrayList<>(Arrays.asList(2,3)));
        list.add(new ArrayList<>(Arrays.asList(3)));

        assertEquals(list, solution.subsets(nums));
    }

}