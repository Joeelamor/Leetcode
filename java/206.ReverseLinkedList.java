// Problem 206 Reverse Linked List

// Use two pointers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head != null && head.next != null) {
            ListNode pivot = head;
            ListNode frontier = null;
            while(pivot != null && pivot.next != null) {
                frontier = pivot.next;
                pivot.next = pivot.next.next;
                frontier.next = head;
                head = frontier;
            }
        }
        return head;
    }
}

// Use only one pointer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}