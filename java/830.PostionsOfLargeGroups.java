// Problem 830 Postions Of Large Groups

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < S.length()) {
            while (right < S.length() && S.charAt(left) == S.charAt(right)) right++;
            if (right - left >= 3) res.add(Arrays.asList(left, right - 1));
            left = right;
        }
        return res;
    }
}