// Problem 147 Insertion Sort List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null) {
            pre = dummy;
            /* If the last node val is smaller than the cur val, then add the cur val to the last,
             * if the last node val is bigger than the cur val, then all to the position before the last node which is bigger than the cur node.
             */ 
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        return dummy.next;
    }
}