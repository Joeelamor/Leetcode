// Problem 709 To Lower Case

class Solution {
    public String toLowerCase(String str) {
        int diff = 'A' - 'a';
        StringBuilder lower = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z')
                lower.append((char)(c - diff));
            else
                lower.append(c);
        }
        return lower.toString();
    }
}