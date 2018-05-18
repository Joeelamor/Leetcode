// Problem 107 Binary Tree Level Order Traversal II

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                list.add(node.val);
            }
            res.add(0, list);
        }
        return res;
    }
}