// Problem 844 Backspace String Compare

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return str(S).equals(str(T));
    }
    private String str(String input) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '#') res.append(input.charAt(i));
            // // If current character is '#' delete one character from last, and handle cases when res is emtpy
            else res.setLength(Math.max(res.length() - 1, 0));
        }
        return res.toString();
    }
}