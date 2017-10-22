// Problem 713 Subarray Product Less Than K

// Just avoid overstepping the boundary
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
            if (product < k)
                count++;
            for (int j = i + 1; j < nums.length; j++) {
                product *= nums[j];
                if (product < k)
                    count++;
                else
                    break;
            }
        }
        return count;
    }
}