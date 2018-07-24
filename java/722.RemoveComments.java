// Problem 722 Remove Comments

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (flag) {
                    if (s.charAt(i) == '*' && i + 1 < s.length() && s.charAt(i + 1) == '/') {
                        flag = false;
                        i++;
                    }
                } else {
                    if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '/')
                        break; // remaining characters have leading //
                    else if (s.charAt(i) == '/' && i + 1 < s.length() && s.charAt(i + 1) == '*') {
                        flag = true;
                        i++;
                    } else 
                        sb.append(s.charAt(i));
                }
            }
            if (!flag && sb.length() > 0) {
                res.add(sb.toString());
                sb.setLength(0);
            }
        }
        return res;
    }
}