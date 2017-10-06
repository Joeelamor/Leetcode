// Problem 50 Pow(x, n)

// The only thing is you need to consider the edge case, including x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE
class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || x > Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        if (n == 0)
            return 1;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2); 
    }
}