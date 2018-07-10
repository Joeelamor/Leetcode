// Problem 866 Smallest Subtree With All The Deepest Nodes

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
	// Use hashmap to store each node and depth
    HashMap<TreeNode, Integer> depth = new HashMap<>(); // use hashmap to store each node and its depth
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int left = helper(root.left);
        int right = helper(root.right);
        if (left == right)
            return root;
        else if (left < right)
            return subtreeWithAllDeepest(root.right);
        else
            return subtreeWithAllDeepest(root.left);
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        if (depth.containsKey(node))
            return depth.get(node);
        int left = helper(node.left);
        int right = helper(node.right);
        int curDepth = 1 + Math.max(left, right);
        depth.put(node, curDepth);
        return curDepth;
    }
}