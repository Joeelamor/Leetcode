// Problem 314 Binary Tree Vertical Order Traversal

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        res.add(new LinkedList<>());
        int leftMost = 0, rightMost = 0;
        Queue<TreeNode> qNode = new LinkedList<>();
        Queue<Integer> qIndex = new LinkedList<>();
        qNode.offer(root);
        qIndex.offer(0);
        while (!qNode.isEmpty()) {
            TreeNode node = qNode.poll();
            int cur = qIndex.poll();
            // put current node val into the specific column in result.
            res.get(cur - leftMost).add(node.val);
            if (node.left != null) {
                // check if there is a new leftMost.
                // if it is, update leftMost and add a new list in the head.
                if (cur - 1 < leftMost) {
                    leftMost = cur - 1;
                    res.addFirst(new LinkedList<>());
                }
                // put current node and index into queues.
                qNode.offer(node.left);
                qIndex.offer(cur - 1);
            }
            if (node.right != null) {
                // check if there is a new rightMost.
                // if it is, update rightMost and add a new list in the tail.
                if (cur + 1 > rightMost) {
                    rightMost = cur + 1;
                    res.add(new LinkedList<>());
                }
                // put current node and index into queues.
                qNode.offer(node.right);
                qIndex.offer(cur + 1);
            }
        }
        return res;
    }
}