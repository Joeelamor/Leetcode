// Climbing Stairs

// This is a fibonacci problem. And only consider that the nth step could be from
// (n-1)th step and (n-2)th step.

public class Solution {
    public int climbStairs(int n) {
        if(n <= 3)
            return n;
        int result[] = new int[n];
        result[0] = 1;
        result[1] = 2;
        for(int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }
}