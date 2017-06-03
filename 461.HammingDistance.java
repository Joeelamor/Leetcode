// Problem 461 Hamming Distance

// Use Integer.bitCount() method
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}


// Or use bit manipulation

public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y, count = 0;
        while(n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}


// the naive way bit manipulation
public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y, count = 0;
        for(int i = 0; i < 32; i++){
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}


// the optimal naive way
public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y, count = 0;
        while(n != 0) {
        	count += n & 1;
        	n >>= 1;
        }
        return count;
    }
}