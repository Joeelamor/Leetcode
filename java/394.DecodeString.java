// Problem 394 Decode String

class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + (s.charAt(i) - '0');
            } else if (s.charAt(i) == '[') {
                int strStart = i;
                i++;
                int count = 1; 
                while (count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--; // the last index of ']'
                String str = decodeString(s.substring(strStart + 1, i));
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
                num = 0;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}