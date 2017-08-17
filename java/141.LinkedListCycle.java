// Problem 141 Linked List Cycle

// You can make use of Floyd's cycle-finding algorithm, also know as tortoise and hare 
// algorithm. The idea is to have two references to the list and move them at different 
// speeds. Move one forward by 1 node and the other by 2 nodes. If the linked list has a 
// loop they will definitely meet.

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
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker == runner)
                return true;
        }
        return false;
    }
}