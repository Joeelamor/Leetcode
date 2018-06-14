// Problem 220 Contains Duplicate III

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length < 2 || k < 1) return false;
        // In case that Integer.MAX_VALUE - Integer.MIN_VALUE
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long cur = (long) nums[i];
            Long floor = set.floor(cur);
            Long ceiling = set.ceiling(cur);
            if ((floor != null && cur - floor <= t) || (ceiling != null && ceiling - cur <= t))
                return true;
            set.add(cur);
            if (i >= k) {
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }
}