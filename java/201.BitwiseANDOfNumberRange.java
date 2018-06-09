// Problem 201 Bitwise AND of Number Range

// Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) return 0;
        int count = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            count++;
        }
        return m << count;
    }
}