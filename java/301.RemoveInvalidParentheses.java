// Question 301 Remove Invalid Parentheses

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new LinkedList<>();
        helper(s, res, 0, 0, '(', ')');
        return res;
    }
    private void helper(String s, List<String> res, int iStart, int jStart, char left, char right) {
        int numLeft = 0, numRight = 0;
        for (int i = iStart; i < s.length(); i++) {
            if (s.charAt(i) == left) numLeft++;
            if (s.charAt(i) == right) numRight++;
            if (numRight > numLeft) {
                for (int j = jStart; j <= i; j++) {
                    if (s.charAt(j) == right && (j == jStart || s.charAt(j - 1) != right)) {
                        helper(s.substring(0, j) + s.substring(j + 1, s.length()), res, i, j, left, right);
                    }
                }
                return;
            }
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (left == '(') {
            helper(reversed, res, 0, 0, ')', '(');
        } else {
            res.add(reversed);
        }
    }
}