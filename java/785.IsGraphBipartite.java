// Problem 785 Is Graph Bipartite

class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            // Never visited.
            if (graph[i].length != 0 && visited[i] == 0) {
                // Color it.
                visited[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int next: graph[cur]) {
                        if (visited[next] == 0) {
                            // If it hasn't been colored, use a color to color it. 
                            visited[next] = visited[cur] == 1 ? 2 : 1;
                            queue.offer(next);
                        } else {
                            // If it has been colored, check if the current color is the same as the color that is                             // going to be used to color it.
                            if (visited[next] == visited[cur])
                                return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}


// Use DFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == 0 && !dfs(visited, graph, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(int[] visited, int[][] graph, int color, int node) {
        if (visited[node] != 0) {
            return visited[node] == color;
        }
        visited[node] = color;
        for (int next: graph[node]) {
            if (!dfs(visited, graph, -1 * color, next)) 
                return false;
        }
        return true;
    }
}