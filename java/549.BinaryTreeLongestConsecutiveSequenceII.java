// Problem 549 Binary Tree Longest Consecutive Sequence II

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
    int res;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }
    public int[] helper(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int inc = 1;
        int dec = 1;
        
        if (node.left != null) {
            if (node.val - node.left.val == 1) {
                inc = left[0] + 1;
            } else if(node.left.val - node.val == 1) {
                dec = left[1] + 1;
            }
        }
        if (node.right != null) {
            if (node.val - node.right.val == 1) {
                inc = Math.max(inc, right[0] + 1);
            } else if (node.right.val - node.val == 1) {
                dec = Math.max(dec, right[1] + 1);
            }
        }
        res = Math.max(res, inc + dec - 1);
        return new int[]{inc, dec};
    }
}