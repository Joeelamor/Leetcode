// Question 994 Rotting Oranges

class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.offer(new int[]{i, j});
                if (grid[i][j] == 1)
                    count++;
            }
        }
        int level = 0;
        if (count == 0)
            return level;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != 1)
                        continue;
                    grid[x][y] = 2;
                    count--;
                    q.offer(new int[]{x, y});
                }
            }
            level++;
        }
        
        return count == 0 ? level - 1 : -1;
    }
}