// Problem 71 Simplify Path

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        for (String str: path.split("/")) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) 
                    stack.pop();
            } else if (str.length() > 0 && !str.equals(".")) stack.push(str);
        }
        String res = "";
        for (String str: stack) res = "/" + str + res;
        return res.equals("")? "/" : res;
    }
}