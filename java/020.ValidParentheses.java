// Problem 20 Valid Parentheses

/* This is a good solution that I learned from other's.(In this kind of question, 
 * we need to use stack) */

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

// My universal method
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if(c == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(c == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else if(c == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}