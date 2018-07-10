// Problem 742 Closest Leaf In A Binary Tree

/** We use a depth-first search to record in our graph each edge travelled from parent to node.
 *  After, we use a breadth-first search on nodes that started with a value of k, so that we are 
 *  visiting nodes in order of their distance to k. When the node is a leaf (it has one outgoing 
 *  edge, where the root has a "ghost" edge to null), it must be the answer.
 *  (Different from Problem 863)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findClosestLeaf(TreeNode root, int k) {
        HashMap<TreeNode, List<TreeNode>> graph = new HashMap<>();
        helper(root, graph, null);
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        for (TreeNode node: graph.keySet()) {
            if (node != null && node.val == k) {
                q.add(node);
                visited.add(node);
            }
        }
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                if (graph.get(node).size() <= 1)
                    return node.val;
                for (TreeNode next: graph.get(node)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        q.add(next);
                    }
                }
            }
        }
        return -1;
    }
    
    private void helper(TreeNode node, HashMap<TreeNode, List<TreeNode>> graph, TreeNode parent) {
        if (node != null) {
            if (!graph.containsKey(node)) graph.put(node, new LinkedList<TreeNode>());
            if (!graph.containsKey(parent)) graph.put(parent, new LinkedList<TreeNode>());
            graph.get(node).add(parent);
            graph.get(parent).add(node);
            helper(node.left, graph, node);
            helper(node.right, graph, node);
        }
    }
}