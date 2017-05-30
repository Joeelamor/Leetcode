// Problem 108 Convert Sorted Array to Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root = findNode(nums, 0, nums.length - 1);
        return root;
    }
    public TreeNode findNode(int[] nums, int low, int high) {
        if(low > high)
            return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = findNode(nums, low, mid - 1);
        node.right = findNode(nums, mid + 1, high);
        return node;
    }
}