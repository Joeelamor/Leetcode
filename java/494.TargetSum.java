// Problem 494 Target Sum

// Method 1: Use DFS
class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return count;
        helper(nums, S, 0, 0);
        return count;
    }
    public void helper(int[] nums, int S, int index, long sum) {
        if(index == nums.length) {
            if(sum == S)
                count++;
            return;
        }
        // If add '-' to current number in array, change S to S + nums[index].
        helper(nums, S + nums[index], index + 1, sum);
        // If add '+' to current number in array, change S to S - nums[index].
        helper(nums, S - nums[index], index + 1, sum);
    }
}

// Method 2: Use DP
// First need to know if sum(p) - sum(q) = S, then sum(p) - sum(q) + sum(all) = S + sum(all),
// then, we have 2 * sum(p) = S + sum(all), so, sum(p) = (S + sum(all)) / 2. We need to find 
// how many sum of subset is sum (p). 
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int n: nums)
            sum += n;
        // Check if it satisfies theory above.
        if(S > sum || (sum + S) % 2 == 1)   return 0;
        return subsetSum(nums, (sum + S) / 2);
    }

    private int subsetSum(int[] nums, int S){
        int[] dp = new int[S + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = S; j >= nums[i]; j--) {
            	// Record each number of index satisfies a part of sum.
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[S];
    }
}