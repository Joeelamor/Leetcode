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


// Method 2: 
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                left++;
            if (c == ')') {
                if (left != 0)
                    left--;
                else
                    right++;
            }
        }
        HashSet<String> set = new HashSet<>();
        helper(s, set, 0, left, right, new StringBuilder(), 0);
        return new ArrayList<>(set);
    }
    
    public void helper(String s, Set<String> set, int idx, int left, int right, StringBuilder sb, int open) {
        if (left < 0 || right < 0 || open < 0)
            return;
        if (idx == s.length()) {
            if (left == 0 && right == 0 && open == 0)
                set.add(sb.toString());
            return;
        }
        char c = s.charAt(idx);
        if (c == '(') {
            helper(s, set, idx + 1, left - 1, right, sb, open);
            helper(s, set, idx + 1, left, right, sb.append(c), open + 1);
        } else if (c == ')' ) {
            helper(s, set, idx + 1, left, right - 1, sb, open);
            helper(s, set, idx + 1, left, right, sb.append(c), open - 1);
        } else {
            helper(s, set, idx + 1, left, right, sb.append(c), open);
        }
        sb.setLength(sb.length() - 1);
    }
}