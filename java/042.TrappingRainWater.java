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

// add a new method 

/**The idea is: I calculated the stored water at each index a and b in my code. At the start of every loop, I
 * update the current maximum height from left side (that is from A[0,1...a]) and the maximum height from right
 * side(from A[b,b+1...n-1]). if(leftmax < rightmax) then, at least (leftmax-A[a]) water can definitely be stored no
 * matter what happens between [a,b] since we know there is a barrier at the rightside(rightmax > leftmax). On the 
 * other side, we cannot store more water than (leftmax-A[a]) at index a since the barrier at left is of height 
 * leftmax. So, we know the water that can be stored at index a is exactly (leftmax-A[a]). The same logic applies 
 * to the case when (leftmax>rightmax). At each loop we can make a and b one step closer. Thus we can finish it in 
 * linear time.
 */
class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, left = 0, right = height.length - 1, max = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                max += (leftMax - height[left]);
                left++;
            } else {
                max += (rightMax - height[right]);
                right--;
            }
        }
        return max;
    }
}