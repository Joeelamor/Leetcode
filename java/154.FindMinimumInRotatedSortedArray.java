// Problem 154 Find Minimum In Rotated Sorted Array II

// Method 1: O(n)
class Solution {
    public int findMin(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] < nums[i - 1])
                return nums[i];
        }
        return nums[0];
    }
}

// Method 2: binary search
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) right = mid;
            else if (nums[mid] > nums[right]) left = mid + 1;
            else right--;
        }
        return nums[left];
    }
}