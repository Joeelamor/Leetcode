// Problem 671 Second Minimum Node In A Binary Tree

/**
*Given a non-empty special binary tree consisting of nodes with the non-negative value, 
*where each node in this tree has exactly two or zero sub-node. If the node has 
*two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
*Given such a binary tree, you need to output the second minimum value in the set 
*made of all the nodes' value in the whole tree.
*If no such second minimum value exists, output -1 instead.
*/
//   Input: 
//     2
//    / \
//   2   5
//      / \
//     5   7

// Output: 5
// Explanation: The smallest value is 2, the second smallest value is 5.

// Input: 
//     2
//    / \
//   2   2

// Output: -1
// Explanation: The smallest value is 2, but there isn't any second smallest value.

// A stupid method: store all number in a ArrayList and sort it, then find the second smallest one
// You could use this method unless you have no others!!!
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
    public int findSecondMinimumValue(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        help(root, set);
        List<Integer> lst = new ArrayList(set);
        Collections.sort(lst);
        if (lst.size() < 2) {
            return -1;
        } else {
            return lst.get(1);
        }
    }
    
    private void help(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return;
        }
        
        set.add(node.val);
        help(node.left, set);
        help(node.right, set);
    }
}

// Method 2: A normal method: 