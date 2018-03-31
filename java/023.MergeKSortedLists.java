// Problem 23 Merge K Sorted Lists

// Method 1: Divide and conquer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }
    
    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start >= end) return lists[start];
        int mid = start + (end - start) / 2;
        ListNode left = helper(lists, start, mid);
        ListNode right = helper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } 
        l2.next = merge(l2.next, l1);
        return l2;
    }
}

// Method 2: PriorityQueue
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> q = new PriorityQueue<>((x, y) -> (x.val - y.val));
        for (ListNode n: lists){
            if (n != null) {
                q.add(n);
            }
        }
        ListNode head = new ListNode(0), p = head, cur = null;
        while(!q.isEmpty()) {
            cur = q.poll();
            if(cur.next != null)
                q.offer(cur.next);
            p.next = cur;
            p = p.next;
        }
        return head.next;
    }
}