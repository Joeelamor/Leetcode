// Question 272 Closest Binary Search Tree Value II

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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        helper(res, root, target, k);
        return res;
    }
    
    void helper(LinkedList<Integer> res, TreeNode node, double target, int k) {
        if (node == null || res.size() == k && res.get(0) >= target)
            return;
        helper(res, node.left, target, k);
        if (res.size() == k && Math.abs(node.val - target) < Math.abs(res.get(0) - target)) {
            res.removeFirst();
            res.add(node.val);
        }
        else if (res.size() < k)
            res.add(node.val);
        helper(res, node.right, target, k);
    }
}