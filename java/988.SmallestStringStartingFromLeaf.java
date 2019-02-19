// Question 988 Smallest String Starting From Leaf

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


// Method 1:
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
        dfs(root, pq, new StringBuilder());
        return pq.poll();
    }
    void dfs(TreeNode node, PriorityQueue<String> pq, StringBuilder cur) {
        if (node == null)
            return;
        cur.append((char)(node.val + 'a'));
        if (node.left == null && node.right == null) {
            pq.offer(cur.reverse().toString());
            cur.reverse();
        }
        dfs(node.left, pq, cur);
        dfs(node.right, pq, cur);
        cur.deleteCharAt(cur.length() - 1); 
    }
}

// method 2:
class Solution {
	public String smallestFromLeaf(TreeNode root) {
	    return helper(root);
	}
    public String helper(TreeNode root){
        if(root != null){
            String l = helper(root.left);
            String r = helper(root.right);
            if(l.length() > 0 && r.length() > 0)
                return (( (l.compareTo(r)<0) ? l: r) + (char)(root.val+'a'));
            else if(l.length()>0)
                return l + (char)(root.val+'a');
            else
                return r + (char)(root.val+'a');
        }
        return "";
    }
}
