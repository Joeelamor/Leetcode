// Problem 538 Convert BST to Greater Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Do a reverse inorder tranverse the nodes of the tree in descending order.
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode root) {
        if(root == null)
            return;
        convert(root.right);
        root.val += sum;
        sum = root.val;
        convert(root.left);
    }
}