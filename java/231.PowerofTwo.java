// Problem 231 Power of Two

// Method 1: Iterative
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0)
            return false;
        while(n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }
}

// Method 2: Recursive
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && (n==1 || (n%2==0 && isPowerOfTwo(n/2)));
    }
}

// Method 3: Bit operation
// Power of 2 means only one bit of n is '1', so use the trick n&(n-1)==0 to judge whether that is the case
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && ((n & (n-1)) == 0);
    }
}

// Method 4: Using bit Count
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}