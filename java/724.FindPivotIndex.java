// Problem 724 Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int left = 0, index = 0, n = nums.length;
        while(index < n) {
            if (left * 2 + nums[index] != sum) {
                left += nums[index];
                index++;
            } else {
                return index;
            }
        }
        return -1;
    }
}