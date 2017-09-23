// Problem 270 Closest Binary Search Tree Value

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
    public int closestValue(TreeNode root, double target) {
        return helper(root, target, root.val);
    }
    // The val keep each iteration closest target.
    public int helper(TreeNode node, double target, int val) {
        if (node == null)
            return val;
        if (Math.abs(node.val - target) < Math.abs(val - target))
            val = node.val;
        if (node.val < target)
            val = helper(node.right, target, val);
        else if (node.val > target)
            val = helper(node.left, target, val);
        return val;
            
    }
}