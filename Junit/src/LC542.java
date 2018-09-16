import java.util.*;

public class LC542 {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return matrix;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] direction : directions) {
                int x = cur[0] + direction[0];
                int y = cur[1] + direction[1];
                if (x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[cur[0]][cur[1]] + 1)
                    continue;
                q.add(new int[]{x, y});
                matrix[x][y] = matrix[cur[0]][cur[1]] + 1;
            }
        }
        return matrix;
    }
}
