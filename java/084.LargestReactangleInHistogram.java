// Question 084 Largest Reactangle In Histogram

// method 1: brute force
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, (j - i + 1) * min);
            }
        }
        return max;
    }
}

// method 2: use divide and conquer
class Solution {
    public int largestRectangleArea(int[] heights) {
        return helper(heights, 0, heights.length - 1);
    }
    private int helper(int[] heights, int left, int right) {
        if (left > right) return 0;
        int minIndex = left;
        for (int i = left; i <= right; i++) {
            if (heights[minIndex] > heights[i])
                minIndex = i;
        }
        return Math.max(heights[minIndex] * (right - left + 1), Math.max(helper(heights, left, minIndex - 1), helper(heights, minIndex + 1, right)));
    }
}

// use stack

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            stack.push(i);
        }
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }
}
