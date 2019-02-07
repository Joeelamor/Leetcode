// Question 987 Vertical Order Traversal of a Binary Tree

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> qNum = new LinkedList<>();
        q.offer(root);
        qNum.offer(0);
        while (!q.isEmpty()) {
            TreeMap<Integer, TreeSet<Integer>> tmap = new TreeMap<>();
            for(int size = q.size(); size > 0; size--) {  
                TreeNode node = q.poll();
                int cur = qNum.poll();
                tmap.putIfAbsent(cur, new TreeSet<>());
                tmap.get(cur).add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                    qNum.offer(cur - 1);
                }
                if (node.right != null) {
                    q.offer(node.right);
                    qNum.offer(cur + 1);
                }
            }
            for(int idx  : tmap.keySet()) {
                map.putIfAbsent(idx, new ArrayList<>());
                map.get(idx).addAll(tmap.get(idx));
            }
        }
        return new ArrayList<>(map.values());
    }
}