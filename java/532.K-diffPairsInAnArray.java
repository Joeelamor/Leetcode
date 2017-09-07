// Problem 532 K-diff Pairs In An Array

// Use two points to record current two numbers and computer their difference.
class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0, j = 0; i < nums.length; i++) {
            j = Math.max(i + 1, j); // left point
            while(j < nums.length && nums[j] - nums[i] < k) j++;
            if(j < nums.length &&  nums[j] - nums[i] == k) count++;
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
        return count;
    }
}