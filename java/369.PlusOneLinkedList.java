// Problem 369 Plus One Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast.next != null) {
            if (fast.val != 9) {
                slow = fast;
            }
            fast = fast.next;
        }
        if (fast.val != 9) {
            fast.val++;
            return head;
        } else {
            slow.val++;
            slow = slow.next;
        }
        while (slow != null) {
            slow.val = 0;
            slow = slow.next;
        }
        return dummy.val == 0 ? dummy.next : dummy;
    }
} 