// Problem 93 Restore IP Address

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        for (int a = 1; a < 4 && a < s.length() - 2; a++) {
            for (int b = a + 1; b < a + 4 && b < s.length() - 1; b++) {
                for (int c = b + 1; c < b + 4 && c < s.length(); c++) {
                    String sec1 = s.substring(0, a);
                    String sec2 = s.substring(a, b);
                    String sec3 = s.substring(b, c);
                    String sec4 = s.substring(c);
                    if (valid(sec1) && valid(sec2) && valid(sec3) && valid(sec4))
                        res.add(sec1 + '.' + sec2 + '.' + sec3 + '.' + sec4);
                }
            }
        }
        return res;
    }
    
    private boolean valid(String str) {
        if ((str.length() > 1 && str.charAt(0) == '0') ||Integer.parseInt(str) > 255)
            return false;
        else 
            return true;
    }
}