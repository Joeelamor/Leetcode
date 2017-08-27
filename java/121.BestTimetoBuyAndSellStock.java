// Problem 121 Best Time to Buy and Sell Stock

// Also Kadane's algorithm
public class Solution {
    public int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur = maxCur + prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
    }
}

// New method
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int max = 0, buy = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > buy)
                max = Math.max(max, prices[i] - buy);
            else
                buy = prices[i];
        }
        return max;
    }
}