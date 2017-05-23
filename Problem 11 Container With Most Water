Problem 11 Container With Most Water

/* wrong answer ---- time limit exceeded

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int len = 0;
        int cur = 0;
        int area = 0;
        for(int i = 0; i < height.length - 1; i++) {
            for(int j = i + 1; j < height.length; j++) {
                if(height[i] <= height[j])
                    cur = height[i];
                else
                    cur = height[j];
                area = cur * (j - i);
                if(max <= area)
                    max = area;
            }
        }
        return max;
    }
}

/* right answer
// in this answer, I use two pointers left and right from beginner and ender to
// move, get max area.


public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while(left < right) {
            max = Math.max(max, Math.min(height[left], height[right])*(right - left));
            if(height[left] <= height[right])
                left++;
            else
                right--;
        }
        return max;
    }
}