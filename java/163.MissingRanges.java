// Problem 163 Missing Ranges

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res= new ArrayList<>();
        long start = lower;
        for (int i = 0; i <= nums.length; i++) {
            long end = i == nums.length? (long)upper + 1 : nums[i];
            if (end > start) {
                if (start + 1 == end) res.add(String.valueOf(start));
                else res.add(start + "->" + (end - 1));
            }
            start = end + 1;
        }
        return res;
    }
}