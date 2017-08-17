// Problem 257 Binary Tree Paths

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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if(root != null)
            findPath(root, "", answer);
        return answer;
    }
    
    public void findPath(TreeNode root, String path, List<String> answer) {
        if(root.left == null && root.right == null)
            answer.add(path + root.val);
        if(root.left != null)
            findPath(root.left, path + root.val + "->", answer);
        if(root.right != null)
            findPath(root.right, path + root.val + "->", answer);
    }
}