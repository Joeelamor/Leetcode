// Problem 598 Range Addition II

// Just find the min row and column
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int rowMin = m, colMin = n;
        for(int []pair: ops) {
            rowMin = Math.min(rowMin, pair[0]);
            colMin = Math.min(colMin, pair[1]);
        }
        return rowMin * colMin;
    }
}