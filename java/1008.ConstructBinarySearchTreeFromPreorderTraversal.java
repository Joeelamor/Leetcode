// Question 1008 Construct Binary Search Tree from Preorder Traversal

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Method 1: Worst Case O(n ^ 2) time
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length - 1);
    }
    
    TreeNode helper(int[] preorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(preorder[left]);
        int i = left + 1;
        for (; i <= right; i++) {
            if (preorder[i] > root.val)
                break;
        }
        root.left = helper(preorder, left + 1, i - 1);
        root.right = helper(preorder, i, right);
        return root;
    }
}

// Method 2: O(n) time

class Solution {
    int i;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 10000000);
    }
    
    private TreeNode dfs(int[] p, int bound){
        if(i>=p.length || p[i] > bound)
            return null;
        TreeNode root = new TreeNode(p[i++]);
        root.left = dfs(p,root.val);
        root.right = dfs(p,bound);
        return root;
            
    }
}