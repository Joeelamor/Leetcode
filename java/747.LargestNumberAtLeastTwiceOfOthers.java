// Problem 747 Largest Number At Least Twice Of Others

class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0, secondMax = 0, index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        return (secondMax == 0 || max / secondMax >= 2)? index : -1;
    }
}