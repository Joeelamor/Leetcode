// Problem 73 Set Matrix Zeroes

// Use O(m + n) space.
class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null)
            return;
        // Use two sets to keep indexes of which is zero. 
        Set<Integer> setRow = new HashSet<>();
        Set<Integer> setCol = new HashSet<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    setRow.add(i);
                    setCol.add(j);
                }
            }
        }
        for(int n: setRow) {
            for(int col = 0; col < matrix[0].length; col++) {
                matrix[n][col] = 0;
            }
        }
        for(int m: setCol) {
            for(int row = 0; row < matrix.length; row++) {
                matrix[row][m] = 0;
            }
        }
    }
}

// Use O(1) space
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row = false, col = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0)
                        row = true;
                    if (j == 0)
                        col = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
