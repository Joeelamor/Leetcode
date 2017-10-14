// Problem 81 Search In Rotated Sorted Array II

// If there will be repeated numbers in array, just split it into two parts, then consider all edge cases.
class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[left] || nums[mid] < nums[right]) {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else
                    right = mid - 1;
            }
            else if (nums[mid] > nums[left] || nums[mid] > nums[right]) {
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else
                    left = mid + 1;
            } else
                right--;
        }
        return false;
    }
}