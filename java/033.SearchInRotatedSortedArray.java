// Problem 33 Search In Rotated Sorted Array

// Method 1: O(n) time
class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }
        return -1;
    }
}

// Method 2: O(logn) time
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return nums[left] == target? left: -1;
    }
}