// Problem 453 Minimum Moves to Equal Array Elements

// I find a rule. The minimum moves is a sum of difference between min and each value in array. 
public class Solution {
    public int minMoves(int[] nums) {
        int sum = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if(nums[i] <= min)
                min = nums[i];
        }
        return sum - nums.length * min;
    }
}