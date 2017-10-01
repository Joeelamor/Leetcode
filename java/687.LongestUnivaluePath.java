// Problem 687 Longest Univalue Path

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
    int sum = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        helper(root);
        return sum;
    }
    public int helper(TreeNode node) {
        if (node == null)
            return 0;
        int left = node.left == null? 0 : helper(node.left);
        int right = node.right == null? 0 :helper(node.right);
        int leftCur = 0, rightCur = 0;
        if (node.left != null && node.val == node.left.val)
            leftCur = 1 + left;
        if (node.right != null && node.val == node.right.val)
            rightCur = 1 + right;
        sum = Math.max(sum, leftCur + rightCur);
        return Math.max(leftCur, rightCur);
    }
}