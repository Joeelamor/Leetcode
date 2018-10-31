// Problem 124 Binary Tree Maximum Path Sum

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
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    private int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}

// Record Path

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
    int max = Integer.MIN_VALUE;
    List<Integer> res = new ArrayList<>();
    public int maxPathSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list, true);
        System.out.println(res);
        return max;
    }
    private int helper(TreeNode node, List<Integer> list, boolean isLeft) {
        if (node == null) return 0;
        
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        int left = Math.max(0, helper(node.left, leftList, true));
        int right = Math.max(0, helper(node.right, rightList, false));
        
        if (left >= right) {
            list.addAll(leftList);
        } else {
            list.addAll(rightList);
        }
        
        if (isLeft)
            list.add(node.val);
        else
            list.add(0, node.val);
        
        if (max < left + right + node.val) {
            max = left + right + node.val;
            res = new ArrayList<>();
            res.addAll(leftList);
            res.add(node.val);
            res.addAll(rightList);
            
        }
        // max = Math.max(max, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}