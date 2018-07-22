// Problem 872 Leaf-Similar Trees

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        helper(root1, sb1);
        helper(root2, sb2);
        return sb1.toString().equals(sb2.toString());
    }
    private void helper(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            sb.append(node.val);
            return;
        }
        helper(node.left, sb);
        helper(node.right, sb);
    }
}