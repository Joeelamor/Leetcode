// Problem 160 Intersection of Two Linked Lists

/* If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLength(headA), b = getLength(headB);
        while(a > b) {
            headA = headA.next;
            a--;
        }
        while(a < b) {
            headB = headB.next;
            b--;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    public int getLength(ListNode node) {
        int length = 0;
        while(node != null) {
            node = node.next;
            length++;
        }
        return length;
    }
}