// Problem 144 Binary Tree Preorder Traversal

// Method 1: Recursive solution
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    public void preorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null)
            return;
        res.add(node.val);
        preorderTraversal(node.left, res);
        preorderTraversal(node.right, res);
    }
}

// Method 2: Iterative solution
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return res;
    }
}