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

// Use recursion
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
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        help(root, res, 0);
        return res;
    }
    public void help(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null)
            return;
        if (level >= res.size()) {
            res.add(new ArrayList<Integer>());
        }
        res.get(level).add(node.val);
        help(node.left, res, level + 1);
        help(node.right, res, level + 1);
    }
}