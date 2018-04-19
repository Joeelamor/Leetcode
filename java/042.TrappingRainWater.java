// Problem 42 Trapping Rain Water

class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int heighest = 0, maxIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > heighest) {
                heighest = height[i];
                maxIndex = i;
            }
        }
        int res = 0, leftMax = height[0], rightMax = height[height.length - 1];
        for (int i = 1; i < maxIndex; i++) {
            if (height[i] > leftMax)
                leftMax = height[i];
            else
                res += leftMax - height[i];
        }
        for (int i = height.length - 2; i > maxIndex; i--) {
            if (height[i] > rightMax)
                rightMax = height[i];
            else
                res += rightMax - height[i];
        }
        return res;
    }
}