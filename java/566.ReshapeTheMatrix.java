// Problem 566 Reshape The Matrix

// O(mn) time
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int [][]res = new int[r][c];
        if(nums.length * nums[0].length != r * c)
            return nums; 
        int row = 0, col = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums[i].length; j++) {
                res[row][col] = nums[i][j];
                col++;
                if(col == c){
                    col = 0;
                    row++;
                }
            }
        }
        return res;
    }
}

// Another o(mn) time
class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int [][]res = new int[r][c];
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m)
            return nums; 
        for(int i = 0; i < r * c; i++) {
            res[i/c][i%c] = nums[i/m][i%m];
        }
        return res;
    }
}