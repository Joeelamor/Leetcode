// Question 887 Projection Area Of 3D Shapes

class Solution {
    public int projectionArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            int maxRow = 0;
            int maxCol = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) res++;
                maxRow = Math.max(maxRow, grid[i][j]);
                maxCol = Math.max(maxCol, grid[j][i]);
            }
            res += maxRow + maxCol;
        }
        return res;
    }
}