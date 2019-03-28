// Question 1012 Complement of Base 10 Integer

// N + bitwiseComplement(N) = 111....11111
class Solution {
    public int bitwiseComplement(int N) {
        int res = 1;
        while (res < N) {
            res <<= 1;
            res += 1;
        }
        return res - N;
    }
}