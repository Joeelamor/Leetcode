// Problem 109 Convert Sorted List To Binary Search Tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
        return help(head, null);
    }
    public TreeNode help(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if (head == tail)
            return null;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = help(head, slow);
        root.right = help(slow.next, tail);
        return root;
    }
}