// Question 707 Design Linked List

class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= size)
            return -1;
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode cur = new ListNode(val);
        cur.next = head;
        head = cur;
        if (tail == null)
            tail = head;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode cur = new ListNode(val);
        if (tail != null)
            tail.next = cur;
        if (tail == null)
            head = cur;
        tail = cur;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        if (index == 0) {
            addAtHead(val);
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        ListNode next = cur.next;
        ListNode newNode = new ListNode(val);
        cur.next = newNode;
        newNode.next = next;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size)
            return;
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size--;
                return;
            }
            head = head.next;
            size--;
            return;
        } else {
            ListNode cur = head;
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            if (index == size - 1) {
                tail = cur;
                tail.next = null;
                size--;
                return;
            }
            ListNode newNext = cur.next;
            cur.next = newNext.next;
            size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */