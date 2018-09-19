// Question 505 The Maze II

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0)
            return -1;
        if (start[0] == destination[0] && start[1] == destination[1])
            return 0;
        int[][] dirs = {{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0], y = cur[1], count = 0;
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count ++;
                }
                x -= dir[0];
                y -= dir[1];
                count--;
                if (distance[cur[0]][cur[1]] + count < distance[x][y]) {
                    distance[x][y] = distance[cur[0]][cur[1]] + count;
                    q.offer(new int[]{x, y});
                }
            }
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
}