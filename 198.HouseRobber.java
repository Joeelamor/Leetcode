// Problem 198 House Robber

// Consider that at even and odd position, for even position, we compare the current 
// number plus last max even number with last max odd number. And for odd number,
// we have same comparison.

public class Solution {
    public int rob(int[] nums) {
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0)
                a = Math.max(b, a + nums[i]);
            else
                b = Math.max(a, b + nums[i]);
        }
        return Math.max(a, b);
    }
}