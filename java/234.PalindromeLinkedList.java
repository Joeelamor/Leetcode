// Problem 234 Palindrome Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head==null) return true;
        //Find middle node: use slow, fast pointers.
        ListNode fast = head.next;
        ListNode mid = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            mid = mid.next;
        }

        //Reverse: mid..end
        ListNode tail = reverse(mid);

        //Compare tail to mid and start to mid.
        while (tail !=null && head != null) {
            if (tail.val != head.val) {
                return false;
            }
            tail = tail.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head) {
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