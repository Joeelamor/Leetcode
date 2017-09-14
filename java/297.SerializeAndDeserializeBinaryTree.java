// Problem 297 Serialize And Deserialize Binary Tree

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
        buildString(root, sb);
        return sb.toString();
    }
    // Use DFS to product a string.
    public void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NULL).append(sep);
            return;
        }
        sb.append(node.val).append(sep);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String []node = data.split(",");
        // Use array to store initial number, then array can be recursively used.
        int[] i = new int[1];
        return dfs(node, i);
    }
    // Use dfs to encode data to tree.
    public TreeNode dfs(String[] node, int[] i) {
        if(node[i[0]].equals(NULL)) {
            i[0]++;
            return null;
        }
        TreeNode n = new TreeNode(Integer.parseInt(node[i[0]]));
        i[0]++;
        n.left = dfs(node, i);
        n.right = dfs(node, i);
        return n;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));