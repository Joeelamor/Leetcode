// Problem 59 Spiral Matrix II

/* This is a follow up of Spiral Matrix I, just need a counter to fill in each position.
 * For fill order detailed, just look at problem 54 Spiral Matrix I.
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int [][]res = new int[n][n];
        int start = 1;
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int i = colBegin; i <= colEnd; i++) {
                res[rowBegin][i] = start;
                start++;
            }
            rowBegin++;
            for (int i = rowBegin; i <= rowEnd; i++) {
                res[i][colEnd] = start;
                start++;
            }
            colEnd--;
            if (colBegin <= colEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    res[rowEnd][i] = start;
                    start++;
                }
                rowEnd--;
            }
            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= rowBegin; i--) {
                    res[i][colBegin] = start;
                    start++;
                }
                colBegin++;
            }
        }
        return res;
    }
}