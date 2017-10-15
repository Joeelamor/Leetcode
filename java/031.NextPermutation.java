// Problem 31 Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        // First find the index that breaks descending order.
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        // If not entirely descending, just swap two numbers in array.
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        // If entirely descending, reverse the sequence.
        reverse(nums, i + 1, nums.length - 1);
        
    }
    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}