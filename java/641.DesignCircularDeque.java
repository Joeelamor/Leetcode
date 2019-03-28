// Question 641 Design Circular Deque

class MyCircularDeque {
    final int[] arr;
    int head = -1, tail = -1, count = 0;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        arr = new int[k];
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull())
            return false;
        head = (head - 1 + arr.length) % arr.length;
        if (isEmpty()) {
            tail = head;
        }
        arr[head] = value;
        count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull())
            return false;
        tail = (tail + 1) % arr.length;
        if (isEmpty()) {
            head = tail;
        }
        arr[tail] = value;
        count++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty())
            return false;
        head = (head + 1) % arr.length;
        count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty())
            return false;
        tail = (tail - 1 + arr.length) % arr.length;
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty())
            return -1;
        return arr[head];
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty())
            return -1;
        return arr[tail];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == arr.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */