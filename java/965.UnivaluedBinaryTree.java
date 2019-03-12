// Question 965 Univalued Binary Tree

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
    public boolean isUnivalTree(TreeNode root) {
        if (root.left != null) {
            if (!isUnivalTree(root.left))
                return false;
            if (root.left.val != root.val)
                return false;
        }
        if (root.right != null) {
            if (!isUnivalTree(root.right))
                return false;
            if (root.right.val != root.val)
                return false;
        }
        return true;
    }
}