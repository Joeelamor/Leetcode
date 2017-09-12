// Problem 199 Binary Tree Right Side View

// Method 1: BFS
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // Use BFS, traverse the tree from top to bottom
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                // Add the TreeNode into queue from right to left, then the first node is result.
                if(i == 0)
                    res.add(cur.val);
                if(cur.right != null)
                    q.offer(cur.right);
                if(cur.left != null)
                    q.offer(cur.left);
            }
        }
        return res;
    }
}

// Method 2: DFS, search from right child to left child.
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        rightView(root, res, 0);
        return res;
    }
    public void rightView(TreeNode cur, List<Integer> res, int depth) {
        if(cur == null)
            return;
        // Each level add one number, so depth should equal to List size.
        if(depth == res.size())
            res.add(cur.val);
        // First look at all right children to find results, then look at left children to find results.
        rightView(cur.right, res, depth + 1);
        rightView(cur.left, res, depth + 1);
    }
}