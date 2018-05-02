// Problem 105 Construct Binary Tree From Preorder And Inorder Traversal

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    private TreeNode buildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd)
            return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0;
        for (int i = 0; i <= inEnd; i++) {
            if (inorder[i] == root.val)
                index = i;
        }
        root.left = buildTree(preStart + 1, inStart, index - 1, preorder, inorder);
        // the treenodes between inIndex and inStart are all left subtree nodes, 
        // which means in the preorder case, these nodes all should be in front of right subtree root
        root.right = buildTree(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }
}