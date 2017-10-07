// Problem 113 Path Sum II

// Use DFS
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        findPath(root, sum, res, list);
        return res;
    }
    public void findPath(TreeNode node, int sum, List<List<Integer>> res, List<Integer> list) {
        if (node == null)
            return;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == node.val) {
            res.add(new ArrayList<Integer>(list));
        }
        if (node.left != null) {
            findPath(node.left, sum - node.val, res, list);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            findPath(node.right, sum - node.val, res, list);
            list.remove(list.size() - 1);
        }
     }
}

