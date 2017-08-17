// Problem 349 Intersection of Two Arrays

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                res.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int [] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num;
        }
        return result;
    }
}