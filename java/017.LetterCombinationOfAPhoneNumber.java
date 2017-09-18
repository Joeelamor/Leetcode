// Problem 17 Letter Combination Of A Phone Number

// Use DFS
class Solution {
    public String[] keys = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length() == 0)
            return res;
        combination("", digits, 0, res);
        return res;
    }
    public void combination(String prefix, String digits, int offset, List<String> res) {
        if(offset >= digits.length()) {
            res.add(prefix);
            return;
        }
        String letter = keys[(digits.charAt(offset) - '0')];
        for(int i = 0; i < letter.length(); i++) {
            combination(prefix + letter.charAt(i), digits, offset + 1, res);
        }
    }
}