// Problem 152 Maximum Product Subarray

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0 || nums == null)
            return 0;
        int max = nums[0], min = nums[0], result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int tmp = max;
            // Need to record max and min at the same time, because two product 
            // of negative numbers is positive.
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(tmp * nums[i], min * nums[i]), nums[i]);
            if(max > result)
                result = max;
        }
        return result;        
    }
}