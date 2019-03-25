622 Design Circular Queue

class MyCircularQueue {

    int head = 0, tail = -1, count = 0;
    final int[] arr;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        tail = (tail + 1) % arr.length;
        arr[tail] = value;
        count++;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) 
            return false;
        head = (head + 1) % arr.length;
        count--;
        return true;
        
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty())
            return -1;
        return arr[head];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[tail];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == arr.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */