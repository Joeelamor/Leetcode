// Problem 764 Largest Plus Sign

class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int[] line : matrix) {
            Arrays.fill(line, 1);
        }
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 0;
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    int dir = 1, count = 1;
                    while (i - dir >= 0 && i + dir < matrix.length && 
                           j - dir >= 0 && j + dir < matrix[0].length &&
                          matrix[i - dir][j] == 1 && matrix[i][j - dir] == 1 &&
                          matrix[i + dir][j] == 1 && matrix[i][j + dir] == 1) {
                        count++;
                        dir++;
                    }
                     res = Math.max(res, count);   
                }
            }
        }
        return res;
    }
}