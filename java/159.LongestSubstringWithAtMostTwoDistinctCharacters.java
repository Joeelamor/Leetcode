// Question 159 Longest Substring with At Most Two Distinct Characters

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 1)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int lo = 0, hi = 0, res = 0;
        while (hi < s.length()) {
            if (map.size() <= 2) {
                map.put(s.charAt(hi), hi);
                hi++;
            } 
            if (map.size() > 2) {
                int leftMost = Integer.MAX_VALUE;
                for (int value : map.values()) {
                    leftMost = Math.min(value, leftMost);
                }
                map.remove(s.charAt(leftMost));
                lo = leftMost + 1;
            }
            res = Math.max(res, hi - lo);
        }
        return res;
    }
}