// Problem 32 Longest Valid Parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                if (stack.empty()) start = i;
                else {
                    stack.pop();
                    if (stack.empty()) max = Math.max(max, i - start);
                    else max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}