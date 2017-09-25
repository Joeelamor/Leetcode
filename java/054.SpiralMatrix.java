// Problem 54 Spiral Matrix

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }
        int rowHead = 0, colHead = 0, rowTail = matrix.length - 1, colTail = matrix[0].length - 1;
        while (rowHead <= rowTail && colHead <= colTail) {
        	// Traverse right
            for (int i = colHead; i <= colTail; i++) {
                res.add(matrix[rowHead][i]);
            }
            rowHead++;
            // Traverse down
            for (int i = rowHead; i <= rowTail; i++) {
                res.add(matrix[i][colTail]);
            }
            colTail--;
            // If there is no row, continue, or traverse left
            if (rowHead <= rowTail) {
                for (int i = colTail; i >= colHead; i--) {
                    res.add(matrix[rowTail][i]);
                }
            }
            rowTail--;
            // If there is no column, continue, or traverse up
            if (colHead <= colTail) {
                for (int i = rowTail; i >= rowHead; i--) {
                    res.add(matrix[i][colHead]);
                }
            }
            colHead++;
        }
        return res;
    }
}