// Problem 207 Course Schedule

// Use DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }
    
    private boolean dfs(int cur, ArrayList<ArrayList<Integer>> graph, int[] visited) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false;
        visited[cur] = 1;
        for (int next : graph.get(cur)) {
            if (dfs(next, graph, visited)) return true;
        }
        visited[cur] = 2;
        return false;
    }
}


// Use BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int prerequisite = prerequisites[i][1];
            graph.get(course).add(prerequisite);
            indegree[prerequisite]++;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int adj : graph.get(course)) {
                indegree[adj]--;
                if (indegree[adj] == 0) 
                    queue.offer(adj);
            }
        }
        return count == numCourses;
    }
}