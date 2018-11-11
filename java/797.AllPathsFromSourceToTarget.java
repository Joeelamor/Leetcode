// Question 797 All Paths From Source to Target

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        if (graph.length == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        helper(graph, res, 0, list);
        return res;
    }
    
    public void helper(int[][] graph, List<List<Integer>> res, int cur, List<Integer> list) {
        if (cur == graph.length - 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int next : graph[cur]) {
            list.add(next);
            helper(graph, res, next, list);
            list.remove(list.size() - 1);
        }        
    }
}