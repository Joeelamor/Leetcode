// Problem 285 Inorder Successor In BST

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Successor
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left; 
        }
    }
}


// Predecessor
class Solution {
	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null) return null;
		if (root.val >= p.val) return predecessor(root.left, p);
		else {
		    TreeNode right = predecessor(root.right, p);
		    return right == null ? root : left;
		}
	}
}