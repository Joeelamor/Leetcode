import java.util.*;

public class DiagonalSum {
    public int[] findDiagonalSum(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int i = m - 1, j = 0;
        while (j < n) {
            int subSum = 0;
            int x = i, y = j;
            while (x < m && y < n) {
                    subSum += matrix[x][y];
                    x++;
                    y++;
            }
            list.add(subSum);
            if (i > 0) {
                i--;
            } else {
                j++;
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for (int num : list) {
            res[index++] = num;
        }
        return res;
    }

    public int[] findDiagonalSum1(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m + n - 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[m - 1 - i + j] += matrix[i][j];
            }
        }
        return res;
    }
}
