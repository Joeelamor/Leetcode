// Question 1003 Check If Word Is Valid After Substitutions

class Solution {
    public boolean isValid(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : S.toCharArray()) {
            if (ch == 'c') {
                if (stack.isEmpty() || stack.pop() != 'b')
                    return false;
                if (stack.isEmpty() || stack.pop() != 'a')
                    return false;
            } else 
                stack.push(ch);
        }
        return stack.isEmpty();
    }
}