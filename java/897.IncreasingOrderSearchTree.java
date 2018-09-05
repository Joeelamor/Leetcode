// Question 897 Increasing Order Search Tree

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
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        inorder(root, list);
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        for (int value : list) {
            cur.right = new TreeNode(value);
            cur = cur.right;
        }
        return res.right;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null)
            return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}