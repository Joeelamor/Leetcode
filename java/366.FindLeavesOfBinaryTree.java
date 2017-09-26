// Problem 366 Find Leaves Of Binary Tree

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    public int helper(TreeNode node, List<List<Integer>> res) {
        if (node == null)
            return -1;
        int level = 1 + Math.max(helper(node.left, res), helper(node.right, res));
        // if res.size() >= level + 1, it means we are still in same level, just add the node into the res. Do not need to new an arraylist.
        if (res.size() < level + 1)
            res.add(new ArrayList<>());
        // All leaves are in same level.
        res.get(level).add(node.val);
        return level;
    }
}