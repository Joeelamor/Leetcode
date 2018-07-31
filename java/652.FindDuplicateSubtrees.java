// Question 652 Find Duplicate Subtrees

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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        LinkedList<TreeNode> res = new LinkedList<>();
        helper(root, map, res);
        return res;
    }
    private String helper(TreeNode node, Map<String, Integer> map, List<TreeNode> list) {
        if (node == null) return "";
        String s = "(" + helper(node.left, map, list) + node.val + helper(node.right, map, list) + ")";
        if (map.getOrDefault(s, 0) == 1) list.add(node);
        map.put(s, map.getOrDefault(s, 0) + 1);
        return s;
    }
}