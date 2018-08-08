// Question 85 Maximal Rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] height = new int[n + 1];
        int max = 0;
        for (int i = 0; i < m; i++) {
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(-1);
            for (int j = 0; j <= n; j++) {
                height[j] = (j < n && matrix[i][j] == '1') ? height[j] + 1 : 0;
                while (stack.peek() != -1 && height[stack.peek()] >= height[j]) {
                    max = Math.max(max, height[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        return max;
    }
}