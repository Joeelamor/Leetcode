// Problem 662 Maximum Width of Binary Tree

/* The idea is to traverse all the node in the tree in level order(Here I use one Queue to 
 * store each level's nodes. The time I traverse each level is the queue's size(the number 
 * of nodes from upper level)). Each time a node is traversed, the position of the node(as 
 * it is in a full binary tree) is stored in the HashMap. If the position of the parent 
 * node is 'n', then the left child is '2 * n' and the right child is '2 * n + 1'. The 
 * width of each level is the last node's position in this level subtracts the first node's * position in this level plus 1.
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>(); // Use BFS
        Map<TreeNode, Integer> map = new HashMap<>();
        int max = 0, cur = 0;
        q.offer(root);
        map.put(root, 1);
        while(!q.isEmpty()) {
            int size = q.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i == 0)
                    start = map.get(node);
                if(i == size - 1)
                    end = map.get(node);
                if(node.left != null) {
                    q.offer(node.left);
                    map.put(node.left, map.get(node) * 2);
                }
                if(node.right != null) {
                    q.offer(node.right);
                    map.put(node.right, map.get(node) * 2 + 1);
                }
            }
            cur = end - start + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}