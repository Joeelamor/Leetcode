// Problem 106 Construct Binary Tree From Inorder And Postorder Traversal

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(0, postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    private TreeNode buildTree(int postStart, int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (inStart > inEnd || postStart > postEnd)
            return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = buildTree(postStart, postStart + index - inStart - 1, inStart, index - 1, inorder, postorder);
        root.right = buildTree(postEnd - inEnd + index, postEnd - 1, index + 1, inEnd, inorder, postorder);
        return root;
    }
}