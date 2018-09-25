// Question 889 Construct Binary Tree from Preorder and Postorder Traversal

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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; i++) {
            TreeNode node = new TreeNode(pre[i]);
            while (post[j] == q.getLast().val) {
                q.pollLast();
                j++;
            }
            if (q.getLast().left == null)
                q.getLast().left = node;
            else 
                q.getLast().right = node;
            q.offer(node);
        }
        return q.getFirst();
    }
}



method 2:
class Solution {
Map<Integer, Integer> postMap = new HashMap<>();

public TreeNode constructFromPrePost(int[] pre, int[] post) {
    int length = pre.length;
    for(int i = 0; i < post.length; i++) {
        postMap.put(post[i], i);
    }
    
    return build(0, length - 1, 0, length - 1, pre, post);
}

private TreeNode build(int preLeft, int preRight, int postLeft, int postRight, int[] pre, int[] post) {
    if(preLeft > preRight || postLeft > postRight) {
        return null;
    }
    
    TreeNode root = new TreeNode(pre[preLeft]);
    
    if(preLeft + 1 <= preRight) {
        int index = postMap.get(pre[preLeft + 1]);
        int sum = index - postLeft;
        root.left = build(preLeft + 1, preLeft + sum + 1, postLeft, postLeft + sum, pre, post);
        root.right = build(preLeft + sum + 2, preRight, postLeft + sum + 1, postRight - 1, pre, post);
    }

    return root;
}}