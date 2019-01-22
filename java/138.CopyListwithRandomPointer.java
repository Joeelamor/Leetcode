// Problem 138 Copy List with Random Pointer

// Method 1: use hashMap to store node and random point
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while(cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        for(Map.Entry<RandomListNode, RandomListNode> entry: map.entrySet()) {
            RandomListNode newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }
}

// Method 2: O(1) space, O(n) time

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head, next;
        // 1. insert copy to the original list
        while (iter != null) {
            next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        // 2. copy random
        iter = head;
        while (iter != null) {
            if (iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        // 3. extract copy list from list
        iter = head;
        RandomListNode newHead = new RandomListNode(0);
        RandomListNode copy, copyIter = newHead;
        while (iter != null) {
            next = iter.next.next;
            // extract
            copy = iter.next;
            copyIter.next = copy;
            copyIter = copy;
            
            iter.next = next;
            iter = next;
        }
        return newHead.next;
    }
}