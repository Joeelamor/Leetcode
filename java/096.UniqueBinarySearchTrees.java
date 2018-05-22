// Problem 96 Unique Binary Search Trees

// To build a tree, we need to pick a root node, then we need to know how many 
// possible left sub trees and right sub trees can be held under that node, finally multiply them.
// So first to find root, then find left and right child.
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}