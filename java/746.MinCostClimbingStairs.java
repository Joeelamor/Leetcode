// Problem 746 Min Cost Climbing Stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] res = new int[cost.length + 1];
        res[0] = cost[0];
        res[1] = cost[1];
        for (int i = 2; i <= cost.length; i++) {
            int cur = (i == cost.length? 0: cost[i]);
            res[i] = Math.min(res[i - 1], res[i -2]) + cur;
        }
        return res[cost.length];
    }
}