// Problem 98 Validate Binary Search Tree

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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isBST(TreeNode node, long min, long max) {
        if(node == null)
            return true;
        if(node.val >= max || node.val <= min)
            return false;
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}