// Problem 333 Largest BST Subtree

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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        if (isValid(root, null, null)) return size(root);
        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }
    
    private boolean isValid(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
    
    private int size(TreeNode node) {
        if (node == null) return 0;
        return 1 + size(node.left) + size(node.right);
    }
}