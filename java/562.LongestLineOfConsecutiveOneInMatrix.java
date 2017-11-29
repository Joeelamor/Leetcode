// Problem 562 Longest Line of Consecutive One in Matrix

// Straightforward solution
class Solution {
    public int longestLine(int[][] M) {
        if (M.length == 0)
            return 0;
        int m = M.length, n = M[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    max = Math.max(helper(M, i, j), max);
                    if (max >= Math.max(m, n))
                        return max;
                }
            }
        }
        return max;
    }
    final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {1, 1}, {1, -1}}; 
    private int helper(int[][] M, int i, int j) {
        int res = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            int count = 1;
            while (isValid(M, x, y)) {
                x += dir[0];
                y += dir[1];
                count++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
    private boolean isValid(int[][] M, int i, int j){
        if (i < 0 || j < 0 || i >= M.length || j >= M[0].length || M[i][j] == 0)
            return false;
        return true;
    }
}

// Use DP
public int longestLine(int[][] M) {
    if (M.length == 0 || M[0].length == 0) {
        return 0;
    }
    int max = 0;
    int[] col = new int[M[0].length];
    int[] diag = new int[M.length + M[0].length];
    int[] antiD = new int[M.length + M[0].length];
    for (int i = 0; i < M.length; i++) {
        int row = 0;
        for (int j = 0; j < M[0].length; j++) {
            if (M[i][j] == 1) {
                row++;
                col[j]++;
                diag[j + i]++;
                antiD[j - i + M.length]++;
                max = Math.max(max, row);
                max = Math.max(max, col[j]);
                max = Math.max(max, diag[j + i]);
                max = Math.max(max, antiD[j - i + M.length]);
            } else {
                row = 0;
                col[j] = 0;
                diag[j + i] = 0;
                antiD[j - i + M.length] = 0;
            }
        }
    }
    return max;
}