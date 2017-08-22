// Problem 563 Binary Tree Tilt

// Postorder traverse the nodes of tree
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
    int result = 0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return result;
    }
    public int traverse(TreeNode root) {
        if(root == null)
            return 0;
        int left = traverse(root.left);
        int right = traverse(root.right);
        result += Math.abs(left - right);
        return left + right + root.val;
    }
}