// Problem 443 String Compression

class Solution {
    public int compress(char[] chars) {
        int len = chars.length, next = 0;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            int count = 0;
            while (i < len && chars[i] == c) {
                count++;
                i++;
            }
            i--;
            chars[next] = c;
            next++;
            if (count > 1) {
                String s = Integer.toString(count);
                for (int j = 0; j < s.length(); j++) {
                    chars[next] = s.charAt(j);
                    next++;
                }
            }
        }
        return next;
    }
}