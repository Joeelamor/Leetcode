// Problem 298 Binary Tree Longest Consecutive Sequence

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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int res = helper(root, 1, root.val);
        return res;
    }
    
    public int helper(TreeNode node, int count, int prev) {
        if (node == null) return count;
        if (node.val == prev + 1) {
            count++;
        } else {
            count = 1;
        }
        int left = helper(node.left, count, node.val);
        int right = helper(node.right, count, node.val);
        return Math.max(Math.max(left, right), count);
    }
}