// Problem 45 Jump Game II

// This is a problem based on Jump Game, but it does not use the method of solving previous problem.
class Solution {
    public int jump(int[] nums) {
        int count = 0, currentIndex = 0, lastIndex = 0;
        for(int i = 0; i < nums.length - 1; i++) {
        	// Just record the maximum index.
            currentIndex = Math.max(currentIndex, i + nums[i]);
            // If moving index reach to the record index, count + 1.
            if(i == lastIndex) {
                count++;
                lastIndex = currentIndex;
            }
        }
        return count;
    }
}