// Problem 694 Number Of Distinct Islands

/* Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 
 * 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands. An island is considered to be the same as another if and only if one
 * island can be translated (and not rotated or reflected) to equal the other.
 *	 Example 1:
 *	11011
 *	10000
 *	00001
 *	11011
 *  return 3
 */

// In this problem, you need to find each island origin point, then use their relative coordinates to determine if they are distinct.	
 class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sb.setLength(0);
                    helper(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    public void helper(int[][] grid, int x, int y, StringBuilder sb) {
        if (x >= grid.length || x < 0 || y >= grid[0].length || y < 0 || grid[x][y] == 0)
            return;
        grid[x][y] = 0;
        helper(grid, x + 1, y, sb.append('d'));
        helper(grid, x - 1, y, sb.append('u'));
        helper(grid, x, y + 1, sb.append('r'));
        helper(grid, x,y - 1, sb.append('l')); 
    }
}