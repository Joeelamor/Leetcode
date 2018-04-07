// Problem 209 Minimum Size Subarray Sum

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 0, sum = 0, res = Integer.MAX_VALUE;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= s) {
                res = Math.min(res, i - j + 1);
                sum -= nums[j];
                j++;
            }
            i++;
        }
        return res == Integer.MAX_VALUE? 0 : res;
    }
}