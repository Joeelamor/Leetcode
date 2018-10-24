// Problem 29 Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int res = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= (b << shift)) {
                shift++;
            }
            res += 1 << (shift - 1);
            a -= b <<(shift - 1);
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) 
            return res;
        else 
            return -res;
    }
}