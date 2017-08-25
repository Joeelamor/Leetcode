// Problem 617 Merge Two Binary Trees

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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) 
            return null;
        if(t1 != null && t2 == null)
            return t1;
        if(t1 == null && t2 != null)
            return t2;
        int val = t1.val + t2.val;
        TreeNode mergeNode = new TreeNode(val);        
        mergeNode.left = mergeTrees(t1.left, t2.left);
        mergeNode.right = mergeTrees(t1.right, t2.right);
        return mergeNode;
    }
}