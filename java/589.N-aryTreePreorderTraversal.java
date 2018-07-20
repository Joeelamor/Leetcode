// Problem 589 N-ary Tree Preorder Traversal

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> list = new LinkedList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        for (Node next : root.children) {
            preorder(next);
        }
        return list;
    }
}

