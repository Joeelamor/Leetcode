// Problem 441 Arranging Coins

// Method 1:
public class Solution {
    public int arrangeCoins(int n) {
        if(n <= 0)
            return n;
        int i = 1, count = 0;
        while(n >= i) {
            count++;
            n -= i;
            i++;            
        }
        return count;
    }
}

// Method 2: Mathematic method
public class Solution {
    public int arrangeCoins(int n) {
        return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }
}