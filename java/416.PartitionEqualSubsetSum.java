// Question 416 Partition Equal Subset Sum

class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0)
            return true;
        int sum = 0;
        for (int num : nums)
            sum += num;
        if (sum % 2 != 0)
            return false;
        int subSum = sum / 2;
        boolean[] dp = new boolean[subSum + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = subSum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[subSum];
    }
}
