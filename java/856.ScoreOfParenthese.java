// Problem 856 Score Of Parenthese

class Solution {
    public int scoreOfParentheses(String S) {
        int res = 0, layer = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(')
                layer++;
            else
                layer--;
            if (S.charAt(i) == '(' && S.charAt(i + 1) == ')')
                res += 1 << (layer - 1);
        }
        return res;
    }
}