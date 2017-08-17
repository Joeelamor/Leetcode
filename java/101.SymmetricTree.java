// Problem 101 Symmetric Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else 
            return test(root.left, root.right);
    }
    
    public boolean test(TreeNode l, TreeNode r) {
        if(l == null && r == null)
            return true;
        else if(l != null && r != null && l.val == r.val)
            return test(l.left, r.right) && test(l.right, r.left);
        else
            return false;
    }
}