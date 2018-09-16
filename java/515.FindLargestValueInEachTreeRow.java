// Question 515 Find Largest Value in Each Tree Row

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            int max = Integer.MIN_VALUE;
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.poll();
                    max = Math.max(max, cur.val);
                    if (cur.left != null)
                        q.offer(cur.left);
                    if (cur.right != null)
                        q.offer(cur.right);
                }
                res.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return res;
    }
}