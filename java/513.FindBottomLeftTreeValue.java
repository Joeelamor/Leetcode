// Problem 513 Find Bottom Left Tree Value

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
    public int findBottomLeftValue(TreeNode root) {
        return helper(root, 1, new int[]{0, 0});
    }
    
    private int helper(TreeNode node, int depth, int[] arr) {
        if (arr[1] < depth) {
            arr[0] = node.val;
            arr[1] = depth;
        }
        if (node.left != null) 
            helper(node.left, depth + 1, arr);
        if (node.right != null)
            helper(node.right, depth + 1, arr);
        return arr[0];
    }
}