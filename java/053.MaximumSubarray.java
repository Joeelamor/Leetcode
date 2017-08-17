// Problem 53 Maximum Subarray

/* Use Kadane's algorithm */

public class Solution {
    public int maxSubArray(int[] nums) {
        int maxCur = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxCur = Math.max(nums[i], maxCur + nums[i]);
            maxSum = Math.max(maxSum, maxCur);
        }
        return maxSum;
    }
}