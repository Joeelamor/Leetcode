// Problem 81 Search In Rotated Sorted Array II

// If there will be repeated numbers in array, just split it into two parts, then consider all edge cases.
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (right + left) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[left] < nums[mid]) {
                if(target >= nums[left] && target < nums[mid])
                    right = mid;
                else
                    left = mid + 1;
            } else if (nums[mid] < nums[left]){
                if(target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid;
            } else {
                left++;
            }
        }
        return nums[left] == target? true : false;
    }
}

