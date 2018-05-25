// Problem 783 Minimum Distance Between BST Nodes

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
    Integer prev = null;
    int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if (root == null) return min;
        minDiffInBST(root.left);
        if (prev != null) {
            min = Math.min(min, Math.abs(prev - root.val));
        }
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }
}