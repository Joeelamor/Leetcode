// Problem 286 Walls and Gates

// method 1: DFS => costly.
class Solution {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
            }
        }
    }
    private void dfs(int[][] rooms, int i, int j, int cur) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length || rooms[i][j] < cur) return;
        rooms[i][j] = cur;
        dfs(rooms, i - 1, j, cur + 1);
        dfs(rooms, i, j - 1, cur + 1);
        dfs(rooms, i + 1, j, cur + 1);
        dfs(rooms, i, j + 1, cur + 1);
            
    }
}

// method 2: BSF => best method. And rooms[p][q] > rooms[i][j] + 1 is used for general condition.
class Solution {
    public static final int[] d = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0) queue.offer(i * n + j);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / n, j = x % n;
            for (int k = 0; k < 4; ++k) {
                int p = i + d[k], q = j + d[k + 1];
                // this is used for different distance of different edges.
                if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] > rooms[i][j] + 1) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }
}

// BFS: rooms[p][q] == Integer.MAX_VALUE is only for unit distance.
class Solution {
    public static final int[] d = {0, 1, 0, -1, 0};

    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0) queue.offer(i * n + j);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / n, j = x % n;
            for (int k = 0; k < 4; ++k) {
                int p = i + d[k], q = j + d[k + 1];
                // this is used for unit distance
                if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }
}