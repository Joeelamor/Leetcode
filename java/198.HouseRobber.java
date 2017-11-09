// Problem 198 House Robber

// Consider that at even and odd position, for even position, we compare the current 
// number plus last max even number with last max odd number. And for odd number,
// we have same comparison.

// Method 1:
public class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                a = Math.max(b, a + nums[i]);
            else
                b = Math.max(a, b + nums[i]);
        }
        return Math.max(a, b);
    }
}

// Method 2: DP
class Solution {
    public int rob(int[] nums) {
        int [][]dp = new int[nums.length + 1][2];
        for (int i = 1; i < nums.length + 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}