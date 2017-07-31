// Problem 342 Power of Four

/* Proof: (by induction) 4^(n+1) - 1 = 44^n -1 = 34^n + 4^n-1. The first is divided by 3,  
 * the second is proven by induction hypothesis */

public class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num - 1) % 3 == 0;
    }
}