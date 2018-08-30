// Question 41 First Missing Positive

class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length)
                i++;
            else if (nums[i] != nums[nums[i] - 1])
                swap(nums, i, nums[i] - 1);
            else 
                i++;
        }
        i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) 
                return i + 1;
            i++;
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}