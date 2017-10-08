// Problem 695 Max Area Of Island

// Use global varies (not recommend)
class Solution {
    int m, n, max, count;
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        if(m == 0)
            return 0;
        n = grid[0].length;        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    count = 0;
                    helper(grid, i, j);
                }
            }
        }
        return max;       
    }
    public void helper(int[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return;
        grid[i][j] = 0;
        count++;
        max = Math.max(max, count);
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}

// Do not use global varies
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        if(m == 0)
            return 0;
        int n = grid[0].length;        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, helper(grid, i, j));
                }
            }
        }
        return max;       
    }
    public int helper(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) 
            return 0;
        grid[i][j] = 0;
        return 1 + helper(grid, i + 1, j) + helper(grid, i - 1, j) + 
            helper(grid, i, j + 1)+ helper(grid, i, j - 1);
    }
}