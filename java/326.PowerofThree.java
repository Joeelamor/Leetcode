// Problem 326 Power of Three

// Method 1
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n > 1) {
            while(n % 3 == 0)
                n /= 3;
        }
        return n == 1;
    }
}

// Method 2
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n%3 == 0 && isPowerOfThree(n/3)));
    }
}