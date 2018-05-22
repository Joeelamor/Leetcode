// Problem 143 Reorder List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        // Find the middle val of the list.
        ListNode node1 = head;
        ListNode node2 = head;
        while (node2.next != null && node2.next.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        
        // Reverse the half after middle val
        ListNode preMid = node1;
        ListNode preCur = node1.next;
        while (preCur.next != null) {
            ListNode cur = preCur.next;
            preCur.next = cur.next;
            cur.next = preMid.next;
            preMid.next = cur;
        }
        
        // Order one by one.
        node1 = head;
        node2 = preMid.next;
        while (node1 != preMid) {
            preMid.next = node2.next;
            node2.next = node1.next;
            node1.next = node2;
            node1 = node2.next;
            node2 = preMid.next;
        }
    }
}