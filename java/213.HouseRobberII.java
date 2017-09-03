// Problem 213 House Robber II

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(newRob(nums, 0, nums.length - 2), newRob(nums, 1, nums.length - 1));
    }
    public int newRob(int[] nums, int head, int tail) {
        int noRob = 0, yesRob = 0;
        for(int i = head; i <= tail; i++) {
            int tmp = noRob;
            noRob = Math.max(noRob, yesRob);
            yesRob = tmp + nums[i];
        }
        return Math.max(noRob, yesRob);
    }
    
}