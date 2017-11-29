// Problem 329 Longest Increasing Path in a Matrix

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length, res = 1;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, helper(matrix, i, j, cache));
            }
        }
        return res;
    }
    
    final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    private int helper(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0)
            return cache[i][j];
        int max = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length || matrix[x][y] <= matrix[i][j])
                continue;
            int len = 1 + helper(matrix, x, y, cache);
            max = Math.max(len, max);
        } 
        cache[i][j] = max;
        return max;
    }
}