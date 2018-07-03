// Problem 863 All Nodes Distance K In Binary Tree

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
    HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        if (root == null || K < 0) return res;
        helper(root, null);
        if (!map.containsKey(target)) return res;
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target); 
        while (!q.isEmpty()) {
            int size = q.size();
            if (K == 0) {
                for (int i = 0; i < size; i++) {
                    res.add(q.poll().val);
                }
                break;
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                for (TreeNode next : map.get(cur)) {
                    if (visited.contains(next)) continue;
                    visited.add(next);
                    q.offer(next);
                }
            }
            K--;
        }
        return res;
    }
    
    private void helper(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new LinkedList<TreeNode>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            helper(node.left, node);
            helper(node.right, node);
        }
    }
}