// Problem 122 Best Time to Buy and Sell Stock II

// Just remember you may complete as many transactions as you like but you must 
// sell the stock before you buy again..
public class Solution {
    public int maxProfit(int[] prices) {
        int total = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            if(prices[i + 1] > prices[i])
                total = total + prices[i + 1] - prices[i];
        }
        return total;
    }
}