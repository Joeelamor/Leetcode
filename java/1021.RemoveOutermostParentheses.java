// Question 1021 Remove Outermost Parentheses

// This is answer is for all inputs including invalid input.
class Solution {
    public String removeOuterParentheses(String S) {
        String res = "";
        int left = 0, i = 0;
        if (S.length() == 0)
            return res;
        while (i < S.length()) {
            if (S.charAt(i) == '(')
                left++;
            if (S.charAt(i) == ')')
                left--;
            if (left < 0)
                return "";
            if (left == 0) {
                if (helper(S.substring(1, i)))
                    res += (S.substring(1, i) + removeOuterParentheses(S.substring(i + 1)));
                else
                    res += removeOuterParentheses(S.substring(i + 1));
                break;
            }
            i++;
        }
        return res;
    }
    
    private boolean helper(String s) {
        if (s.length() == 0)
            return true;
        int left = 0, i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(')
                left++;
            if (s.charAt(i) == ')')
                left--;
            if (left < 0)
                return false;
            i++;
        }
        return left == 0;
    }
}