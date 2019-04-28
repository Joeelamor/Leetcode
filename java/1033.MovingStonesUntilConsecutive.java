// Question 1033 Moving Stones Until Consecutive

class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        int[] nums = {a, b, c};
        Arrays.sort(nums);
        int maxCount = nums[2] - nums[0] - 2;
        int minCount = 2;
        if (nums[2] - nums[1] < 3 || nums[1] - nums[0] < 3) minCount = 1;
        if (nums[2] - nums[1] == 1 && nums[1] - nums[0] == 1) minCount = 0;
        return new int[] { minCount, maxCount };
    }
}