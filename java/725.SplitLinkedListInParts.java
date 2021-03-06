// Problem 725 Split Linked List In Parts

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        int len = 0;
        for (ListNode node = root; node != null; node = node.next) len++;
        int n = len / k, r = len % k;
        ListNode node = root, prev = null;
        for (int i = 0; node != null && i < k; i++, r--) {
            res[i] = node;
            for (int j = 0; j < n + (r > 0 ? 1 : 0); j++) {
                prev = node;
                node = node.next;
            }
            prev.next = null;
        } 
        return res;
    }
}