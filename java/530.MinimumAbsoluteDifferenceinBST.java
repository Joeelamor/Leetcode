// Problem 530 Minimum Absolute Difference in BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Do a inorder tranverse the nodes of the tree.
class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return min;
        getMinimumDifference(root.left);
        if(prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
}