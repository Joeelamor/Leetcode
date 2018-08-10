// Question 490 The Maze

// Method 1: BFS
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1]) return true;
            for (int i = 0; i < 4; i++) {
                int x = cur[0], y = cur[1];
                while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    x += directions[i][0];
                    y += directions[i][1];
                }
                x -= directions[i][0];
                y -= directions[i][1];
                if (visited[x][y]) continue;
                visited[x][y] = true;
                q.offer(new int[]{x, y});
            }
        }
        return false;
    }
} 

// Method 2: DFS

class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze == null || maze.length == 0) return false;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return helper(maze, start, destination, visited);
    }
    
    private boolean helper(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        if (start[0] < 0 || start[0] >= maze.length || start[1] < 0 || start[1] >= maze[0].length || visited[start[0]][start[1]]) return false;
        visited[start[0]][start[1]] = true;
        for (int i = 0; i < 4; i++) {
            int x = start[0], y = start[1];
            // It won't stop rolling until hitting a wall
            while (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                x += directions[i][0];
                y += directions[i][1];
            }
            if (helper(maze, new int[]{x - directions[i][0], y - directions[i][1]}, destination, visited)) return true;
        }
        return false;
    }
}