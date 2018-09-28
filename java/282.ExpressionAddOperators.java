// Question 282 Expression Add Operators

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0)
            return res;
        findString(res, num, target, "", 0, 0, 0);
        return res;
    }
    
    private void findString(List<String> res, String num, int target, String path, int start, long cur, long prod) {
        if (start == num.length()) {
            if (target == cur) {
                res.add(path);
            }
        }
        for (int i = start; i < num.length(); i++) {
            if (i != start && num.charAt(start) == '0') 
                break;
            long n = Long.parseLong(num.substring(start, i + 1));
            if (start == 0) {
                findString(res, num, target, path + n, i + 1, n, n);
            } else {
                findString(res, num, target, path + "+" + n, i + 1, cur + n, n);
                findString(res, num, target, path + "-" + n, i + 1, cur - n, -n);
                findString(res, num, target, path + "*" + n, i + 1, cur - prod + n * prod, n * prod);
            }
        }
    }
}