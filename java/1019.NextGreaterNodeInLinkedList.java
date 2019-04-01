// Question 1019 Next Greater Node In Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int[] res = new int[arr.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < arr.size(); i++) {
            while (!stack.isEmpty() && arr.get(stack.peek()) < arr.get(i)) {
                res[stack.pop()] = arr.get(i);
            }
            stack.push(i);
        }
        return res;
    }
}