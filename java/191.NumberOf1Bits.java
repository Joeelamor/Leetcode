// Problem 191 Number of 1 Bits

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        // Right shift the number by i to get the LSB value.
        for (int i = 0; i < 32; i++) {
            count += (n >> i & 1) == 1? 1 : 0;
        }
        return count;
    }
}