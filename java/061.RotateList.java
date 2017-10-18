// Problem 61 Rotate List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        ListNode fast = dummy, slow = dummy;
        dummy.next=head;
        int i;
        //Get the total length 
        for (i = 0; fast.next != null; i++) 
            fast = fast.next;
		//Get the i-n%i th node
        for (int j = i - k % i; j > 0; j--) 
            slow = slow.next;
        //Do the rotation
        fast.next = dummy.next; 
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}