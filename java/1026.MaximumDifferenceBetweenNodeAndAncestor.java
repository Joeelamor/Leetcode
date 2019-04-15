//Question 1026 Maximum Difference Between Node and Ancestor

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
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
        helper(root, root.val, root.val);
        return res;
    }
    
    private void helper(TreeNode node, Integer min, Integer max) {
        if (node == null)
            return;
        min = Math.min(min, node.val);
        max = Math.max(max, node.val);        
        res = Math.max(res, Math.abs(min - max));
        helper(node.left, min, max);
        helper(node.right, min, max);
    }
}