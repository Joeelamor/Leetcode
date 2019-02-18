// Question 993 Cousins in Binary Tree

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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null)
            return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size(), xx = -1, yy = -1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur == null)
                    continue;
                if (cur.val == x)
                    xx = i;
                if (cur.val == y)
                    yy = i;
                q.offer(cur.left);
                q.offer(cur.right);
            }
            if ((xx % 2 == 0 && yy == xx + 1) || (yy % 2 == 0 && xx == yy + 1))
                return false;
            if (xx != -1 && yy != -1)
                return true;
        }
        return false;
    }
}