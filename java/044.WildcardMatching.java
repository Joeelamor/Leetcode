// Question 44 Wildcard Matching

class Solution {
    public boolean isMatch(String s, String p) {
        int startS = 0, startP = 0, markS = 0, markP = -1;
        while (startS < s.length()) {
            if (startP < p.length() && (p.charAt(startP) == '?' || p.charAt(startP) == s.charAt(startS))) {
                startS++;
                startP++;
            } else if (startP < p.length() && p.charAt(startP) == '*') {
                markS = startS;
                markP = startP;
                startP++;
            } else if (markP != -1) {
                startP = markP + 1;
                markS++;
                startS = markS;
            } else 
                return false;
        }
        while (startP < p.length() && p.charAt(startP) == '*') {
            startP++;
        }
        return startP == p.length();
    }
}