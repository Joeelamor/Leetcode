// Problem 95 Unique Binary Search Trees II

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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
        return buildTree(1, n);
    }
    
    private List<TreeNode> buildTree(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        } 
        List<TreeNode> left, right;
        for (int i = start; i <= end; i++) {
            left = buildTree(start, i - 1);
            right = buildTree(i + 1, end);
            for (TreeNode leftNode: left) {
                for (TreeNode rightNode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    list.add(root);
                }
            }
        }
        return list;
    }
s