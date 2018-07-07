// Problem 334 Increasing Triplet Subsequence

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) small = num;
            else if (num <= big) big = num;
            else return true;
        }
        return false;
    }
}