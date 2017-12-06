// Problem 74 Search A 2D Matrix

// Consider the matrix as a sorted list.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0, end = row * col - 1, mid;
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (matrix[mid / col][mid % col] == target)
                return true;
            else if (matrix[mid / col][mid % col] > target)
                end = mid - 1;
            else
                begin = mid + 1;
        }
        return false;
    }
}

// Method 2: 
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}