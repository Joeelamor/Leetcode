// Problem 565 Array Nesting

class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = 0, j = i;
            while (nums[j] >= 0) {
                int k = nums[j];
                nums[j] = -1; // mark nums[j] as visited
                j = k;
                cur++;
            }
            max = Math.max(max, cur);
        }
        return max;
    }
}