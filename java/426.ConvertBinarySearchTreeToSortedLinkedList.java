// Problem 426 Convert Binary Search Tree To Sorted Doubly Linked List

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        Node dummy = new Node(0, null, null);
        prev = dummy;
        helper(root);
        // connect head and tail
        prev.right = dummy.right;
        dummy.right.left = prev;
        return dummy.right;
    }
    
    private void helper(Node node) {
        if (node == null) return;
        helper(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        helper(node.right);
    }
}