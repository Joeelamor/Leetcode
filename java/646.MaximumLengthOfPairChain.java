// Problem 646 Maximum Length Of Pair Chain

/* I use DP to solve this problem, first thing is sorting the pairs array with the 
 * ascending order using first number in each pair. And then, dp[i] keep the maximum length 
 * until index i.
 */

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int []dp = new int[pairs.length];
        for(int i = 0; i < pairs.length; i++) {
            dp[i] = 1;
        }
        for(int j = 1; j < pairs.length; j++) {
            for(int k = 0; k < j; k++) {
                if(pairs[j][0] - pairs[k][1] > 0 && dp[j] < dp[k] + 1) {
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                }
            }
        }
        return dp[pairs.length - 1];
    }
}