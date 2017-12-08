import java.util.*;

public class Deduplicate {
    private static List<Integer> DeduplicateArray(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            res.add(i);
        }
        for (int num : nums) {
            res.remove(num);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        List<Integer> res;
        res = DeduplicateArray(nums1);
        System.out.println(res);
    }
}
