// Problem 375 Guess Number Higher or Lower II

public class Solution {
    public int getMoneyAmount(int n) {
        int [][] table = new int[n+1][n+1];
        return DP(table, 1, n);
    }
    
    public int DP(int[][] table, int head, int tail) {
        if(head >= tail)
            return 0;
        if(table[head][tail] != 0)
            return table[head][tail];
        int res = Integer.MAX_VALUE;
        for(int x = head; x <= tail; x++) {
            int tmp = x + Math.max(DP(table, head, x - 1), DP(table, x + 1, tail));
            res = Math.min(res, tmp);
        }
        table[head][tail] = res;
        return res;
    }
}