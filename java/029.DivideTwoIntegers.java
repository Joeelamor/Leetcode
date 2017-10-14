// Problem 29 Divide Two Integers

class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        if (divisor == 0)
            return Integer.MAX_VALUE;
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        if ((newDividend < newDivisor) || newDividend == 0)
            return 0;
        long res = 0;
        while (newDividend >= newDivisor) {
            long tmp = newDivisor, i = 1;
            while (newDividend >= (tmp << 1)) {
                tmp <<= 1;
                i <<= 1;
            }
            newDividend -= tmp;
            res += i;
        }
        if (res > Integer.MAX_VALUE) {
            if (sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        } else {
            return sign * (int)res;
        }    
    }
}