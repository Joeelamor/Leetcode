// Problem 308 Range Sum Query 2D - Mutable 

// Row-based is better than column-based because the computer stores the araay in a row-based way, which means you will have less cache miss if you update in a one row instead of one column.
class NumMatrix {
    int[][] rowSum;
    int[][] matrix;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        rowSum = new int[m][n + 1];
        this.matrix = matrix;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                rowSum[i][j] = rowSum[i][j - 1] + matrix[i][j - 1];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        for (int i = col + 1; i < rowSum[0].length; i++) {
            rowSum[row][i] = rowSum[row][i] - matrix[row][col] + val;
        }
        matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = 0;
        for (int i = row1; i <= row2; i++) {
            res += rowSum[i][col2 + 1] - rowSum[i][col1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */