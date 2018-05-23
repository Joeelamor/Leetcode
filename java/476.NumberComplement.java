// Problem 476 Number Complement

class Solution {
    public int findComplement(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}