// Problem 202 Happy Number

// This solution use Floyd Cycle detection algorithm.
public class Solution {
    public boolean isHappy(int n) {
        int a = n, b = n;
        while(a > 1) {
            a = sum(a);
            b = sum(sum(b));
            if(a == 1)
                return true;
            if(b == 1)
                return true;
            if(a == b)
                return false;
        }
        return true;
    }
    public int sum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}