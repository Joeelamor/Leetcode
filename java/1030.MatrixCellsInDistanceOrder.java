// Question 1030 Matrix Cells in Distance Order

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r0, c0});
        int i = 0;
        res[i++] = new int[]{r0, c0};
        visited[r0][c0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= R || y < 0 || y >= C || visited[x][y]) {
                    continue;
                }
                res[i++] = new int[]{x, y};
                visited[x][y] = true;
                q.add(new int[] {x, y});
            }
        }
        return res;
    }
}