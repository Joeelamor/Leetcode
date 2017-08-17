// Problem 83 Remove Duplicates from Sorted List

// This solution makes me more clear about list operations.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = head;
        while(newList != null) {
            if(newList.next == null)
                break;
            if(newList.val == newList.next.val)
                newList.next = newList.next.next;
            else
                newList = newList.next;
        }
        return head;
    }
}

// This solution uses recursion, pretty good.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
    }
}