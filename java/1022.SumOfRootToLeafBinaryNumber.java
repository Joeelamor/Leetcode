// Question 1022 Sum of Root To Leaf Binary Numbers

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
    public int sumRootToLeaf(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode node, int val) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return val * 2 + node.val;
        return helper(node.left, val * 2 + node.val) + helper(node.right, val * 2 + node.val);
    }
}