// Problem 437 Path Sum III

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return countPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    public int countPath(TreeNode node, int sum) {
        if(node == null)
            return 0;
        return (node.val == sum? 1 : 0) + countPath(node.left, sum - node.val) + countPath(node.right, sum - node.val);
    }
}