// Problem 81 Search In Rotated Sorted Array II

// If there will be repeated numbers in array, just split it into two parts, then consider all edge cases.
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
          return false;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return true;
            if ((nums[left] == nums[mid]) && (nums[right] == nums[mid])) {
                ++left; 
                --right;
            } else if (nums[mid] > target) {
                if (nums[mid] >= nums[left] && nums[left] > target)
                    left = mid + 1;
                else
                    right = mid - 1;
            } else {
                if (nums[mid] <= nums[right] && nums[right] < target) 
                    right = mid - 1;
                else
                    left = mid + 1;
            }
        }
        return nums[left] == target? true : false;
    }
}
