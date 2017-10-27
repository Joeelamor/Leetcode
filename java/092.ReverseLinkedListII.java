// Problem 92 Reverse Linked List II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        ListNode first = pre.next;
        ListNode second = first.next;
        for (int i = 0; i < n - m; i++) {
            first.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = first.next;
        }
        return dummy.next;
    }
}