// Problem 155 Min Stack

// Use two stacks, one is push numbers, another one records min numbers
class MinStack {
    Stack<Integer> MinStack;
    Stack<Integer> mMinStack;

    /** initialize your data structure here. */
    public MinStack() {
        MinStack = new Stack<>();
        mMinStack = new Stack<>();
    }
    
    public void push(int x) {
        MinStack.push(x);
        if(mMinStack.size() != 0) {
            if(x <= mMinStack.peek())
                mMinStack.push(x);
        }
        else
            mMinStack.push(x);
    }
    
    public void pop() {
        int x = MinStack.pop();
        if(mMinStack.size() != 0) {
            if(x == mMinStack.peek())
                mMinStack.pop();
        }
    }
    
    public int top() {
        return MinStack.peek();
    }
    
    public int getMin() {
        return mMinStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */