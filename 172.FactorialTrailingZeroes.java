// Problem 172 Factorial Trailing Zeroes

// Just find how many '5' in this number
public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while(n > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }
}