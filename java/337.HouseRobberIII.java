// Problem 337 House Robber III

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Use DFS, each node include rob and not rob, so we use 0 denotes rob this house, 1 denotes not rob this house.
class Solution {
    public int rob(TreeNode root) {
        int []num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    
    public int[] dfs(TreeNode node) {
        if(node == null)
            return new int[2];
        int []left = dfs(node.left);
        int []right = dfs(node.right);
        int []res = new int[2];
        // If rob this house, so two children houses are not robbed.
        res[0] = left[1] + right[1] + node.val;
        // If not rob this house, so select two maximum rob of its children.
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return res;
    }
}