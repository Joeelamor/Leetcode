// Problem 377 Combination Sum IV

// this method is only for all positive numbers and no duplicates
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] ways = new int[target + 1];
        ways[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) ways[i] += ways[i - nums[j]];
            }
        }
        return ways[target];
    }
}