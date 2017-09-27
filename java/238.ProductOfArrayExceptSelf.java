// Problem 238 Product Of Array Except Self

/* In this problem, we can not use divide, because the number in array may be zero. */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []res = new int[nums.length];
        res[0] = 1;
        // Use an array to record all product of numbers before each index.
        for(int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        // Reversely traverse the array to calculate the result.
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}