// Problem 103 Binary Tree Zigzag Level Order Traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    public void helper(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null)
            return;
        // From top to down level, same level have only one ArrayList.
        if (res.size() <= level)
            res.add(new ArrayList<>());
        // If level is even, directly add node val into ArrayList.
        if (level % 2 == 0)
            res.get(level).add(node.val);
        // If level is odd, add node val into first position.
        else
            res.get(level).add(0, node.val);
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
    }
}