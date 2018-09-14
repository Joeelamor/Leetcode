// Question 260 Single Number III

class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        diff &= -diff; // find the rightmost 1;
        int res[] = {0, 0};
        for (int i : nums) {
            if ((diff & i) == 0) {
                res[0] ^= i;
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }
}