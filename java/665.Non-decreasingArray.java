// Problem 665 Non-decreasing Array

class Solution {
    public boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
                // if nums[i - 2] <= nums[i], then set nums[i - 1] = nums[i];
                if (i - 2 < 0 || nums[i - 2] <= nums[i])
                    nums[i - 1] = nums[i];
                else
                	// if nums[i - 2] > nums[i], then set nums[i] = nums[i - 1];
                    nums[i] = nums[i - 1];
            }
        }
        return count <= 1;
    }
}