// Problem 762 Prime Number Of Set Bits In Binary Representation

class Solution {
    public int countPrimeSetBits(int L, int R) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        int res = 0;
        for (int i = L; i <= R; i++) {
            int bits = 0;
            for (int n = i; n > 0; n >>= 1) {
                bits += n & 1;
            }
            res += set.contains(bits)? 1 : 0;
        }
        return res;
    }
}