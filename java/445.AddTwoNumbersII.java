// Problem 445 Add Two Numbers II

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	// Use two stack to keep the list value.
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode res = new ListNode(0);
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        int sum = 0;
        // Add them from right to left.
        while (!s1.empty() || !s2.empty()) {
            if (!s1.empty())
                sum += s1.pop();
            if (!s2.empty())
                sum += s2.pop();
            res.val = sum % 10;
            ListNode list = new ListNode(sum / 10);
            list.next = res;
            res = list;
            sum /= 10;
        }
        return res.val == 0? res.next : res;
    }
}