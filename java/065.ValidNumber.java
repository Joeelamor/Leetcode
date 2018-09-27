// Question 65 Valid Number

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numBeforeE = false;
        boolean numAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                if (eSeen) 
                    numAfterE = true;
                else
                    numBeforeE = true;
            } else if (c == 'e') {
                if (eSeen)
                    return false;
                eSeen = true;
            } else if (c == '.') {
                if (eSeen || dotSeen)
                    return false;
                dotSeen = true;
            } else if (c == '+' || c == '-') {
                if (i != 0 && s.charAt(i - 1) != 'e')
                    return false;
            } else {
                return false;
            }
        }
        return eSeen ? (numBeforeE && numAfterE) : numBeforeE
    } 
}