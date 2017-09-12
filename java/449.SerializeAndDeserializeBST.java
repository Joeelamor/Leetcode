// Problem 449 Serialize And Deserialize BST

// Need a compact algorithm, because of BST, then we can use its property, left child is less than root, right child is more than root.
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String sep = ",";
    String NULL = "null";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null)
            return NULL;
        // Use preorder traverse the tree to store into a string
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            sb.append(node.val).append(sep);
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(NULL))
           return null;
        String []strs = data.split(sep);
        Queue<Integer> q = new LinkedList<>();
        for(String s: strs) {
            q.offer(Integer.parseInt(s));
        }
        return getNode(q);
    }
    public TreeNode getNode(Queue<Integer> q) {
        if(q.isEmpty()) 
            return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> subQueue = new LinkedList<>();
        // Use property of BST, to find left children and right children
        while(!q.isEmpty() && q.peek() < root.val) {
            subQueue.offer(q.poll());
        }
        root.left = getNode(subQueue);
        root.right = getNode(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));