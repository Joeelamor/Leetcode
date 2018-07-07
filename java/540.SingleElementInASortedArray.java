// Problem 540 Single Element In A Sorted Array

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length % 2 == 0) return 0;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid % 2 == 1) mid--; // make sure mid is even index;
            if (nums[mid] != nums[mid + 1]) // if nums[mid] != nums[mid + 1], single element must be on the left
                end = mid;
            else 
                start = mid + 2;
        }
        return nums[start];
    }
}