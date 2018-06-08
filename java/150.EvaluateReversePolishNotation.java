// Problem 150 Evaluate Reverse Polish Notation

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int a, b;
        for (String token: tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}