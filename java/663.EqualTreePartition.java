// Problem 663 Equal Tree Partition

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
    public boolean checkEqualTree(TreeNode root) {
    	// Use hashMap to store all sum of trees.
        Map<Integer, Integer> map = new HashMap<>();
        int sum = getSum(root, map);
        // If sum = 0, then find if the number of sum is bigger than 1, if it is , then return tree, or return false.
        if(sum == 0)
            return map.getOrDefault(sum, 0) > 1;
        // Check if the final sum is even, if it is, then check if the map contains sum/2, if so, return true.
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
    public int getSum(TreeNode node, Map<Integer, Integer> map) {
        if(node == null)
            return 0;
        int cur = node.val + getSum(node.left, map) + getSum(node.right, map);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        return cur;
    }
}