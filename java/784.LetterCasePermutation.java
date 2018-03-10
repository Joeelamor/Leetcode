// Problem 784 Letter Case Permutation

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        findPermutation(res, S.toCharArray(), 0);
        return res;
    }
    
    public void findPermutation(List<String> list, char[] s, int i) {
        if (i == s.length) {
            list.add(new String(s));
            return;
        }
        if (Character.isLetter(s[i])) {
            s[i] = Character.toLowerCase(s[i]);
            findPermutation(list, s, i + 1);
            s[i] = Character.toUpperCase(s[i]);
        }
        findPermutation(list, s, i + 1);
    }
}