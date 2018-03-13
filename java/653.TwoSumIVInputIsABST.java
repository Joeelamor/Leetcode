// Problem 653 Two Sum IV - Input Is A BST

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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        addNum(list, root);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) == k) return true;
            if (list.get(i) + list.get(j) < k) i++;
            else j--;
        }
        return false;
    }
    public void addNum(ArrayList<Integer> list, TreeNode node) {
        if (node == null) return;
        addNum(list, node.left);
        list.add(node.val);
        addNum(list, node.right);
    }
}


// Method 2

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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return findTarget(root, set, k);
    }
    public boolean findTarget(TreeNode node, HashSet<Integer> set, int target) {
        if (node == null) 
            return false;
        if (set.contains(target - node.val)) {
            return true;
        }
        set.add(node.val);
        return findTarget(node.left, set, target) || findTarget(node.right, set, target);
    }
}