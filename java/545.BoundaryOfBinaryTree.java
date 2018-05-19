// Problem 545 Boundary of Binary Tree 
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
    List<Integer> nodes = new LinkedList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return nodes;
        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return nodes;
    }
    
    private void leftBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        nodes.add(node.val);
        if (node.left == null) leftBoundary(node.right);
        else leftBoundary(node.left);
    }
    
    private void rightBoundary(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) return;
        if (node.right == null) rightBoundary(node.left);
        else rightBoundary(node.right);
        nodes.add(node.val);
    }
    
    private void leaves(TreeNode node) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            nodes.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
}