// Problem 309 Best Time To Buy And Sell Stock With Cooldown

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];
        rest[0] = 0;
        sell[0] = 0;
        buy[0] = prices[0] * -1;
        for (int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(rest[i - 1] - prices[i], buy[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            rest[i] = sell[i - 1];
        }
        return Math.max(rest[prices.length - 1], sell[prices.length - 1]);
    }
}