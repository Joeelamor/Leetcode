// Problem 508 Most Frequent Subtree Sum

/* Use post order to traverse the tree to calculate each subtree sum and count the number, 
 * keep them in a hashMap and keep the the most frequent times, then back to the hashMap to 
 * find all of the nodes.
 */
 
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
    Map<Integer, Integer> map;
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<Integer, Integer>();
        postOrder(root);
        List<Integer> res = new ArrayList<>();
        for(int key: map.keySet()) {
            if(map.get(key) == max)
                res.add(key);
        }
        int []result = new int[res.size()];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    public int postOrder(TreeNode node) {
        if(node == null)
            return 0;
        int left = postOrder(node.left);
        int right = postOrder(node.right);
        int sum = left + right + node.val;
        int count = map.getOrDefault(sum, 0) + 1;
        map.put(sum, count);
        max = Math.max(max, count);
        return sum;
    }
}