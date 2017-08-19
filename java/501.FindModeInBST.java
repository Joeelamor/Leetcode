// Problem 501 Find Mode in BST

// Inorder tranverse the BST
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
    Integer prev = null;
    int count = 1, max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        inorderTranverse(root, list);
        int []res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) 
            res[i] = list.get(i);
        return res;
    }
    public void inorderTranverse(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        inorderTranverse(root.left, list);
        if(prev != null) {
            if(root.val == prev)
                count++;
            else
                count = 1;
        }
        if(count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        }
        else if(count == max)
            list.add(root.val);
        prev = root.val;
        inorderTranverse(root.right, list);
    }
}