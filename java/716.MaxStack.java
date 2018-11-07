// Problem 716 Max Stack

// Use two stacks
class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        if (maxStack.isEmpty() || x >= maxStack.peek())
            maxStack.push(x);
        stack.push(x);
    }
    
    public int pop() {
        int x = stack.pop();
        if (maxStack.peek() == x)
            maxStack.pop();
        return x;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Deque<Integer> cur = new ArrayDeque<>();
        while (stack.peek() != max) {
            cur.push(stack.pop());
        }
        stack.pop();
        maxStack.pop();
        while (!cur.isEmpty()) {
            int x = cur.pop();
            push(x);
        }
        return max;
    }
}


/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */