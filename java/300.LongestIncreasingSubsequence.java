// Problem 300 Longest Increasing Subsequence

// Method 1: O(n^2) time
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        int []dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
            }
        }
        int max = 0;
        for (int n : dp) {
            max = Math.max(max, n);
        }
        return max;
    }
}

// O(nlogn) time
class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = i + (j - i) / 2;
                if (nums[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            nums[i]= x;
            if (i == size) size++;
        }
        return size;
    }
}