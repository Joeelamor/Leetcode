// Problem 22 Generate Parentheses

// Use trackbacking
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate("", res, n, n);
        return res;
    }
    public void generate(String subList, List<String> res, int left, int right) {
        if(left > right)
            return;
        if(left > 0)
            generate(subList + "(", res, left - 1, right);
        if(right > 0)
            generate(subList + ")", res, left, right - 1);
        if(left == 0 && right == 0) {
            res.add(subList);
            return;
        }
    }
}