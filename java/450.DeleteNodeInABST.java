// Problem 450 Delete Node In A BST

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val > key)  root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                root.val = getMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
    
    private int getMin(TreeNode node) {
        while (node.left != null)
            node = node.left;
        return node.val;
    }
}