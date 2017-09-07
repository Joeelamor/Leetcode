// Problem 102 Binary Tree Level Order Traversal

// Use BFS
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
            return res;
        q.offer(root);
        while(!q.isEmpty()) {
            int level = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < level; i++) {
                if(q.peek().left != null)
                    q.offer(q.peek().left);
                if(q.peek().right != null)
                    q.offer(q.peek().right);
                list.add(q.poll().val);
            }
            res.add(list);
        }
        return res;
    }
}