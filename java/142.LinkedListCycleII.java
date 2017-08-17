// 142 Linked List Cycle II

/* This problem is a follow-up of 141-Linked List Cycle. After finding a cycle in 
 * linked list, then find the beginner. And I will explain the second while in loop.
 * We assume that the distance between head and cycle beginner is a, and the distance 
 * between cycle beginner and meeting point is b, and assume the distance that runner
 * moves more than walker is X, so we have a + b + X = 2(a + b), so X = a + b, at 
 * this time, we know the distance between cycle beginner and meeting point is
 * a + b - b = a, which equals to the distance between head and cycle beginner.
 * therefore, we have second while to find the beginner. */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null)
            return null;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner) {
                ListNode beginner = head;
                while(beginner != walker) {
                    beginner = beginner.next;
                    walker = walker.next;
                }
                return beginner;
            }
        }
        return null;
    }
}