// Problem 200 Number Of Islands

/* In this problem, the key point is when we find a '1', then we count 1 island 
 * and set the '1' to '0'. */
class Solution {
    int m, n;
    public int numIslands(char[][] grid) {
        int count = 0;
        m = grid.length;
        if(m == 0)
            return 0;
        n = grid[0].length;        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;       
    }
    public void helper(char[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') return;
        grid[i][j] = '0';
        helper(grid, i + 1, j);
        helper(grid, i - 1, j);
        helper(grid, i, j + 1);
        helper(grid, i, j - 1);
    }
}