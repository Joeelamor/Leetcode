// Problem 55 Jump Game

class Solution {
    public boolean canJump(int[] nums) {
        // Use greedy algorithm
        int len = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            if(i + nums[i] >= len)
                len = i;
        }
        return len == 0;
    }
}

