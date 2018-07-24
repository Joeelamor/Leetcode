// Problem 371 Sum Of Two Integers

class Solution {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b; // handle 1 + 0 and 0 + 1
        int carry = (a & b) << 1; // handle 1 + 1
        return getSum(sum, carry);
    }
}