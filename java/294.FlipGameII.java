// Problem 294 Flip Game II

class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2)
            return false;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i) == s.charAt(i + 1)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!canWin(t))
                    return true;
            }
        }
        return false;
    }
}