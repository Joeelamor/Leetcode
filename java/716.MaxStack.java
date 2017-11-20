// Problem 716 Max Stack

// Use two stacks
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> helper;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
     
    public void push(int x) {
        pushHelper(x);
    }
    private void pushHelper(int x) {
        int tmpMax = helper.isEmpty() ? Integer.MIN_VALUE : helper.peek();
        if (x > tmpMax) {
            tmpMax = x;
        }
        stack.push(x);
        helper.push(tmpMax);
    }
    
    public int pop() {
        helper.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return helper.peek();
    }
    
    public int popMax() {
        int max = helper.peek();
        Stack<Integer> tmp = new Stack<>();
        
        while (stack.peek() != max) {
            tmp.push(stack.pop());
            helper.pop();
        }
        stack.pop();
        helper.pop();
        while (!tmp.isEmpty()) {
            int x = tmp.pop();
            pushHelper(x);
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