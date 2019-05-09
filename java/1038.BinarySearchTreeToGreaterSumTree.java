// Question 1038 Binary Search Tree to Greater Sum Tree

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
    int pre = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root.right != null) 
            bstToGst(root.right);
        root.val = pre + root.val;
        pre = root.val;
        if (root.left != null) 
            bstToGst(root.left);
        return root;
    }
}

